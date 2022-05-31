package de.lostuxos.schniekern.bot.usecases.params;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Call {
    String opponent;
    String roundId;
}
