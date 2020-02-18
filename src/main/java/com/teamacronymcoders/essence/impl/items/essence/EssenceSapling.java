package com.teamacronymcoders.essence.impl.items.essence;

import com.teamacronymcoders.essence.base.CustomSaplingBlock;
import com.teamacronymcoders.essence.impl.generation.tree.feature.essence_tree.EssenceTree;
import com.teamacronymcoders.essence.utils.EssenceReferences;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EssenceSapling extends CustomSaplingBlock {
    public EssenceSapling() {
        super(new EssenceTree(), Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0F).sound(SoundType.PLANT));
        setRegistryName(EssenceReferences.MODID, "essence_wood_sapling");
        setItemGroup(EssenceReferences.CORE_TAB);
    }
}