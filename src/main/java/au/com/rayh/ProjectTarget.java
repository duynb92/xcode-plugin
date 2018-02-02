package au.com.rayh;

import java.util.HashMap;

public class ProjectTarget {
    public String uuid;
    public String name;
    public String productType;
    public String provisioningStyle;
    public String defaultConfigurationName;
    public HashMap<String, BuildConfiguration> buildConfiguration;

    ProjectTarget() {
	uuid = null;
	name = null;
	productType = null;
	provisioningStyle = null;
	defaultConfigurationName = null;
	
	buildConfiguration = new HashMap<String, BuildConfiguration>();
    }
}

