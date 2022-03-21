package de.lostuxos.schniekern.usescases.impl;

import de.lostuxos.schniekern.usescases.*;
import de.lostuxos.schniekern.usescases.dto.Player;
import de.lostuxos.schniekern.usescases.dto.Round;
import de.lostuxos.schniekern.usescases.dto.ServerInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class SchnickernDomain implements GetAmount, GetHighScore, GetServerInfo, Play, Register {

    private List<Player> players = new ArrayList<>();

    @Override
    public Integer getAmount() {
        return null;
    }

    @Override
    public List<Player> highscore() {
        return null;
    }

    @Override
    public ServerInfo info() {
        return ServerInfo.builder()
                .fee(0.1)
                .registeredPlayers(players.size())
                .build();
    }

    @Override
    public List<Round> play(int rounds) {
        return null;
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
}
