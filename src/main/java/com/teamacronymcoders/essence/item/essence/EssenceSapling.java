package com.teamacronymcoders.essence.item.essence;

import com.teamacronymcoders.essence.Essence;
import com.teamacronymcoders.essence.block.base.CustomSaplingBlock;
import com.teamacronymcoders.essence.generation.tree.essence_tree.EssenceTree;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EssenceSapling extends CustomSaplingBlock {
    public EssenceSapling() {
        super(new EssenceTree(), Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0F).sound(SoundType.PLANT));
        setRegistryName(Essence.MODID, "essence_wood_sapling");
        setItemGroup(Essence.CORE_TAB);
    }
}