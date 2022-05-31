package de.lostuxos.schniekern.server.adapter.out.rs;

import de.lostuxos.schniekern.bot.adapter.in.params.CallRequest;
import de.lostuxos.schniekern.server.outports.Caller;
import de.lostuxos.schniekern.server.outports.Move;
import de.lostuxos.schniekern.server.usescases.dto.Player;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallerImpl implements Caller {
    @Override
    public Move callPlayer(Player player) {
        RestTemplate restTemplate = new RestTemplate();
        var move = restTemplate.postForObject(
                player.getClientUrl(),
                CallRequest.builder().roundId("?").opponent("?").build(),
                Move.class);


        return move;
    }
}
