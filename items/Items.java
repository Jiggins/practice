package practice.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {
	public static Item pigDisplacer;

	public static void init() {
		pigDisplacer = new ItemPigDisplacer(ItemInfo.PIG_DISPLACER_ID);
	}

	public static void addNames() {
		LanguageRegistry.addName(pigDisplacer, ItemInfo.PIG_DISPLACER_NAME);
	}

	public static void registerRecipies() {
		GameRegistry.addRecipe(new ItemStack(pigDisplacer),
				new Object[] { 	"F/F",
								" / ",
								" / ",
								
								'F', Item.feather,
								'/', Item.stick
							});
	}

}
