package com.zandor300.advancedtools.common.creativetabs;

import com.zandor300.advancedtools.core.ATProps;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by Dennisbonke on 10-2-2015.
 */
public class CreativeTabATTools {

    public static final CreativeTabs tab = new CreativeTabs(ATProps.modid) {

        @Override
        public Item getTabIconItem() {
            return Items.golden_pickaxe;
        }

        @Override
        public String getTranslatedTabLabel() {
            return "Advanced Tools:Tools";
        }

    };

}
