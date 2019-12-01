package net.webtestautomation.appium;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

import static io.appium.java_client.service.local.AppiumDriverLocalService.buildService;

public class AppiumServer {
    private final static AppiumDriverLocalService AppiumLocalService;

    static{
        AppiumLocalService = buildService(new AppiumServiceBuilder().
                withIPAddress("127.0.0.1").
                usingPort(Integer.parseInt("4723"))
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.LOG_LEVEL, "info"));
    }

    public static void startAppiumServer() {
        try{
            AppiumLocalService.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void stopAppiumServer() {
        try{
            if (AppiumLocalService.isRunning()) {
                AppiumLocalService.stop();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
