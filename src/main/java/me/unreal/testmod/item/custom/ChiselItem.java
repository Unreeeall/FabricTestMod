package me.unreal.testmod.item.custom;

import me.unreal.testmod.component.ModDataComponentTypes;
import me.unreal.testmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ChiselItem extends Item {



    public ChiselItem(Settings settings) {
        super(settings);
    }

    public static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.TUFF, Blocks.TUFF_BRICKS,
                    Blocks.MUD, Blocks.MUD_BRICKS,
                    Blocks.NETHERRACK, Blocks.NETHER_BRICKS,
                    Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS,
                    Blocks.STONE_SLAB, Blocks.STONE_BRICK_SLAB,
                    Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.DEEPSLATE_BRICK_SLAB
            );

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
               world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());

               context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                       item -> Objects.requireNonNull(context.getPlayer()).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

               world.playSound(null, context.getBlockPos(), ModSounds.CHISEL_USE, SoundCategory.BLOCKS);

               context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.testmod.chisel.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.testmod.chisel"));
        }

        if(stack.get(ModDataComponentTypes.COORDINATES) != null){
            tooltip.add(Text.literal("Last Block Changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
