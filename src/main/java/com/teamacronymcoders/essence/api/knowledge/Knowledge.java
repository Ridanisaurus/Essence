package com.teamacronymcoders.essence.api.knowledge;

import com.teamacronymcoders.essence.api.modifier.ModifierInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knowledge extends ForgeRegistryEntry<Knowledge> implements INBTSerializable<CompoundNBT> {
    private static final String TAG_KNOWLEDGE = "Knowledge";
    private static final String TAG_MODIFIER_INSTANCES = "ModifierInstances";

    private ResourceLocation identifier;
    private List<ModifierInstance> modifierInstances;

    public Knowledge() {}

    public Knowledge(ResourceLocation identifier, ModifierInstance... modifiers) {
        this.identifier = identifier;
        this.modifierInstances = new ArrayList<>();
        Collections.addAll(this.modifierInstances, modifiers);
    }

    @Override
    public CompoundNBT serializeNBT() {
        final CompoundNBT nbt = new CompoundNBT();
        nbt.putString(TAG_KNOWLEDGE, identifier.toString());
        final ListNBT modifierInstances = new ListNBT();
        for (ModifierInstance instance : this.modifierInstances) {
            modifierInstances.add(instance.serializeNBT());
        }
        nbt.put(TAG_MODIFIER_INSTANCES, modifierInstances);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        final ResourceLocation identifier = new ResourceLocation(nbt.getString(TAG_KNOWLEDGE));
        final List<ModifierInstance> modifierInstances = new ArrayList<>();
        final ListNBT listNBT = nbt.getList(TAG_MODIFIER_INSTANCES, Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < listNBT.size(); i++) {
            final CompoundNBT subCNBT = listNBT.getCompound(i);
            final ModifierInstance instance = new ModifierInstance();
            instance.deserializeNBT(subCNBT);
            modifierInstances.add(instance);
        }
        this.identifier = identifier;
        this.modifierInstances = modifierInstances;
    }
}