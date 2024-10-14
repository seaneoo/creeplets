package dev.seano.creeplets;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Creeplets.MOD_ID)
public class CreepletsConfig implements ConfigData {

	@Comment("The time it takes for the Creeplet to explode. Default for vanilla Creeper is '30'.")
	public int fuseTime = 10;

	@Comment("The size of the explosion. Default for vanilla Creeper is '3'.")
	public int explosionRadius = 2;

	@Comment("How fast the Creeplet moves. Default for vanilla Creeper is '0.25'.")
	public double movementSpeed = 0.5;

	@Comment("The maximum health of the Creeplet. Default for vanilla Creeper is '20'.")
	public double maxHealth = 10;

	@Comment("The time it takes for the Unstable TNT to explode. Default for vanilla TNT is '80'.")
	public int tntFuseTime = 10;

	@Comment("The minimum power of the Unstable TNT. Vanilla TNT explodes at a power of '4'.")
	public float tntMinPower = 2f;

	@Comment("The maximum power of the Unstable TNT. Vanilla TNT explodes at a power of '4'.")
	public float tntMaxPower = 10f;
}
