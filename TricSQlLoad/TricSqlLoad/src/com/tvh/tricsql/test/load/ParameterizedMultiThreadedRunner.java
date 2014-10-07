package com.tvh.tricsql.test.load;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

import com.tvh.tricsql.test.load.util.GlobalSettings;
import com.tvh.tricsql.test.load.util.TestDataLoader;

public class ParameterizedMultiThreadedRunner extends Suite  {

	protected class ParametrizedRunner extends BlockJUnit4ClassRunner {
		
		private final int fParameterSetNumber;

		private final List<Object[]> fParameterList;
		
		public ParametrizedRunner(Class<?> type,
				List<Object[]> parameterList, int i) throws InitializationError {
			super(type);
			fParameterList= parameterList;
			fParameterSetNumber= i;
		}

		@Override
		public Object createTest() throws Exception {
			return getTestClass().getOnlyConstructor().newInstance(
					computeParams());
		}

		private Object[] computeParams() throws Exception {
			try {
				return fParameterList.get(fParameterSetNumber);
			} catch (ClassCastException e) {
				throw new Exception(String.format(
						"%s.%s() must return a Collection of arrays.",
						getTestClass().getName(), getParametersMethod(
								getTestClass()).getName()));
			}
		}

		@Override
		protected String getName() {
			
			return String.format("Tets number [%s] and parameters:[%s] ", fParameterSetNumber, 
					( !(fParameterList.get(fParameterSetNumber) == null) 
							&& !(fParameterList.get(fParameterSetNumber).length == 0) ) ?
					fParameterList.get(fParameterSetNumber)[0].toString() : "");
		}

		@Override
		protected String testName(final FrameworkMethod method) {
			return String.format("%s[%s]", method.getName(),
					fParameterSetNumber);
		}

		@Override
		protected void validateConstructor(List<Throwable> errors) {
			validateOnlyOneConstructor(errors);
		}

		@Override
		protected Statement classBlock(RunNotifier notifier) {
			return childrenInvoker(notifier);
		}
	}
	
	private final ArrayList<Runner> runners= new ArrayList<Runner>();

	/**
	 * Only called reflectively. Do not use programmatically.
	 */
	public ParameterizedMultiThreadedRunner(Class<?> klass) throws Throwable {
		super(klass, Collections.<Runner>emptyList());
		final List<Object[]> parametersList= getParametersList(getTestClass());
		for (int i= 0; i < parametersList.size(); i++) {
			ParametrizedRunner runner = new ParametrizedRunner(getTestClass().getJavaClass(),
					parametersList, i);
		
			runners.add(runner);
		}
		
		boolean runInParallel = Boolean.valueOf(
				TestDataLoader.getInstance().getSetting(GlobalSettings.RUN_IN_PARALLEL));
		
		if (runInParallel) {
			setScheduler(new RunnerScheduler() {
					
				private final ExecutorService fService = Executors.newFixedThreadPool(parametersList.size());
				
				@Override
				public void schedule(Runnable childStatement) {
					fService.submit(childStatement);
				}
	
				@Override
				public void finished() {
				 try {
	                    fService.shutdown();
	                    fService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	                } catch (InterruptedException e) {
	                    e.printStackTrace(System.err);
	                }
				}
				
			});
		}
	}

	@Override
	protected List<Runner> getChildren() {
		return runners;
	}

	@SuppressWarnings("unchecked")
	private List<Object[]> getParametersList(TestClass klass)
			throws Throwable {
		return (List<Object[]>) getParametersMethod(klass).invokeExplosively(
				null);
	}

	private FrameworkMethod getParametersMethod(TestClass testClass)
			throws Exception {
		List<FrameworkMethod> methods= testClass
				.getAnnotatedMethods(Parameters.class);
		for (FrameworkMethod each : methods) {
			int modifiers= each.getMethod().getModifiers();
			if (Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers))
				return each;
		}

		throw new Exception("No public static parameters method on class "
				+ testClass.getName());
	}
}
