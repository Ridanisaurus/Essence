package com.teamacronymcoders.essence.impl.modifier.enchantment;

import com.teamacronymcoders.essence.api.modifier.EnchantmentCoreModifier;
import com.teamacronymcoders.essence.impl.items.tools.EssenceAxe;
import com.teamacronymcoders.essence.impl.items.tools.EssenceOmniTool;
import com.teamacronymcoders.essence.impl.items.tools.EssencePickaxe;
import com.teamacronymcoders.essence.impl.items.tools.EssenceShovel;
import com.teamacronymcoders.essence.utils.helpers.EssenceEnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EfficiencyModifier extends EnchantmentCoreModifier {

    public EfficiencyModifier() {
        super(5);
    }

    @Override
    public void onInventoryTick(ItemStack stack, World world, Entity entity, int inventorySlot, boolean isCurrentItem, int level) {
        EssenceEnchantmentHelper.createOrUpdateEnchantment(stack, getLinkedEnchantment(stack), level);
    }

    @Override
    public Enchantment getLinkedEnchantment(ItemStack stack) {
        return Enchantments.EFFICIENCY;
    }

    @Override
    public boolean canApplyOnItemStack(ItemStack stack) {
        Item item = stack.getItem();
        return item instanceof EssenceAxe || item instanceof EssencePickaxe || item instanceof EssenceShovel || item instanceof EssenceOmniTool;
    }
}