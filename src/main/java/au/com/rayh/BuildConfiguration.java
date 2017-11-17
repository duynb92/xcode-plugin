package au.com.rayh;

import com.dd.plist.NSDictionary; 
import com.dd.plist.NSArray;
import com.dd.plist.NSNumber;
import com.dd.plist.NSObject;
import com.dd.plist.NSString;
import com.dd.plist.PropertyListFormatException; 
import com.dd.plist.PropertyListParser; 

public class BuildConfiguration {
  public String uuid;
  public String name;
  public String bundleIdentifier;
  public String infoPlistFile;
  public String codeSignStyle;
  public String developmentTeamId;
  public String provisioningProfileUUID;
  public String provisioningProfileSpecifier;
  public String productName;

  BuildConfiguration(NSDictionary objectsDict, String buildConfigurationUUID, Boolean automatic) {
    NSDictionary buildConfigurationDict = ((NSDictionary)objectsDict.objectForKey(buildConfigurationUUID.toString()));
    //String baseConfigurationReference = buildConfigurationDict.objectForKey("baseConfigurationReference").toString();
    this.uuid = buildConfigurationUUID.toString();
    this.name = buildConfigurationDict.objectForKey("name").toString();
    System.out.println("buildConfigurationUUID: " + this.uuid);
    NSDictionary buildSettingsDict = ((NSDictionary)buildConfigurationDict.objectForKey("buildSettings"));
    if ( buildSettingsDict == null ) {
      System.out.println("buildSettings not exists!");
    }
    // LastUpgradeCheck = 0630, CreatedOnToolsVersion = 6.3.1
    if ( buildSettingsDict.objectForKey("PRODUCT_BUNDLE_IDENTIFIER") != null ) {

        this.bundleIdentifier = buildSettingsDict.objectForKey("PRODUCT_BUNDLE_IDENTIFIER").toString();
    }
    else if ( buildSettingsDict.objectForKey("PRODUCT_NAME") != null ) {
        this.productName = buildSettingsDict.objectForKey("PRODUCT_NAME").toString();
    }
    this.infoPlistFile = buildSettingsDict.objectForKey("INFOPLIST_FILE").toString();
    if ( !automatic ) {
      this.codeSignStyle = buildSettingsDict.objectForKey("CODE_SIGN_STYLE").toString();
      this.developmentTeamId = buildSettingsDict.objectForKey("DEVELOPMENT_TEAM").toString();
      this.provisioningProfileUUID = buildSettingsDict.objectForKey("PROVISIONING_PROFILE").toString();
      this.provisioningProfileSpecifier = buildSettingsDict.objectForKey("PROVISIONING_PROFILE_SPECIFIER").toString();
    }
    else {
      this.codeSignStyle = "Automatic";
    }
  }
}
