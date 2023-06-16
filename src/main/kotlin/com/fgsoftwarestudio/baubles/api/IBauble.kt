package com.fgsoftwarestudio.baubles.api

import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack

interface IBauble {
    companion object {
        fun onEquipped(itemstack: ItemStack?, player: LivingEntity?) {}

        fun onUnequipped(itemstack: ItemStack?, player: LivingEntity?) {}

        fun canEquip(itemstack: ItemStack?, player: LivingEntity?): Boolean {
            return true
        }

        fun canUnequip(itemstack: ItemStack?, player: LivingEntity?): Boolean {
            return true
        }
    }

    fun getBaubleType(itemstack: ItemStack?): EBaubleType?

    fun onWornTick(itemstack: ItemStack?, player: LivingEntity?) {}

    fun willAutoSync(itemstack: ItemStack?, player: LivingEntity?): Boolean {
        return false
    }
}