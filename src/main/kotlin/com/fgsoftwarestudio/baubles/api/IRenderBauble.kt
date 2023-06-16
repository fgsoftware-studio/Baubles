package com.fgsoftwarestudio.baubles.api

import com.mojang.blaze3d.platform.GlStateManager
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.MathHelper
import net.minecraftforge.event.world.NoteBlockEvent.Play


interface IRenderBauble {
    fun onPlayerBaubleRender(itemStack: ItemStack?, player: PlayerEntity?, renderType: RenderType?, partialTicks: Float)
    enum class RenderType {
        BODY,
        HEAD
    }

    object Helper {
        fun rotateIfSneaking(player: PlayerEntity) {
            if (player.isSneaking()) {
                applySneakingRotation()
            }
        }

        fun applySneakingRotation() {
            GlStateManager.translatef(0.0f, 0.2f, 0.0f)
            GlStateManager.rotatef(28.647888f, 1.0f, 0.0f, 0.0f)
        }

        fun translateToHeadLevel(player: PlayerEntity) {
            GlStateManager.translatef(0.0f, -player.eyeHeight, 0.0f)
            if (player.isSneaking()) {
                GlStateManager.translatef(
                    0.25f * MathHelper.sin(player.rotationPitch * Math.PI.toFloat() / 180.0f),
                    0.25f * MathHelper.cos(player.rotationPitch * Math.PI.toFloat() / 180.0f),
                    0.0f
                )
            }
        }

        fun translateToFace() {
            GlStateManager.rotatef(90.0f, 0.0f, 1.0f, 0.0f)
            GlStateManager.rotatef(180.0f, 1.0f, 0.0f, 0.0f)
            GlStateManager.translatef(0.0f, -4.35f, -1.27f)
        }

        fun defaultTransforms() {
            GlStateManager.translated(0.0, 3.0, 1.0)
            GlStateManager.scaled(0.55, 0.55, 0.55)
        }

        fun translateToChest() {
            GlStateManager.rotatef(180.0f, 1.0f, 0.0f, 0.0f)
            GlStateManager.translatef(0.0f, -3.2f, -0.85f)
        }
    }
}