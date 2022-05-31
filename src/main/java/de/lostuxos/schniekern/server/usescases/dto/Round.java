package de.lostuxos.schniekern.server.usescases.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Round {

    private Player player1;
    private Player player2;

    private Player winner;

    private List<Call> calls;

    private double stake;
}
