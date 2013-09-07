package practice.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemSkateBoard extends Item {
	public ItemSkateBoard(int id) {
		super(id);

		setMaxStackSize(1);
	}

	@SuppressWarnings("unused")
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			//get coordinates of the block the player is looking at
			MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, player, true);

			//method break if player is not looking at a block.
			if (movingObjectPosition == null) {
				return itemstack;
			}

			int x = movingObjectPosition.blockX;
			int y = movingObjectPosition.blockY + 1;
			int z = movingObjectPosition.blockZ;

			

		}
		return itemstack;
	}
}
