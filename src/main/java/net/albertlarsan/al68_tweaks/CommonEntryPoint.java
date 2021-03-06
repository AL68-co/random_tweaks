package net.albertlarsan.al68_tweaks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.albertlarsan.al68_tweaks.item.Items;
import net.fabricmc.api.ModInitializer;

public class CommonEntryPoint implements ModInitializer {

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	private static final Logger LOGGER = LogManager.getLogger(SharedConstants.FRIENDLY_NAME);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Started Initializing");
		LOGGER.info(Items.ITEMS_ITEM_GROUP);
		LOGGER.info("Finished Initializing");

	}

}
