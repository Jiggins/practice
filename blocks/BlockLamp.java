package practice.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockLamp extends Block {

	private Icon BlockLamp_On;
	private Icon BlockLamp_Off;

	public BlockLamp(int id) {
		super(id, Material.glass);

		setHardness(0.3F);
		setStepSound(soundGlassFootstep);
		setUnlocalizedName("Lamp");
		setCreativeTab(CreativeTabs.tabRedstone);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		if (world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
			int newMeta;
			if (world.getBlockMetadata(x,y,z) == 0) {
				newMeta = 1;
			} else {
				newMeta = 0;
			}

			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
		}
	}

	/**
     * Called upon block activation (right click on the block.)
     */
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
		}
		return true;
	}

//	public boolean 
}
