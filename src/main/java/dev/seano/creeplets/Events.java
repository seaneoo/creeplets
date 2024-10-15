package dev.seano.creeplets;

import dev.seano.creeplets.entity.Creeplet;
import dev.seano.creeplets.registry.Entities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreepletsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Events {

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(Entities.CREEPLET.get(), Creeplet.createAttributes().build());
	}
}
