package de.lostuxos.schniekern.bot.usecases.impl;

import de.lostuxos.schniekern.bot.outports.RegisterBotAtServer;
import de.lostuxos.schniekern.bot.usecases.Bot;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public abstract class AbstractBot implements Bot {
    private String botId;
    private String name;
    private Integer amount;

    public AbstractBot(String name, Integer amount) {
        botId = UUID.randomUUID().toString();
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String getId() {
        return botId;
    }

    @Override
    public String getName() {
        return name;
    }


}
