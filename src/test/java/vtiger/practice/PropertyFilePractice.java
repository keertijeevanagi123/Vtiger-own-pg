package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	

	public static void main(String[] args) throws IOException {
		//step1: Load the file in java readable format using file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2: create an object of properties from java.util
        Properties pobj = new Properties();
        
        //step3: Load file input stream into properties
          pobj.load(fis);
          
          
        //step4 : using the keys read the value
        String BROWSER = pobj.getProperty("browser");
        System.out.println(BROWSER);

	}

}

