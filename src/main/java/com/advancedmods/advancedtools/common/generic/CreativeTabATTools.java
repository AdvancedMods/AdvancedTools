package com.advancedmods.advancedtools.common.generic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Dennisbonke on 15-4-2015.
 */
public class CreativeTabATTools extends CreativeTabs {

    public CreativeTabATTools(String tabLabel) {
        super(tabLabel);
    }

    @Override
    public Item getTabIconItem() {
        return Items.iron_axe;
    }
}
