package practice;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
@NetworkMod(channels = {ModInformation.CHANNELS}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class PracticeMod {

	@Instance("PracticeMod")
	public static PracticeMod instance;

	@Event
	public void preInit(FMLPreInitializationEvent event) {

	} 

	@Event
	public void init(FMLInitializationEvent event) {

	}

	@Event
	public void postinit(FMLPostInitializationEvent event) {

	}
}
