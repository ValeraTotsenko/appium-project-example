package net.testiteasy.utils.config;

import net.testiteasy.utils.properties.MobitruCloudConfig;
import net.testiteasy.utils.properties.TestFrameworkConfig;
import net.testiteasy.utils.variables.RunningPlatform;
import org.aeonbits.owner.ConfigFactory;

import static org.apache.commons.lang3.StringUtils.upperCase;

public class LocalAppiumServerConfig {

    private static volatile LocalAppiumServerConfig instance;

    private final RunningPlatform runningPlatform;


    private LocalAppiumServerConfig() {
        TestFrameworkConfig testFrameworkConfig = ConfigFactory.create(TestFrameworkConfig.class);
        MobitruCloudConfig cloudConfig = ConfigFactory.create(MobitruCloudConfig.class);

        runningPlatform = RunningPlatform.valueOf(upperCase(testFrameworkConfig.runningPlatform()));
    }

    public static LocalAppiumServerConfig localAppiumServerConfig() {
        LocalAppiumServerConfig config = instance;
        if (config != null) {
            return config;
        }
        synchronized (LocalAppiumServerConfig.class) {
            if (instance == null) {
                instance = new LocalAppiumServerConfig();
            }
            return instance;
        }
    }

    public RunningPlatform getRunningPlatform() {
        return runningPlatform;
    }

}
