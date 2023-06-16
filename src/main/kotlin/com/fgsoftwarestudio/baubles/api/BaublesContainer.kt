package com.fgsoftwarestudio.baubles.api

import com.fgsoftwarestudio.baubles.api.IBauble.Companion.canEquip
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraftforge.items.ItemStackHandler

class BaublesContainer(override val isEventBlocked: Boolean) : ItemStackHandler(), IBaublesItemHandler {
    private val BAUBLE_SLOTS = 7
    private val changed: BooleanArray = BooleanArray(BAUBLE_SLOTS)
    private var blockEvents = false
    private var player: LivingEntity? = null

    init {
        setSize(BAUBLE_SLOTS)
    }

    /**
     * Sets the size of the container.
     * @param size The size of the container.
     */
    override fun setSize(size: Int) {
        val newSize = size.coerceAtLeast(BAUBLE_SLOTS)
        if (newSize != changed.size) {
            val oldChanged = changed.copyOf()
            changed.fill(false)
            System.arraycopy(oldChanged, 0, changed, 0, changed.size.coerceAtMost(oldChanged.size))
        }
        super.setSize(newSize)
    }

    override fun isItemValidForSlot(slot: Int, stack: ItemStack?, player: LivingEntity?): Boolean {
        if (stack == null || stack.isEmpty) {
            return false
        }

        val baubleType = stack.getBaubleType()
        return baubleType != null && baubleType.hasSlot(slot) && canEquip(stack, player)
    }

    private fun ItemStack.getBaubleType(): EBaubleType? {
        if (item is IBauble) {
            return (item as IBauble).getBaubleType(this)
        }
        return null
    }

    override fun setStackInSlot(slot: Int, stack: ItemStack) {
        if (stack.isEmpty || isItemValidForSlot(slot, stack, player)) {
            super.setStackInSlot(slot, stack)
        }
    }

    override fun insertItem(slot: Int, stack: ItemStack, simulate: Boolean): ItemStack {
        return if (isItemValidForSlot(slot, stack, player)) {
            super.insertItem(slot, stack, simulate)
        } else {
            stack
        }
    }

    fun isContainerEventBlocked(): Boolean {
        return blockEvents
    }

    override fun setEventBlock(blockEvent: Boolean) {
        this.blockEvents = blockEvent
    }

    override fun onContentsChanged(slot: Int) {
        setChanged(slot, true)
    }

    override fun isChanged(slot: Int): Boolean {
        return changed[slot]
    }

    override fun setChanged(slot: Int, change: Boolean) {
        changed[slot] = change
    }

    override fun setPlayer(player: LivingEntity?) {
        this.player = player
    }
}