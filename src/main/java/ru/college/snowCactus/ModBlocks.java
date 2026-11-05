
package ru.college.snow_cactus;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // 1. Создаем ключи заранее
    public static final RegistryKey<Block> CUSTOM_BLOCK_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(Snowcactus.MOD_ID, "snow_cactus")
    );

    public static final RegistryKey<Item> CUSTOM_ITEM_KEY = RegistryKey.of(
            RegistryKeys.ITEM,
            Identifier.of(Snowcactus.MOD_ID, "snow_cactus")
    );

    // 2. Создаем блок с ключом и свойствами
    public static final Block CUSTOM_BLOCK = new Block(AbstractBlock.Settings.create()
            .strength(2.0f, 6.0f)
            .luminance(state -> 10)
            .registryKey(CUSTOM_BLOCK_KEY)); // Привязываем ключ

    // 3. Создаем предмет с ключом
    public static final Item CUSTOM_BLOCK_ITEM = new BlockItem(CUSTOM_BLOCK, new Item.Settings()
            .registryKey(CUSTOM_ITEM_KEY)); // Привязываем ключ

    // 4. Регистрируем всё это в игре
    public static void initialize() {
        Registry.register(Registries.BLOCK, CUSTOM_BLOCK_KEY, CUSTOM_BLOCK);
        Registry.register(Registries.ITEM, CUSTOM_ITEM_KEY, CUSTOM_BLOCK_ITEM);
    }
}
