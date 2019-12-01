#!/bin/bash
cd "$(dirname "$0")"
cd ../
mvn clean verify -Dmetafilter="+overcheck" -Dappium.platformVersion=9 -Dappium.deviceName=710KPSL0464078 -Dappium.disableWindowAnimation=true -Dappium.automationName=uiautomator2 -Dappium.platformName=Android -Dappium.app=/Users/rajeshwaran.sarangarajan/Downloads/Test.apk -Dappium.appActivity=com.testhome.react.android.beta.MainActivity -Dappium.appPackage=com.testhome.react.android.beta -Dappium.noReset=true -Dserenity.summary.report.title="Test Regression - Android"
javac SendEmail.java
java SendEmail
mvn clean verify -Dmetafilter="+overcheck" -Dappium.platformVersion=11.0.1 -Dappium.deviceName=iPhone -Dappium.automationName=XCUITest -Dappium.platformName=iOS -Dappium.app=/Users/rajeshwaran.sarangarajan/Downloads/Test.ipa -Dappium.noReset=true -Dappium.bundleID=com.testhome.react.ipad.beta.Test -Dappium.udid=85aa1648cf9a7fbd9950a5338e24ddb6e678065c -Dappium.waitForQuiescence=false -Dappium.useNewWDA=true -Dappium.wdaEventloopIdleDelay=3 -Dserenity.summary.report.title="Test Regression - iOS"
javac SendEmail.java
java SendEmail