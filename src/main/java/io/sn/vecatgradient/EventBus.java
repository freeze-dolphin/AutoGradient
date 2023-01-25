package io.sn.vecatgradient;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.slf4j.Logger;

import java.awt.image.BufferedImage;

public class EventBus {

    private final Logger logger;
    private final BufferedImage bi;

    public EventBus(Logger logger, BufferedImage bi) {
        this.logger = logger;
        this.bi = bi;
    }

    @Subscribe
    public void onChat(PlayerChatEvent evt) {
        if (evt.getPlayer().getUsername().equals("Freeze_Dolphin")) {
            String[] args = evt.getMessage().split(" ");

            if (!args[0].equals("test")) {
                StringBuilder sb = new StringBuilder();
                for (String s : args) {
                    String gradient = Utils.gradientString(s, bi);
                    sb.append(s.equals("&i") ? s : gradient);
                    sb.append(" ");
                }
                evt.setResult(PlayerChatEvent.ChatResult.message(sb.toString()));
            } else {
                evt.setResult(PlayerChatEvent.ChatResult.denied());
                TextComponent comp = Component.empty();
                for (String s : args) {
                    String gradient = Utils.gradientString(s, bi);
                    for (String cs : gradient.split("\\{")) {
                        if (cs.isEmpty()) continue;
                        comp = comp.append(Component.text(cs.substring(8)).color(TextColor.fromHexString(cs.substring(0, 7))));
                    }
                    comp = comp.append(Component.text(" "));
                }
                evt.getPlayer().sendMessage(comp);
            }
        }
    }

}
