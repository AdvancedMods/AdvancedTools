package com.zandor300.advancedtools;

import com.zandor300.advancedtools.reference.Reference;
import com.zandor300.advancedtools.utilities.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;

import com.zandor300.advancedtools.blocks.CreateBlock;
import com.zandor300.advancedtools.blocks.crops.StrawberryCrop;
import com.zandor300.advancedtools.items.armor.ArmorItem;
import com.zandor300.advancedtools.items.food.LuckyStar;
import com.zandor300.advancedtools.items.food.Strawberry;
import com.zandor300.advancedtools.items.tools.bone.BoneAxe;
import com.zandor300.advancedtools.items.tools.bone.BoneHoe;
import com.zandor300.advancedtools.items.tools.bone.BonePickaxe;
import com.zandor300.advancedtools.items.tools.bone.BoneShovel;
import com.zandor300.advancedtools.items.tools.bone.BoneSword;
import com.zandor300.advancedtools.items.tools.emerald.EmeraldAxe;
import com.zandor300.advancedtools.items.tools.emerald.EmeraldHoe;
import com.zandor300.advancedtools.items.tools.emerald.EmeraldPickaxe;
import com.zandor300.advancedtools.items.tools.emerald.EmeraldShovel;
import com.zandor300.advancedtools.items.tools.emerald.EmeraldSword;
import com.zandor300.advancedtools.items.tools.ingot.BoneIngot;
import com.zandor300.advancedtools.items.tools.ingot.RedstoneIngot;
import com.zandor300.advancedtools.items.tools.redstone.RedstoneAxe;
import com.zandor300.advancedtools.items.tools.redstone.RedstoneHoe;
import com.zandor300.advancedtools.items.tools.redstone.RedstonePickaxe;
import com.zandor300.advancedtools.items.tools.redstone.RedstoneShovel;
import com.zandor300.advancedtools.items.tools.redstone.RedstoneSword;
import com.zandor300.advancedtools.mobs.FrankensteinMob;
import com.zandor300.advancedtools.proxy.ServerProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class AdvancedTools {

	@SidedProxy(clientSide = Reference.CLIENTSIDE, serverSide = Reference.SERVERSIDE)
	public static ServerProxy Proxy;

	public static final Block Transformer = new CreateBlock("Transformer",
			"transformer", 2000, Material.wood, CreativeTabs.tabBlock, 4f, 5f,
			0f);
	public static final Block Lamp = new CreateBlock("Lamp", "lamp", 2001,
			Material.glass, CreativeTabs.tabBlock, 4f, 5f, 1f);
	public static final Block LuckyStarBlock = new CreateBlock(
			"LuckyStarBlock", "luckystar", 2001, Material.glass,
			CreativeTabs.tabBlock, 4f, 5f, 1f);

	public static Item Strawberry = new Strawberry(3000, 2, true);
	public static Block StrawberryCrop = new StrawberryCrop(3001);

	public static Item LuckyStar = new LuckyStar(3001, 20, true);

	public static Item boneIngot = new BoneIngot(4000);
	public static Item redstoneIngot = new RedstoneIngot(4001);

	public static ToolMaterial emerald = EnumHelper.addToolMaterial("Emerald",
			3, 2000, 10.0f, 4.0f, 22);
	public static ToolMaterial bone = EnumHelper.addToolMaterial("Bone", 3,
			250, 7.0f, 2.5f, 10);
	public static ToolMaterial redstone = EnumHelper.addToolMaterial(
			"Redstone", 3, 750, 8.0f, 3.0f, 40);

	public static ArmorMaterial emeraldArmor = EnumHelper.addArmorMaterial(
			"Emerald", 43, new int[] { 4, 6, 5, 4 }, 25);

	public static Item emeraldPickaxe = new EmeraldPickaxe(5000, emerald);
	public static Item emeraldShovel = new EmeraldShovel(5001, emerald);
	public static Item emeraldAxe = new EmeraldAxe(5002, emerald);
	public static Item emeraldSword = new EmeraldSword(5003, emerald);
	public static Item emeraldHoe = new EmeraldHoe(5004, emerald);

	public static Item emeraldHelmet = new ArmorItem("EmeraldHelmet",
			"emeraldhelmet", emeraldArmor, 0);
	public static Item emeraldChestplate = new ArmorItem("EmeraldChestplate",
			"emeraldchestplate", emeraldArmor, 1);
	public static Item emeraldLeggings = new ArmorItem("EmeraldLeggings",
			"emeraldleggings", emeraldArmor, 2);
	public static Item emeraldBoots = new ArmorItem("Emeraldboots",
			"emeraldboots", emeraldArmor, 3);

	public static Item bonePickaxe = new BonePickaxe(5005, bone);
	public static Item boneShovel = new BoneShovel(5006, bone);
	public static Item boneAxe = new BoneAxe(5007, bone);
	public static Item boneSword = new BoneSword(5008, bone);
	public static Item boneHoe = new BoneHoe(5009, bone);

	public static Item redstonePickaxe = new RedstonePickaxe(5010, redstone);
	public static Item redstoneShovel = new RedstoneShovel(5011, redstone);
	public static Item redstoneAxe = new RedstoneAxe(5012, redstone);
	public static Item redstoneSword = new RedstoneSword(5013, redstone);
	public static Item redstoneHoe = new RedstoneHoe(5014, redstone);

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		Proxy.registerRenderInfo();

		GameRegistry.registerBlock(Transformer, "Transformer");
		LanguageRegistry.addName(Transformer, "Transformer");
		GameRegistry.registerBlock(Lamp, "Lamp");
		LanguageRegistry.addName(Lamp, "Lamp");
		GameRegistry.registerBlock(LuckyStarBlock, "Lucky Star Block");
		LanguageRegistry.addName(LuckyStarBlock, "Lucky Star Block");

		registerEntity(FrankensteinMob.class, "Frankenstein", 0xeaeae9,
				0xc99a03);

		GameRegistry.registerItem(Strawberry, "Strawberry");
		LanguageRegistry.addName(Strawberry, "Strawberry");

		GameRegistry.registerItem(LuckyStar, "Lucky Star");
		LanguageRegistry.addName(LuckyStar, "Lucky Star");

		GameRegistry.registerItem(boneIngot, "Bone Ingot");
		LanguageRegistry.addName(boneIngot, "Bone Ingot");
		GameRegistry.registerItem(redstoneIngot, "Redstone Ingot");
		LanguageRegistry.addName(redstoneIngot, "Redstone Ingot");

		GameRegistry.registerItem(emeraldPickaxe, "Emerald Pickaxe");
		LanguageRegistry.addName(emeraldPickaxe, "Emerald Pickaxe");
		GameRegistry.registerItem(emeraldShovel, "Emerald Shovel");
		LanguageRegistry.addName(emeraldShovel, "Emerald Shovel");
		GameRegistry.registerItem(emeraldAxe, "Emerald Axe");
		LanguageRegistry.addName(emeraldAxe, "Emerald Axe");
		GameRegistry.registerItem(emeraldSword, "Emerald Sword");
		LanguageRegistry.addName(emeraldSword, "Emerald Sword");
		GameRegistry.registerItem(emeraldHoe, "Emerald Hoe");
		LanguageRegistry.addName(emeraldHoe, "Emerald Hoe");

		GameRegistry.registerItem(emeraldHelmet, "Emerald Helmet");
		LanguageRegistry.addName(emeraldHelmet, "Emerald Helmet");
		GameRegistry.registerItem(emeraldChestplate, "Emerald Chestplate");
		LanguageRegistry.addName(emeraldChestplate, "Emerald Chestplate");
		GameRegistry.registerItem(emeraldLeggings, "Emerald Leggings");
		LanguageRegistry.addName(emeraldLeggings, "Emerald Leggings");
		GameRegistry.registerItem(emeraldBoots, "Emerald Boots");
		LanguageRegistry.addName(emeraldBoots, "Emerald Boots");

		GameRegistry.registerItem(bonePickaxe, "Bone Pickaxe");
		LanguageRegistry.addName(bonePickaxe, "Bone Pickaxe");
		GameRegistry.registerItem(boneShovel, "Bone Shovel");
		LanguageRegistry.addName(boneShovel, "Bone Shovel");
		GameRegistry.registerItem(boneAxe, "Bone Axe");
		LanguageRegistry.addName(boneAxe, "Bone Axe");
		GameRegistry.registerItem(boneSword, "Bone Sword");
		LanguageRegistry.addName(boneSword, "Bone Sword");
		GameRegistry.registerItem(boneHoe, "Bone Hoe");
		LanguageRegistry.addName(boneHoe, "Bone Hoe");

		GameRegistry.registerItem(redstonePickaxe, "Redstone Pickaxe");
		LanguageRegistry.addName(redstonePickaxe, "Redstone Pickaxe");
		GameRegistry.registerItem(redstoneShovel, "Redstone Shovel");
		LanguageRegistry.addName(redstoneShovel, "Redstone Shovel");
		GameRegistry.registerItem(redstoneAxe, "Redstone Axe");
		LanguageRegistry.addName(redstoneAxe, "Redstone Axe");
		GameRegistry.registerItem(redstoneSword, "Redstone Sword");
		LanguageRegistry.addName(redstoneSword, "Redstone Sword");
		GameRegistry.registerItem(redstoneHoe, "Redstone Hoe");
		LanguageRegistry.addName(redstoneHoe, "Redstone Hoe");

        LogHelper.info("Pre Initialization Complete!");
	}

	private static void registerEntity(Class<? extends Entity> class1,
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

	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		GameRegistry.addShapedRecipe(new ItemStack(boneIngot), "BBB", "BBB",
				'B', Items.bone);
		GameRegistry.addShapedRecipe(new ItemStack(redstoneIngot), "RRR",
				"RRR", 'R', Items.redstone);
        LogHelper.info("Initialization Complete!");
	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
        LogHelper.info("Post Initiaalization Complete!");
	}
}
