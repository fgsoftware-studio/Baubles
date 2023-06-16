package com.fgsoftwarestudio.baubles.api

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.util.text.ITextComponent
import net.minecraft.util.text.StringTextComponent

class BaublesInventoryWrapper : IInventory, IBaublesInventory {
    val handler: IBaublesItemHandler
    val player: PlayerEntity?

    constructor(handler: IBaublesItemHandler) {
        this.handler = handler
        player = null
    }

    constructor(handler: IBaublesItemHandler, player: PlayerEntity?) {
        this.handler = handler
        this.player = player
    }

    override fun getName(): String {
        return "BaublesInventory"
    }

    override fun hasCustomName(): Boolean {
        return false
    }

    override fun getDisplayName(): ITextComponent {
        return StringTextComponent(getName())
    }

    override fun size(): Int {
        return handler.slots
    }

    override fun isEmpty(): Boolean {
        return false
    }

    override fun getStackInSlot(index: Int): ItemStack {
        return handler.getStackInSlot(index)
    }

    override fun decrStackSize(index: Int, count: Int): ItemStack {
        return handler.extractItem(index, count, false)
    }

    override fun removeStackFromSlot(index: Int): ItemStack {
        val stack = getStackInSlot(index)
        setInventorySlotContents(index, ItemStack.EMPTY)
        return stack
    }

    override fun setInventorySlotContents(index: Int, stack: ItemStack) {
        handler.setStackInSlot(index, stack)
    }

    override fun getInventoryStackLimit(): Int {
        return 64
    }

    override fun markDirty() {}

    override fun isUsableByPlayer(player: PlayerEntity): Boolean {
        return true
    }

    override fun openInventory(player: PlayerEntity) {}

    override fun closeInventory(player: PlayerEntity) {}

    override fun isItemValidForSlot(index: Int, stack: ItemStack): Boolean {
        return handler.isItemValidForSlot(index, stack, player)
    }

    fun getField(id: Int): Int {
        return 0
    }

    fun setField(id: Int, value: Int) {}

    fun getFieldCount(): Int {
        return 0
    }

    override fun clear() {
        for (i in 0 until this.sizeInventory) {
            this.setInventorySlotContents(i, ItemStack.EMPTY)
        }
    }

    override fun getSizeInventory(): Int {
        return handler.slots
    }
}