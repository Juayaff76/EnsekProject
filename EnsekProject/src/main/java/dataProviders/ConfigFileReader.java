package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs/Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getExcelFile() {
		String file = properties.getProperty("excelFile");
		if (file != null)
			return file;
		else
			throw new RuntimeException("Filename not specified in the Configuration.properties file.");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equals("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		System.out.println(reportConfigPath);
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public String getAPIkey() {
		String APIkey = properties.getProperty("APIkey");
		if (APIkey != null)
			return APIkey;
		else
			throw new RuntimeException("API key is not specified in the Configuration.properties file");
	}

	public String getAPPkey() {
		String APPkey = properties.getProperty("APPkey");
		if (APPkey != null)
			return APPkey;
		else
			throw new RuntimeException("APP key is not specified in the Configuration.properties file");
	}
	public String getAPIkey2() {
		String APIkey2 = properties.getProperty("APIkey2");
		if (APIkey2 != null)
			return APIkey2;
		else
			throw new RuntimeException("API key is not specified in the Configuration.properties file");
	}

	public String getAPPkey2() {
		String APPkey2 = properties.getProperty("APPkey2");
		if (APPkey2 != null)
			return APPkey2;
		else
			throw new RuntimeException("APP key is not specified in the Configuration.properties file");
	}
	public String getURL() {
		String APIurl = properties.getProperty("apiurl");
		if (APIurl != null)
			return APIurl;
		else
			throw new RuntimeException("API URL is not specified in the Configuration.properties file");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	public String getAdminUserName() {
		String url = properties.getProperty("adminUserName");
		if (url != null)
			return url;
		else
			throw new RuntimeException("adminUserName not specified in the Configuration.properties file.");
	}

	public String getAdminPassword() {
		String url = properties.getProperty("adminPassword");
		if (url != null)
			return url;
		else
			throw new RuntimeException("adminPassword not specified in the Configuration.properties file.");
	}

}
