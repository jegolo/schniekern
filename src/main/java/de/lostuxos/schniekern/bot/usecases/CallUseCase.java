package de.lostuxos.schniekern.bot.usecases;

import de.lostuxos.schniekern.bot.adapter.in.params.Move;
import de.lostuxos.schniekern.bot.usecases.params.Call;

public interface CallUseCase {

    Move playRound(Call call);
}
