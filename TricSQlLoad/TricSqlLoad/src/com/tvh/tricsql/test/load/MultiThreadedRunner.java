package com.tvh.tricsql.test.load;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * Runs all tests in parallel and waits for them to complete. 
 * Up to {@link #maxThreads} will be run at once.
 * 
 * @author Michael Sokolov
 */
public class MultiThreadedRunner extends BlockJUnit4ClassRunner {
    
    private AtomicInteger numThreads;

    private AtomicInteger finishedThreads;
    
    public static int maxThreads = 1;
    
    public MultiThreadedRunner (Class<?> klass) throws InitializationError {
        super (klass);
        numThreads = new AtomicInteger(0);
        finishedThreads = new AtomicInteger(0);
    }
    
    @Override
    protected void runChild(final FrameworkMethod method, final RunNotifier notifier) {
        while (numThreads.get() < maxThreads) {
            try {
                Thread.sleep(25);
                
                numThreads.incrementAndGet();
                new Thread (new Test(method, notifier)).start();
                
            } catch (InterruptedException e) {
                System.err.println ("Interrupted: " + method.getName());
                e.printStackTrace();
                return; // The user may have interrupted us; this won't happen normally
            }
        }
    }
    
    @Override
    protected Statement childrenInvoker(final RunNotifier notifier) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                MultiThreadedRunner.super.childrenInvoker(notifier).evaluate();
                // wait for all child threads (tests) to complete
                while (finishedThreads.get() < maxThreads) {
                    Thread.sleep(25);
                }
            }
        };
    }
  
    
    
    class Test implements Runnable {
        private final FrameworkMethod method;
        private final RunNotifier notifier;
        
        public Test (final FrameworkMethod method, final RunNotifier notifier) {
            this.method = method;
            this.notifier = notifier;
        }
        
        @Override
        public void run () {
            // System.err.println (method.getName());
            MultiThreadedRunner.super.runChild(method, notifier);
            finishedThreads.incrementAndGet();
        }
    }
    
}

/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/. */


