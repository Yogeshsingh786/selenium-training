package automation.commonUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

	public static Properties getPropertiesFromFile(String filePath) throws FileNotFoundException, IOException {
		File propertyFile = new File(filePath);
		Properties p=new Properties();
		if(propertyFile.exists()) {
			p.load(new FileReader(propertyFile));
			return p;
		}
		return null;
	}
	
}
