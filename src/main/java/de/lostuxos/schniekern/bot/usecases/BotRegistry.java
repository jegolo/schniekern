package de.lostuxos.schniekern.bot.usecases;

import de.lostuxos.schniekern.bot.outports.RegisterBotAtServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class BotRegistry {

    @Autowired
    private RegisterBotAtServer registerBotAtServer;

    private Map<String, Bot> botRegistry = new HashMap<>();

    public void add(Bot bot) {
        registerBotAtServer.registerBot(bot);
        botRegistry.put(bot.getId(), bot);
    }

    public Optional<Bot> findBotById(String id) {
        return Optional.ofNullable(botRegistry.getOrDefault(id, null));
    }
}
