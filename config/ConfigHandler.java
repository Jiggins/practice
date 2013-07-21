package practice.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import vswe.items.ItemInfo;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		config.save();
		
	}

}
