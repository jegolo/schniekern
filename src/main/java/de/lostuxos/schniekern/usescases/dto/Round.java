package de.lostuxos.schniekern.usescases.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Round {

    private Player player1;
    private Player player2;

    private Player winner;

    private List<Call> calls;

    private double stake;
}
