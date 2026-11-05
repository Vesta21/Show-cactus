package ru.college.snow_cactus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemGroups;

import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Snowcactus implements ModInitializer {

    public static final String MOD_ID = "snow_cactus";
    public static final Logger LOGGER = LoggerFactory.getLogger (MOD_ID);
    @Override
    public void onInitialize() {

        ModBlocks.initialize();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CUSTOM_BLOCK_ITEM);
            UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
                if (!world.isClient()) {
                    BlockState state = world.getBlockState(hitResult.getBlockPos());
                    if (state.isOf(ModBlocks.CUSTOM_BLOCK)) {

                        player.sendMessage(Text.literal("Снежный кактус приветствует вас!"), false);
                        return ActionResult.SUCCESS;
                    }
                }
                return ActionResult.PASS;
            });
        });

        LOGGER.info("Проект загружен успешно");
    }
}




