package com.fgsoftwarestudio.baubles.api

enum class EBaubleType(vararg var validSlots: Int) {
    AMULET(*intArrayOf(0)),
    RING(*intArrayOf(1, 2)),
    BELT(*intArrayOf(3)),
    TRINKET(*intArrayOf(0, 1, 2, 3, 4, 5, 6)),
    HEAD(*intArrayOf(4)),
    BODY(*intArrayOf(5)),
    CHARM(*intArrayOf(6));

    fun hasSlot(slot: Int): Boolean {
        val var2 = validSlots
        val var3 = var2.size
        for (var4 in 0 until var3) {
            val s = var2[var4]
            if (s == slot) {
                return true
            }
        }
        return false
    }
}