package practice.items;

import net.minecraft.item.Item;
import practice.items.ItemInfo;

public class Items {
	public static Item pigDisplacer;

	public void init() {
		pigDisplacer = new ItemPigDisplacer(ItemInfo.PIG_DISPLACER_ID);
	}

}
