package com.zandor300.advancedtools.items.tools.emerald;

import com.zandor300.advancedtools.creativetab.CreativeTabAT;
import net.minecraft.item.ItemPickaxe;

public class EmeraldPickaxe extends ItemPickaxe {

	public EmeraldPickaxe(int id, ToolMaterial material) {
		super(material);
		this.setCreativeTab(CreativeTabAT.tab);
		this.setUnlocalizedName("EmeraldPickaxe");
		this.setTextureName("advancedtools:emeraldpickaxe");
	}
}
