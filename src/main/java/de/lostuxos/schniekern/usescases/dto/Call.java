package de.lostuxos.schniekern.usescases.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Call {

    private Symbol symbolPlayerOne;
    private Symbol symbolPlayerTwo;

}
