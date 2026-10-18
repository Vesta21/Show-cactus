
package ru.college.snowCactus;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CUSTOM_BLOCK;
    public static final Item CUSTOM_BLOCK_ITEM;

    static {
        // 1. Создаем ключи реестра для блока и предмета
        Identifier blockId = Identifier.of(SnowCactus.MOD_ID, "snow_cactus");
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, blockId);

        Identifier itemId = Identifier.of(SnowCactus.MOD_ID, "snow_cactus");
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, itemId);

        // 2. Создаем и регистрируем блок
        CUSTOM_BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).registryKey(blockKey));
        Registry.register(Registries.BLOCK, blockKey, CUSTOM_BLOCK);

        // 3. Создаем и регистрируем предмет для блока
        CUSTOM_BLOCK_ITEM = new BlockItem(CUSTOM_BLOCK, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, CUSTOM_BLOCK_ITEM);
    }

    public static void registerModBlocks() {
        System.out.println("Регистрация блоков для мода: " + SnowCactus.MOD_ID);
    }
}