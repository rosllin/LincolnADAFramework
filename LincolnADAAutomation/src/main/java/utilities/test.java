package utilities;

import java.io.FileReader;
import java.util.Properties;

public class test {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		try {
			FileReader reader = new FileReader("src/test/resources/config/configProperties.properties");
			prop.load(reader);
			System.out.println(prop.getProperty("Browser"));
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}

}
