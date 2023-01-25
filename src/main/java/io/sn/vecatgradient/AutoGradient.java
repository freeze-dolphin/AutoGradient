package io.sn.vecatgradient;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@Plugin(
        id = "vecatgradient",
        name = "VecAutoGradient",
        version = "1.0-SNAPSHOT"
)
public class AutoGradient {

    private final Logger logger;
    private final ProxyServer server;

    @Inject
    public AutoGradient(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;

        logger.info("AutoGradient loaded!");
    }

    @Subscribe
    public void onInitialize(ProxyInitializeEvent evt) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(Objects.requireNonNull(
                    AutoGradient.class.getClassLoader().getResourceAsStream("gradient.png")));
            server.getEventManager().register(this, new EventBus(logger, bi));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
