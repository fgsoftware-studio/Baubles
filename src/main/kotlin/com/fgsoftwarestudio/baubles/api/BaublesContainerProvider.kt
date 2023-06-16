package com.fgsoftwarestudio.baubles.api

import net.minecraft.nbt.CompoundNBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.util.INBTSerializable

class BaublesContainerProvider(private val container: BaublesContainer) : INBTSerializable<CompoundNBT> {
    fun hasCapability(capability: Capability<*>, facing: Direction?): Boolean {
        return capability === BaublesCapabilities.CAPABILITY_BAUBLES
    }

    override fun serializeNBT(): CompoundNBT {
        return container.serializeNBT()
    }

    override fun deserializeNBT(nbt: CompoundNBT) {
        container.deserializeNBT(nbt)
    }
}