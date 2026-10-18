package ru.college.snowCactus;

import net.fabricmc.api.ModInitializer;

import static com.mojang.text2speech.Narrator.LOGGER;

public class SnowCactus implements ModInitializer {

    @Override
    public void onInitialize() {
        LOGGER.info("Проект загружен");
    }
}
