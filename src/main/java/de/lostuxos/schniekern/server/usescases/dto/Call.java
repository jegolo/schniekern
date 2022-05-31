package de.lostuxos.schniekern.server.usescases.dto;

import de.lostuxos.schniekern.commons.dto.Symbol;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Call {

    private Symbol symbolPlayerOne;
    private Symbol symbolPlayerTwo;

}
