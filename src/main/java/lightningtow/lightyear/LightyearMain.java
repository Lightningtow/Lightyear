package lightningtow.lightyear;

import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class LightyearMain implements ClientModInitializer
{

//	public static final String MOD_ID = "lightyear";
	public static final String MOD_DISPLAY_NAME = "Lightyear";

	// LOGGER.log doesn't add mod_id to the message in a non-dev environment, this adds the mod_id without having to add it every time
	public static void LogThis(org.apache.logging.log4j.Level lvl, String msg) {
		msg = MOD_DISPLAY_NAME + " " + msg;
		LogManager.getLogger(MOD_DISPLAY_NAME).log(lvl, msg);
	}
	
	@Override
	public void onInitializeClient() {

		try {
			CustomhudIntegration.initCustomhud();
			LogThis(Level.INFO, "Successfully integrated with CustomHud");

		} catch (Exception e) {
			LogThis(Level.ERROR, "Error integrating with CustomHud: " + e);
		}

	}

}
