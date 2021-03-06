package de.lostuxos.schniekern.server.outports;

import de.lostuxos.schniekern.server.usescases.dto.Player;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    Optional<Player> getPlayer(String id);

    List<Player> getAll();

    void add(Player player);

    Pair<Player, Player> chooseOpponents();
}
