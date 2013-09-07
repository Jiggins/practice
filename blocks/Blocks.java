package practice.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import practice.items.ItemConcrete;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {

	public static Block concrete;
	public static Block lamp;

	public static void init() {
		concrete = new BlockConcrete(BlockInfo.CONCRETE_ID, Material.rock);
		GameRegistry.registerBlock(concrete, ItemConcrete.class, BlockInfo.CONCRETE_KEY);

		lamp = new BlockLamp(BlockInfo.LAMP_ID);
		//GameRegistry.registerBlock(lamp, ItemLamp.class, BlockInfo.LAMP_KEY);

	}
	
	public static void addNames() {
		LanguageRegistry.addName(concrete, BlockInfo.CONCRETE_NAME);
		LanguageRegistry.addName(lamp, BlockInfo.LAMP_NAME);
		
	}

	public static void registerRecipies() {
		
		
	}

}
