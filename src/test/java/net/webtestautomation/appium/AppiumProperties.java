package net.webtestautomation.appium;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class AppiumProperties {

    public static final String APPIUM_HOST = System.getProperty("appium.host");
    public static final String APPIUM_PORT = System.getProperty("appium.port");
    public static String APPIUM_PLATFORM = System.getProperty("platform.name");
    public static final String DEVICE_NAME = System.getProperty("device.name");
    public static final String UUID = System.getProperty("device.name");
    public static final String APPIUM_LOG_LEVEL = System.getProperty("appium.log");
    public static final String NO_RESET = System.getProperty("no.reset");
    public static final String APP_FILE = System.getProperty("file");
    public static final String IMPLICIT_WAIT_TIME = System.getProperty("implicit.wait");
    private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static String getAppiumPlatform(){
        return variables.getProperty("appium.platformName");
    }

    public static String getAppiumHub() {
        return variables.getProperty("appium.hub");
    }

    public static String getPlatformVersion() {
        return variables.getProperty("appium.platformVersion");
    }

    public static String getUUID() {
        return UUID;
    }

    public static String getAutomationName() {
        return variables.getProperty("appium.automationName");
    }
}
