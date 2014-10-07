package com.tvh.test.pages;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class RandomizeNumber {
	protected static final StringBuffer verificationErrors = new StringBuffer();
	
	public static void WriteFile(int incrementnumber) throws IOException{
		 OutputStreamWriter writer = null;
		 FileOutputStream fileout1 =null;
		
			fileout1 = new FileOutputStream("randomNumber.txt",false);
			writer = new OutputStreamWriter(fileout1);
			writer.write(incrementnumber + "");
			writer.close();
			
	  }
	
    public static int FileReader() {
        try {
            BufferedReader myReader =
                    new BufferedReader(new FileReader("randomNumber.txt"));
            int incrementnumber = Integer.parseInt(myReader.readLine()); 
           
            myReader.close();
        
            return incrementnumber;
            
        } catch(FileNotFoundException e){

        } catch(IOException e){

        }
		return 0;
        
    }
	

}
