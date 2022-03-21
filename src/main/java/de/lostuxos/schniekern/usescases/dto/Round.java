package de.lostuxos.schniekern.usescases.dto;

import lombok.Data;

import java.util.List;

@Data
public class Round {

    private Player player1;
    private Player player2;

    private Player winner;

    private List<Call> calls;
}
