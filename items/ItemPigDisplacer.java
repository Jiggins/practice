package practice.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import practice.items.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Suggestion from Coder Dojo
 * Shift Right click pig to pick up
 * right click to place it down
 *
 * @author Jack
 */
public class ItemPigDisplacer extends Item {
	@SideOnly(Side.CLIENT)
	private Icon chargedIcon;

	public ItemPigDisplacer(int id) {
		super(id);
		
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.PIG_DISPLACER_UNLOCALIZED_NAME);
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs() {
		return new CreativeTabs [] {CreativeTabs.tabCombat};
	}
	
	
	/**
	* Called when player right clicks an Entity. 
	*/
	@Override
	public boolean func_111207_a(ItemStack itemstack, EntityPlayer player, EntityLivingBase target) {
		//Makes this code only work on the server,  no need to to it on the Client side.
		if (!target.worldObj.isRemote) {
			//If Right clickded Entity is a pig
			if (target instanceof EntityPig) {
				//If player is holding Shift
				if (player.isSneaking()) {
					//Kill the pig
					target.setDead();
					//Increase damage value
					itemstack.setItemDamage(itemstack.getItemDamage() + 1);	
				}
			}
		}
		
		return false;
		
	}
	
@Override							//itemstack = wand,, world = the world that the player is in, player = me!
public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
	//Makes this code only work on the server,  no need to to it on the Client side.
	if (!world.isRemote) {
		//If Shift button is not held,  I have another method for Shift+RightClick
		if (!player.isSneaking()) {
			//If the Item has pigs to launch
			if (this.isCharged(itemstack.getItemDamage())) {

				//Creates a little piggy
				Entity entity = EntityList.createEntityByName("Pig", world);

				//Check to see if I didnt fuck up on the last line
				if (entity != null && entity instanceof EntityLivingBase)
					return itemstack;
				{
				//Gets the position (x, y, z) of the block the player is looking at
				MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

				//Because it crashed when I right clicked when looking into the sky (not looking at a block)
				if (movingobjectposition == null) {
				    return itemstack;
				}

				int x = movingobjectposition.blockX;
				int y = movingobjectposition.blockY + 1;
				int z = movingobjectposition.blockZ;

				//Casts the Entity Object above into an Entity Living Object.
				EntityLiving entityliving = (EntityLiving)entity;
				//Sets the location of the pig to the block I'm looking at and places it at a random angle
				entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
				//What way the head is facing
				entityliving.rotationYawHead = entityliving.rotationYaw;
				entityliving.renderYawOffset = entityliving.rotationYaw;
				//honestly no idea, but it looks important
				entityliving.func_110161_a((EntityLivingData)null);
				//finally creates the pig in the world
				world.spawnEntityInWorld(entity);
				//Oink oink
				entityliving.playLivingSound();
				}

				//Reduces the number of pigs left in the wand.
				itemstack.setItemDamage(itemstack.getItemDamage() - 1);
			}
		}
	}
	return itemstack;
}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.PIG_DISPLACER_ICON);
		chargedIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.PIG_DISPLACER_CHARGED_ICON);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) {
		info.add("This item has been used " + itemstack.getItemDamage() + " times.");
		
		if (isCharged(itemstack.getItemDamage())) {
			info.add("This item is charged");
		}

		info.add("Suggestion from Coder Dojo");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		if (isCharged(dmg)) {
			return chargedIcon;			
		}
		return itemIcon;
	}
	
	private boolean isCharged(int dmg) {
		return dmg >= 1;
	}
	

}
