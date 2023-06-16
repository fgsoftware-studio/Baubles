package com.fgsoftwarestudio.baubles.api

import net.minecraft.item.ItemStack

class BaubleItem : IBauble {
    private var baubleType: EBaubleType? = null

    /**
     * Creates a new instance of BaubleItem with the specified bauble type.
     * @param type The type of the bauble.
     */
    fun BaubleItem(type: EBaubleType?) {
        baubleType = type
    }

    /**
     * Retrieves the bauble type of the specified ItemStack.
     * @param itemstack The ItemStack to get the bauble type from.
     * @return The bauble type of the ItemStack.
     */
    override fun getBaubleType(itemstack: ItemStack?): EBaubleType? {
        return baubleType
    }
}