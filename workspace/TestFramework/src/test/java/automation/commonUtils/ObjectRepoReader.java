package automation.commonUtils;


import javax.json.JsonObject;

import org.openqa.selenium.By;

public class ObjectRepoReader {
	private String objRepoFolderPath;
	private JsonObject objRepo;

	public ObjectRepoReader() {
		objRepoFolderPath = "./resources/objectRepo";
		objRepo = JsonUtils.getObjectRepositories(objRepoFolderPath);
	}

	public ObjectRepoReader(String objRepoFolderPath) {
		this.objRepoFolderPath = objRepoFolderPath;
		objRepo = JsonUtils.getObjectRepositories(objRepoFolderPath);
	}

	public ObjectRepoReader(JsonObject objRepo) {
		this.objRepo = objRepo;
	}

	public String getObjRepoFilePath() {
		return objRepoFolderPath;
	}

	public JsonObject getObjRepo() {
		return objRepo;
	}

	public void setObjRepo(JsonObject objRepo) {
		this.objRepo = objRepo;
	}

	public void setObjRepoFilePath(String objRepoFolderPath) {
		this.objRepoFolderPath = objRepoFolderPath;
	}

	public By getObjectLocator(String page, String objName) throws Exception {

		// Get the pageRepo from ObjRepo then elementObject from pageRepo
		JsonObject elementObj = objRepo.getJsonObject(page).getJsonObject(objName);
		
		switch (elementObj.getString("locatorType").toLowerCase()) {
		case "id":
			return By.id(elementObj.getString("locatorValue"));
		case "name":
			return By.name(elementObj.getString("locatorValue"));
		case "classname":
			return By.className(elementObj.getString("locatorValue"));
		case "tagname":
			return By.tagName(elementObj.getString("locatorValue"));
		case "xpath":
			return By.xpath(elementObj.getString("locatorValue"));
		case "cssselector":
			return By.cssSelector(elementObj.getString("locatorValue"));
		case "linktext":
			return By.linkText(elementObj.getString("locatorValue"));
		case "partiallinktext":
			return By.partialLinkText(elementObj.getString("locatorValue"));
		case "xpath_index":
				return By.xpath(elementObj.getString("locatorValue").replace("REPLACE_INDEX", "1"));
		case "xpath_text":
			return By.xpath(elementObj.getString("locatorValue").replace("REPLACE_TEXT", elementObj.getString("locatorText")));
		case "default":
			throw new Exception("No such locatorType is supported, LocatorType:"
					+ elementObj.getString("locatorType").toLowerCase());
		}
		
		return null;

	}
	
	public By getObjectLocatorWithTextValue(String page, String objName, String textValue) throws Exception {

		// Get the pageRepo from ObjRepo then elementObject from pageRepo
		JsonObject elementObj = objRepo.getJsonObject(page).getJsonObject(objName);
		
		switch (elementObj.getString("locatorType").toLowerCase()) {
		case "id":
			return By.id(elementObj.getString("locatorValue"));
		case "name":
			return By.name(elementObj.getString("locatorValue"));
		case "classname":
			return By.className(elementObj.getString("locatorValue"));
		case "tagname":
			return By.tagName(elementObj.getString("locatorValue"));
		case "xpath":
			return By.xpath(elementObj.getString("locatorValue"));
		case "cssselector":
			return By.cssSelector(elementObj.getString("locatorValue"));
		case "linktext":
			return By.linkText(elementObj.getString("locatorValue"));
		case "partiallinktext":
			return By.partialLinkText(elementObj.getString("locatorValue"));
		case "xpath_index":
				return By.xpath(elementObj.getString("locatorValue").replace("REPLACE_INDEX", "1"));
		case "xpath_text":
			System.out.println(elementObj.getString("locatorValue").replace("REPLACE_TEXT", textValue));
			return By.xpath(elementObj.getString("locatorValue").replace("REPLACE_TEXT", textValue));
		case "default":
			throw new Exception("No such locatorType is supported, LocatorType:"
					+ elementObj.getString("locatorType").toLowerCase());
		}
		
		return null;

	}
	
	public By getObjectLocatorWithTextAndIndex(String page, String objName, String textValue, int index) throws Exception {

		// Get the pageRepo from ObjRepo then elementObject from pageRepo
		JsonObject elementObj = objRepo.getJsonObject(page).getJsonObject(objName);
		
		switch (elementObj.getString("locatorType").toLowerCase()) {
		case "xpath_index_text":
			if(index>=1) {
				System.out.println(elementObj.getString("locatorValue").replace("REPLACE_TEXT", textValue).replace("REPLACE_INDEX", ""+index));
				return By.xpath(elementObj.getString("locatorValue").replace("REPLACE_TEXT", textValue).replace("REPLACE_INDEX", ""+index));
			}
			else {
				System.out.println(elementObj.getString("locatorValue").replace("REPLACE_TEXT", textValue).replace("REPLACE_INDEX", "1"));
				return By.xpath(elementObj.getString("locatorValue").replace("REPLACE_TEXT", textValue).replace("REPLACE_INDEX", "1"));
			}
		case "default":
			throw new Exception("No such locatorType is supported, LocatorType:"
					+ elementObj.getString("locatorType").toLowerCase());
		}
		
		return null;

	}
	
	public By getObjectLocatorWithIndex(String page, String objName, int index) throws Exception {

		// Get the pageRepo from ObjRepo then elementObject from pageRepo
		JsonObject elementObj = objRepo.getJsonObject(page).getJsonObject(objName);
		switch (elementObj.getString("locatorType").toLowerCase()) {
		
		case "xpath_index":
			if(index>=1)
				return By.xpath(elementObj.getString("locatorValue").replace("REPLACE_INDEX", ""+index));
			else
				return By.xpath(elementObj.getString("locatorValue").replace("REPLACE_INDEX", "1"));
		case "default":
			throw new Exception("No such locatorType is supported, LocatorType:"
					+ elementObj.getString("locatorType").toLowerCase());
		}
		
		return null;

	}
	
}
