package de.lostuxos.schniekern.usescases.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServerInfo {

    private int registeredPlayers;
    private double fee;

}
