package practice;

import practice.network.PacketHandler;
import practice.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
@NetworkMod(channels = {ModInformation.CHANNELS}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class PracticeMod {

	@Instance("PracticeMod")
	public static PracticeMod instance;

	@SidedProxy(clientSide = "practice.proxies.ClientProxy", serverSide = "practice.proxies.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	} 

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {

	}
}
