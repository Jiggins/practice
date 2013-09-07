package practice.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockConcrete extends Block {

	@SideOnly(Side.CLIENT)
	private Icon icon;

	public BlockConcrete(int id, Material material) {
		super(id, material);

		setHardness(10F);
		setResistance(200F);
		setUnlocalizedName(BlockInfo.CONCRETE_UNLOCALIZED_NAME);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	public void registerIcons(IconRegister register) {
		icon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.CONCRETE_ICON);
	}

	public Icon getIcon(int side, int meta) {
		switch(side) {
			case 0: return icon;
			case 1: return icon;
			case 2: return icon;
		}
	return icon;
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		if (world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z)) {
			//Do something when powered
		}
	}

	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		if (!world.isRemote) {
			spawnAnvil(world, x, y + 20, z);
		}
	}

	private void spawnAnvil(World world, int x, int y, int z) {
		if (world.isAirBlock(x,y,z)) {
			world.setBlock(x, y, z, Block.anvil.blockID);
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			int newMeta = world.getBlockMetadata(x, y, z) == 0 ? 1 : 0;

			world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
		}
	return true;
	}
}
