package practice.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import practice.blocks.BlockInfo;
import practice.items.ItemInfo;

public class ConfigHandler {

	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		BlockInfo.CONCRETE_ID = config.getBlock(BlockInfo.CONCRETE_KEY, BlockInfo.CONCRETE_DEFAULT).getInt();

		ItemInfo.PIG_DISPLACER_ID = config.getItem(ItemInfo.PIG_DISPLACER_KEY, ItemInfo.PIG_DISPLACER_DEFAULT).getInt() - 256;	
		config.save();
		
	}

}
