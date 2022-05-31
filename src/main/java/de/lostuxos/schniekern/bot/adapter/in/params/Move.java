package de.lostuxos.schniekern.bot.adapter.in.params;

import de.lostuxos.schniekern.commons.dto.Symbol;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Move {
    private Symbol symbol;
    private int stake;

}
