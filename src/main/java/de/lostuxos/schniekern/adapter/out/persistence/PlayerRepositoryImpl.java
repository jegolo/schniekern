package de.lostuxos.schniekern.adapter.out.persistence;

import de.lostuxos.schniekern.outports.PlayerRepository;
import de.lostuxos.schniekern.usescases.dto.Player;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PlayerRepositoryImpl implements PlayerRepository {
   private static List<Player> players = new ArrayList<>();

    @Override
    public Optional<Player> getPlayer(String id) {
        return players.stream().filter(
                x -> id.equals(x.getId())).findFirst();

    }

    @Override
    public List<Player> getAll() {
        return players;
    }

    @Override
    public void add(Player player) {
        players.add(player);
    }

    @Override
     public Pair<Player, Player> chooseOpponents() {
        Player player1,player2;
        var players = getAll();
        do {
            player1 =players.get((int) Math.round(Math.random() * (players.size() -1)  ));
            player2 = players.get((int) Math.round(Math.random() * (players.size() -1) ));
        } while (player1.equals(player2));
        return Pair.of(player1, player2);
    }

}
