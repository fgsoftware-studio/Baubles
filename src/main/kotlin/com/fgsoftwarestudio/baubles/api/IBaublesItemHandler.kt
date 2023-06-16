package com.fgsoftwarestudio.baubles.api

import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraftforge.items.IItemHandlerModifiable

interface IBaublesItemHandler : IItemHandlerModifiable {
    val isEventBlocked: Boolean

    fun isItemValidForSlot(slot: Int, stack: ItemStack?, player: LivingEntity?): Boolean
    fun setEventBlock(blockEvent: Boolean)
    fun isChanged(slot: Int): Boolean
    fun setChanged(slot: Int, change: Boolean)
    fun setPlayer(player: LivingEntity?)
}
