package de.lostuxos.schniekern.bot.usecases.impl;

import de.lostuxos.schniekern.bot.adapter.in.params.Move;
import de.lostuxos.schniekern.bot.usecases.params.Call;
import de.lostuxos.schniekern.commons.dto.Symbol;

public class RandomResponseBot extends AbstractBot {


    public RandomResponseBot(String name, Integer amount) {
        super(name, amount);
    }

    @Override
    public Move playRound(Call call) {
        //ASK Server for My Infos

        int rand = (int) Math.round(Math.random() * 2);
        Move move = Move.builder()
                .stake(0)
                .symbol(Symbol.values()[rand])
                .build();

        return move;
    }
}
