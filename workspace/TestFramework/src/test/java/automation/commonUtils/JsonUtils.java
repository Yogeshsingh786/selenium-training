package automation.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;


/**
 * This utility is for JSON with following operations<br>
 * 1. reading JSON file <br>
 * 2. writing into JSON object<br>
 * 3. modifying JSON object <br>
 * 4. merging JSON object<br>
 * 
 * @author YSingh
 *
 */
public class JsonUtils {


	/**
	 * this method reads the file from given filePath and returns file content as
	 * JSON object
	 * 
	 * @param objRepoFolderPath
	 * @return
	 * @throws FileNotFoundException - if file is not present at filePath
	 */
	public static JsonObject getObjectRepositories(String objRepoFolderPath) {
		File jsonInputFile = new File(objRepoFolderPath);
		File[] allObjRepoFiles;
		InputStream is = null;
		JsonObject objectRepo = null;
		if(jsonInputFile.isDirectory()) {
			allObjRepoFiles = jsonInputFile.listFiles(new FilenameFilter() {
				
				public boolean accept(File dir, String name) {
					return name.endsWith(".json");
					
				}
			});
			
			for(File jsonFile:allObjRepoFiles) {
				try {
					is = new FileInputStream(jsonFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				// Create JsonReader from JSON.
				JsonReader reader = Json.createReader(is);
				// Get the ObjectRepo
				if(objectRepo!=null)
					objectRepo.putAll(reader.readObject());
				else
					objectRepo=reader.readObject();
			}
		}
			
		return objectRepo;
	}

	public static JsonObject addOrUpdateAttributeValueInJsonObject(JsonObject jsonObj, String arrtibuteName,
			String attributeValue) {

		if (jsonObj.get(arrtibuteName) != null)
			// first remove old entry of the attributeName if its there
			jsonObj.remove(arrtibuteName);

		// create new JSON object with new attributeValue
		JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		jsonBuilder.add(arrtibuteName, attributeValue);
		JsonObject newJsonObj = jsonBuilder.build();

		// now add all the entries from old JSON object
		newJsonObj.putAll(jsonObj);

		return newJsonObj;
	}

	public static JsonObject mergeJsonObjects(JsonObject jsonObj, JsonObject... jsonObjArr) {
		for (JsonObject jo : jsonObjArr) {
			jsonObj.putAll(jo);
		}
		return jsonObj;

	}

	public static JsonObject removeEntryFromJsonObject(JsonObject jsonObj, String attributeName) {
		jsonObj.remove(attributeName);
		return jsonObj;
	}

}
