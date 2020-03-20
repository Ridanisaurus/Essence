package com.teamacronymcoders.essence.generation.tree.essence_tree;

import com.teamacronymcoders.essence.generation.EssenceFeatureConfigs;
import com.teamacronymcoders.essence.utils.registration.EssenceFeatureRegistration;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class EssenceWorldGenTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean b) {
        return random.nextInt(10) >= 8 ? EssenceFeatureRegistration.NORMAL_ESSENCE_TREE_FEATURE.get().withConfiguration(EssenceFeatureConfigs.NORMAL_WORLD_ESSENCE_TREE_CONFIG) : EssenceFeatureRegistration.FANCY_ESSENCE_TREE_FEATURE.get().withConfiguration(EssenceFeatureConfigs.FANCY_WORLD_ESSENCE_TREE_CONFIG);
    }
}