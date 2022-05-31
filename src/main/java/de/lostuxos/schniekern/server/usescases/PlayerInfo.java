package de.lostuxos.schniekern.server.usescases;

import de.lostuxos.schniekern.server.usescases.dto.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerInfo {

    Optional<Player> getPlayer(String id);

    List<Player> getAll();
}
