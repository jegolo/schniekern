package de.lostuxos.schniekern.bot.usecases;

import de.lostuxos.schniekern.bot.usecases.impl.RandomResponseBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    BotRegistry botRegistry;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        botRegistry.add(new RandomResponseBot("James Bond", 50));
        botRegistry.add(new RandomResponseBot("Le Chiffre", 100));
    }
}
