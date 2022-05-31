package de.lostuxos.schniekern.server.usescases.impl;

import de.lostuxos.schniekern.server.adapter.out.persistence.PlayerRepositoryImpl;
import de.lostuxos.schniekern.server.outports.Caller;
import de.lostuxos.schniekern.server.outports.Move;
import de.lostuxos.schniekern.commons.dto.Symbol;
import de.lostuxos.schniekern.server.usescases.dto.Player;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SchnickernDomainTest {

    @Mock
    Caller caller;

    @Mock
    PlayerRepositoryImpl playerRepository;

    @InjectMocks
    SchnickernDomain schnickernDomain;

    @ParameterizedTest
    @CsvSource({"SCISSOR, SCISSOR, DRAW",
                "SCISSOR, PAPER, LEFT",
                "SCISSOR, ROCK, RIGHT",
                "PAPER , PAPER, DRAW",
                "PAPER, SCISSOR, RIGHT",
                "PAPER, ROCK, LEFT",
                "ROCK, ROCK, DRAW",
                "ROCK, PAPER, RIGHT",
                "ROCK, SCISSOR, LEFT"
                })
    public void testPlay(Symbol symbol1, Symbol symbol2, Result expected) {
        //WHEN
        var result =schnickernDomain.decide(symbol1, symbol2);

        //THEN
        assertEquals(expected, result);

    }

    @Test
    public void testRound() {
        //GIVEN
        var player1 = Player.builder().won(0).lost(0).id("001").name("Le Chiffre").score(100).build();
        var player2 = Player.builder().won(0).lost(0).id("007").name("James Bond").score(100).build();


        when(playerRepository.chooseOpponents()).thenReturn(Pair.of(player1, player2));
        when(caller.callPlayer(player1, player2)).thenReturn(Move.builder().stake(50).symbol(Symbol.ROCK).build());
        when(caller.callPlayer(player2, player1)).thenReturn(Move.builder().stake(50).symbol(Symbol.SCISSOR).build());
        //WHEN
        var round = schnickernDomain.playRound();

        //THEN
        assertEquals(player1,round.getWinner());
    }

}