package com.teamacronymcoders.essence.api.tool;

import com.teamacronymcoders.essence.api.holder.ModifierInstance;
import net.minecraft.item.ItemStack;

import java.util.List;

public interface IModified<T> {
    void addModifierWithoutIncreasingAdditional(int increase);
    void increaseFreeModifiers(int increase);
    boolean decreaseFreeModifiers(int decrease);
    int getFreeModifiers();
    boolean recheck(T object, List<ModifierInstance<T>> instances);
    Class<T> getType();
}