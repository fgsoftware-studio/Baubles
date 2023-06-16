package com.fgsoftwarestudio.baubles.api

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.util.Direction

class BaublesAPI {
    /**
     * Retrieves the baubles handler for the given player.
     *
     * @param player The player entity.
     * @return The baubles item handler.
     */
    fun getBaublesHandler(player: PlayerEntity): IBaublesItemHandler {
        val handler: IBaublesItemHandler =
            player.getCapability(BaublesCapabilities.CAPABILITY_BAUBLES!!, null as Direction?) as IBaublesItemHandler
        handler.setPlayer(player)
        return handler
    }

    /**
     * [Deprecated] Checks if the specified bauble is equipped by the player.
     * @param player The player entity.
     * @param bauble The bauble item to check.
     * @return The slot index where the bauble is equipped, or -1 if not found.
     * @deprecated Use [isBaubleEquipped(player: PlayerEntity, bauble: Item, baubleSlot: Int)] instead.
     */
    @Deprecated(
        "Use isBaubleEquipped instead",
        ReplaceWith("isBaubleEquipped(player: PlayerEntity, bauble: Item, baubleSlot: Int")
    )
    fun isBaubleEquipped(player: PlayerEntity, bauble: Item): Int {
        val handler: IBaublesItemHandler = getBaublesHandler(player)
        for (a in 0 until handler.slots) {
            if (!handler.getStackInSlot(a).isEmpty && handler.getStackInSlot(a).item === bauble) {
                return a
            }
        }
        return -1
    }

    /**
     * Checks if the specified bauble is equipped by the player in the given slot.
     *
     * @param player     The player entity.
     * @param bauble     The bauble item to check.
     * @param baubleSlot The bauble slot index.
     * @return `true` if the bauble is equipped in the specified slot, `false` otherwise.
     */
    fun isBaubleEquipped(player: PlayerEntity, bauble: Item, baubleSlot: Int): Boolean {
        val handler: IBaublesItemHandler = getBaublesHandler(player)
        return baubleSlot >= 0 && baubleSlot < handler.slots &&
                !handler.getStackInSlot(baubleSlot).isEmpty &&
                handler.getStackInSlot(baubleSlot).item == bauble
    }
}