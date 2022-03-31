package de.lostuxos.schniekern.usescases.impl;

import de.lostuxos.schniekern.usescases.Play;
import de.lostuxos.schniekern.usescases.PlayerInfo;
import de.lostuxos.schniekern.usescases.Register;
import de.lostuxos.schniekern.usescases.dto.Call;
import de.lostuxos.schniekern.usescases.dto.Player;
import de.lostuxos.schniekern.usescases.dto.Round;
import de.lostuxos.schniekern.usescases.dto.Symbol;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SchnickernDomain implements  Register, PlayerInfo,Play {

    private List<Player> players = new ArrayList<>();

    @Override
    public List<Round> play(int rounds) {
        var result = new ArrayList<Round>();
        for (var round = 0; round <rounds ; round++) {
            result.add(Round.builder()
                            .player1(players.stream().findAny().get())
                            .player2(players.stream().findAny().get())
                            .winner(players.stream().findAny().get())
                            .calls(List.of(Call.builder().symbolPlayerOne(Symbol.PAPER).symbolPlayerTwo(Symbol.SCISSOR).build()))
                            .stake(25).build()
                            );

        }

        return result;
    }

    @Override
    public Player register(String name, String clientUrl) {
        var player = Player.builder()
                .name(name)
                .id(UUID.randomUUID().toString())
                .score(0)
                .lost(0)
                .won(0)
                .clientUrl(clientUrl)
                .build();
        players.add(player);
        return player;
    }

    @Override
    public Optional<Player> getPlayer(String id) {
        return players.stream().filter(
                x -> id.equals(x.getId())).findFirst();

    }

    @Override
    public List<Player> getAll() {
        return players;
    }
}
