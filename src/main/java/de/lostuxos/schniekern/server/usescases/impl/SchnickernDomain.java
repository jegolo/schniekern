package de.lostuxos.schniekern.server.usescases.impl;

import de.lostuxos.schniekern.server.outports.Caller;
import de.lostuxos.schniekern.server.outports.Move;
import de.lostuxos.schniekern.server.outports.PlayerRepository;
import de.lostuxos.schniekern.server.usescases.Play;
import de.lostuxos.schniekern.server.usescases.PlayerInfo;
import de.lostuxos.schniekern.server.usescases.Register;
import de.lostuxos.schniekern.server.usescases.dto.Call;
import de.lostuxos.schniekern.server.usescases.dto.Player;
import de.lostuxos.schniekern.server.usescases.dto.Round;
import de.lostuxos.schniekern.commons.dto.Symbol;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class SchnickernDomain implements  Register, PlayerInfo,Play {

    private final PlayerRepository playerRepository;

    @Autowired
    private final Caller caller;

    @Override
    public List<Round> play(int rounds) {
        var result = new ArrayList<Round>();
        for (var round = 0; round <rounds ; round++) {
            result.add(playRound());
        }

        return result;
    }

    public Round playRound() {
        var round = new Round();
        round.setCalls(new ArrayList<>());
        var opponents = playerRepository.chooseOpponents();

        Move movePlayer1;
        Move movePlayer2;

        Result result;
        do {
            movePlayer1 = caller.callPlayer(opponents.getLeft(), opponents.getRight());
            movePlayer2 = caller.callPlayer(opponents.getRight(), opponents.getLeft());
            result = decide(movePlayer1.getSymbol(), movePlayer2.getSymbol());
            round.setPlayer1(opponents.getLeft());
            round.setPlayer2(opponents.getRight());
            round.getCalls().add(Call.builder().symbolPlayerOne(movePlayer1.getSymbol()).symbolPlayerTwo(movePlayer2.getSymbol()).build());
        } while (Result.DRAW.equals(result)) ;

        if (Result.LEFT.equals(result)) {
            setWinner(round, opponents.getLeft(), opponents.getRight(), movePlayer2.getStake());
            opponents.getLeft().setWon(opponents.getLeft().getWon()+1);
            opponents.getRight().setLost(opponents.getRight().getLost()+1);
        } else {
            setWinner(round, opponents.getRight(), opponents.getLeft(), movePlayer1.getStake());
            opponents.getRight().setWon(opponents.getRight().getWon()+1);
            opponents.getLeft().setLost(opponents.getLeft().getLost()+1);
        }

       return round;
    }

    private void setWinner(Round round, Player winner, Player looser, int stake) {
        round.setWinner(winner);
        winner.setScore(winner.getScore() + stake );
        looser.setScore(looser.getScore() - stake );
    }


    public Result decide(Symbol symbol1, Symbol symbol2) {
        if (symbol1.equals(symbol2)) {
            return Result.DRAW;
        } else if (symbol1.ordinal() %2 == symbol2.ordinal()) {
            return Result.RIGHT;
        } else if (symbol1.ordinal() > symbol2.ordinal() || symbol1.ordinal() == symbol2.ordinal() %2) {
            return Result.LEFT;
        } else
            return Result.RIGHT;
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
        playerRepository.add(player);
        return player;
    }


    @Override
    public Optional<Player> getPlayer(String id) {
        return playerRepository.getPlayer(id);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.getAll();
    }
}
