package com.fgsoftwarestudio.baubles.api

import net.minecraft.nbt.INBT
import net.minecraft.util.Direction
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.Capability.IStorage

import net.minecraftforge.common.capabilities.CapabilityInject

class BaublesCapabilities {
    companion object {
        @CapabilityInject(IBaublesItemHandler::class)
        var CAPABILITY_BAUBLES: Capability<IBaublesItemHandler>? = null

        @CapabilityInject(IBauble::class)
        val CAPABILITY_ITEM_BAUBLE: Capability<IBauble?>? = null
    }

    class CapabilityItemBaubleStorage : IStorage<IBauble?> {
        /**
         * Writes the capability data to NBT.
         * @param capability The capability being written.
         * @param instance The instance of the capability being written.
         * @param side The side for which the data is being written.
         * @return The NBT representation of the capability data.
         */
        override fun writeNBT(capability: Capability<IBauble?>?, instance: IBauble?, side: Direction?): INBT? {
            return null
        }

        /**
         * Read the capability data to NBT.
         * @param capability The capability being read.
         * @param instance The instance of the capability being read.
         * @param side The side for which the data is being read.
         * @param nbt The NBT for which the data is being read.
         */
        override fun readNBT(capability: Capability<IBauble?>?, instance: IBauble?, side: Direction?, nbt: INBT?) {}

        fun writeNBT() {
            TODO("backwards compat")
        }

        fun readNBT() {
            TODO("backwards compat")
        }
    }

    class CapabilityBaubles<T : IBaublesItemHandler?> : IStorage<IBaublesItemHandler?> {
        /**
         * Writes the capability data to NBT.
         * @param capability The capability being written.
         * @param instance The instance of the capability being written.
         * @param side The side for which the data is being written.
         * @return The NBT representation of the capability data.
         */
        override fun writeNBT(
            capability: Capability<IBaublesItemHandler?>?,
            instance: IBaublesItemHandler?,
            side: Direction?
        ): INBT? {
            return null
        }

        /**
         * Read the capability data to NBT.
         * @param capability The capability being read.
         * @param instance The instance of the capability being read.
         * @param side The side for which the data is being read.
         * @param nbt The NBT for which the data is being read.
         */
        override fun readNBT(
            capability: Capability<IBaublesItemHandler?>?,
            instance: IBaublesItemHandler?,
            side: Direction?,
            nbt: INBT?
        ) {
        }

        fun writeNBT() {
            TODO("backwards compat")
        }

        fun readNBT() {
            TODO("backwards compat")
        }
    }
}
