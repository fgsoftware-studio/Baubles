package com.fgsoftwarestudio.baubles.api

import net.minecraft.util.text.ITextComponent

interface IBaublesInventory {
    fun getName(): String

    fun hasCustomName(): Boolean

    fun getDisplayName(): ITextComponent

    fun size(): Int
}