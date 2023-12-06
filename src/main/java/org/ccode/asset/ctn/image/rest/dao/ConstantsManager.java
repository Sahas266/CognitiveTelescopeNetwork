package org.ccode.asset.ctn.image.rest.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConstantsManager {
	public static String appPath;
	public static Map<String, String> propertyMap;
	public static String propertyFile = "app.properties";
	private static ConstantsManager instance;


	private ConstantsManager() {
		initialize();
		loadAppProperties();
	}
	
	public static ConstantsManager getInstance() {
		if (instance == null) {
			instance = new ConstantsManager();
		}
		return instance;
	}

	public static String getValue(String key) {
		return propertyMap.get(key);
	}
	
	public static void initialize() {
		appPath = new String();
		appPath = Paths.get(".").toAbsolutePath().normalize().toString();
		propertyMap = new HashMap<>();
		loadAppProperties();
	}
	
	public static void loadAppProperties() {
        String filePath = appPath.concat("\\").concat("webapps").concat("\\").concat(propertyFile);
        System.out.println(filePath);
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            propertyMap.put(key, value);
        }
	}
	
	
	public static void main(String[] args) {
		ConstantsManager.initialize();
		ConstantsManager.loadAppProperties();
	}
}
