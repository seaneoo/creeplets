package dev.seano.creeplets;

import eu.midnightdust.lib.config.MidnightConfig;

public class CreepletsConfig extends MidnightConfig {

    @Entry
    public static int spawnWeight = 100;

    @Entry
    public static int fuseTime = 10;

    @Entry
    public static int explosionRadius = 1;

    @Entry
    public static float movementSpeed = 0.4f;
}
