package de.lostuxos.schniekern.bot.adapter.out;

import de.lostuxos.schniekern.bot.outports.RegisterBotAtServer;
import de.lostuxos.schniekern.bot.usecases.Bot;
import de.lostuxos.schniekern.server.adapter.in.rs.dto.RegistrationForm;
import de.lostuxos.schniekern.server.usescases.dto.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SSPServerAdapter implements RegisterBotAtServer {



    @Override
    public void registerBot(Bot bot) {
        RestTemplate restTemplate = new RestTemplate();
        var registrationForm = RegistrationForm.builder()
                        .clientURL("http://localhost:8080/bot/" + bot.getId())
                                .name(bot.getName())
                                        .build();

        var response = restTemplate.postForObject("http://localhost:8080/players", registrationForm, Player.class);
    }
}
