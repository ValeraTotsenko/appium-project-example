package net.testiteasy.utils.config;

import net.testiteasy.drivers.AppiumLocalServer;
import net.testiteasy.utils.properties.MobitruCloudConfig;
import net.testiteasy.utils.properties.TestFrameworkConfig;
import net.testiteasy.utils.variables.OSType;
import net.testiteasy.utils.variables.RunningPlatform;
import net.testiteasy.utils.variables.EnvironmentType;
import org.aeonbits.owner.ConfigFactory;

import static org.apache.commons.lang3.StringUtils.upperCase;

@SuppressWarnings("unused")
public class TestProjectConfig {

    private static volatile TestProjectConfig instance;

    private final String appiumBaseUrl;
    private final String appiumConfigBaseUrl;

    private final String iOSAppPath;
    private final String androidAppPath;

    private final OSType osType;
    private final String platformVersion;
    private final String deviceName;
    private final RunningPlatform runningPlatform;
    private final EnvironmentType envType;
    private final String sysLanguage;

    private final String appPackage;
    private final String appActivity;

    private final String mobitruProjectName;
    private final String mobitruAuthorizationKey;

    private TestProjectConfig() {
        TestFrameworkConfig testFrameworkConfig = ConfigFactory.create(TestFrameworkConfig.class);
        MobitruCloudConfig cloudConfig = ConfigFactory.create(MobitruCloudConfig.class);

        runningPlatform = RunningPlatform.valueOf(upperCase(testFrameworkConfig.runningPlatform()));

        appiumConfigBaseUrl = testFrameworkConfig.appiumServiceUrl();
        appiumBaseUrl = initAppiumBaseUrl();

        iOSAppPath = testFrameworkConfig.iOSAppPath();
        androidAppPath = testFrameworkConfig.androidAppPath();

        osType = OSType.valueOf(upperCase(testFrameworkConfig.devicePlatform()));
        platformVersion = testFrameworkConfig.platformVersion();
        deviceName = testFrameworkConfig.deviceName();

        envType = EnvironmentType.valueOf(upperCase(testFrameworkConfig.envType()));
        sysLanguage = testFrameworkConfig.sysLanguage();

        appPackage = testFrameworkConfig.appPackage();
        appActivity = testFrameworkConfig.appActivity();

        mobitruProjectName = cloudConfig.mobitruProjectName();
        mobitruAuthorizationKey = cloudConfig.mobitruAuthKey();
    }

    public static TestProjectConfig testConfig() {
        TestProjectConfig config = instance;
        if (config != null) {
            return config;
        }
        synchronized (TestProjectConfig.class) {
            if (instance == null) {
                instance = new TestProjectConfig();
            }
            return instance;
        }
    }

    public String getAppiumConfigBaseUrl() {
        return appiumConfigBaseUrl;
    }

    private String initAppiumBaseUrl() {
        String baseUrl = "";

        switch (getRunningPlatform()) {
            case LOCAL -> baseUrl = AppiumLocalServer.getServerUrl().toString();
            case EPAM_CLOUD, SAUCELABS -> baseUrl = getAppiumConfigBaseUrl();
        }

        return baseUrl;
    }

    public String getAppiumBaseUrl() {
        return appiumBaseUrl;
    }

    public String getiOSAppPath() {
        return iOSAppPath;
    }

    public String getAndroidAppPath() {
        return androidAppPath;
    }

    public OSType getOSType() {
        return osType;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public RunningPlatform getRunningPlatform() {
        return runningPlatform;
    }

    public EnvironmentType getEnvType() {
        return envType;
    }

    public String getSysLanguage() {
        return sysLanguage;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public String getMobitruProjectName() {
        return mobitruProjectName;
    }

    public String getMobitruAuthorizationKey() {
        return mobitruAuthorizationKey;
    }
}
