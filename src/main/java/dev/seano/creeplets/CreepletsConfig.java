package dev.seano.creeplets;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Creeplets.MOD_ID)
public class CreepletsConfig implements ConfigData {

	@Comment("The time it takes for the Creeplet to explode. Default of the vanilla Creeper is '30'.")
	public int fuseTime = 15;

	@Comment("The size of the explosion. Default of the vanilla Creeper is '3'.")
	public int explosionRadius = 2;

	@Comment("How fast the Creeplet moves. Default of the vanilla Creeper is '0.25'.")
	public double movementSpeed = 0.4;

	@Comment("The maximum health of the Creeplet. Default of the vanilla Creeper is '20'.")
	public double maxHealth = 10;
}
