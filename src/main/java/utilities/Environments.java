package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:environmentConfig/${env}.properties" })
public interface Environments extends Config {
	@Key("App.Url")
	String appUrl();

	@Key("App.User")
	String appUsername();

	@Key("App.Pass")
	String appPassword();

	@Key("DB.Host")
	String dbHostname();

	@Key("DB.User")
	String dbUsername();

	@Key("DB.User")
	String dbPassword();
}
