package com.zandor300.advancedtools;

import com.zandor300.advancedtools.handler.IMCHandler;
import com.zandor300.advancedtools.init.always.ModBlocks;
import com.zandor300.advancedtools.init.always.ModItems;
import com.zandor300.advancedtools.init.always.Oredictionary;
import com.zandor300.advancedtools.init.always.Recipes;
import com.zandor300.advancedtools.plugins.ATIC2;
import com.zandor300.advancedtools.proxy.ServerProxy;
import com.zandor300.advancedtools.pulsar.config.ForgeCFG;
import com.zandor300.advancedtools.pulsar.control.PulseManager;
import com.zandor300.advancedtools.reference.Reference;
import com.zandor300.advancedtools.utilities.LogHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class AdvancedTools {

	@SidedProxy(clientSide = Reference.CLIENTSIDE, serverSide = Reference.SERVERSIDE)
	public static ServerProxy Proxy;

	public static PulseManager pulsar = new PulseManager(Reference.MOD_ID, new ForgeCFG("TinkersModules", "Modules: Disabling these will disable a chunk of the mod"));

	public AdvancedTools() {
		if (Loader.isModLoaded("Thermal Expansion")) {
			LogHelper.info("TE found, stay tuned!");
		} else {
			LogHelper.info("TE not found :(");
		}
	}

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		// Render Info
		//Proxy.registerRenderInfo();

		// Register Entity
		//registerEntity(FrankensteinMob.class, "Frankenstein", 0xeaeae9,
		//		0xc99a03);

		// Oredictionary
		Oredictionary.init();

		// Initialize Blocks
       	ModBlocks.init();

		// Initialize Items
        ModItems.init();

		// Register plugins
		pulsar.registerPulse(new ATIC2());

        LogHelper.info("Pre Initialization Complete!");
	}
	// register Frankenstein Mob
	/*private static void registerEntity(Class<? extends Entity> class1,
			String entityName, int bkEggColor, int fgEggColor) {
		int id = EntityRegistry.findGlobalUniqueEntityId();

		EntityRegistry.registerGlobalEntityID(class1, entityName, id);
		EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id,
				bkEggColor, fgEggColor));
	}

	public void addSpawn(Class<? extends EntityLiving> entityClass,
			int spawnProb, int min, int max, BiomeGenBase[] biomes) {
		if (spawnProb > 0)
			EntityRegistry.addSpawn(entityClass, spawnProb, min, max,
					EnumCreatureType.creature, biomes);
	}

	*/@EventHandler
	public static void Init(FMLInitializationEvent event) {

		// Initialize Recipes
		Recipes.init();

        LogHelper.info("Initialization Complete!");
	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {

		LogHelper.info("Post Initialization Complete!");
	}
	@EventHandler
	public void handleIMC(FMLInterModComms.IMCEvent e)
	{
		IMCHandler.processIMC(e.getMessages());
	}
	@EventHandler
	public void loadComplete(FMLLoadCompleteEvent evt)
	{
		IMCHandler.processIMC(FMLInterModComms.fetchRuntimeMessages(this));
	}
}
