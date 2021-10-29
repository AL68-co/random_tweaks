package net.albertlarsan.al68_tweaks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreLaunchEntryPoint implements PreLaunchEntrypoint {

    private static final Logger LOGGER = LogManager.getLogger(SharedConstants.FRIENDLY_NAME);

    @Override
    public void onPreLaunch() {
        LOGGER.info("Started PreLaunch");

        net.minecraft.SharedConstants.isDevelopment = true;

        LOGGER.info("Finished PreLaunch");

    }

}
