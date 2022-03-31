package de.lostuxos.schniekern.adapter.in.rs;

import de.lostuxos.schniekern.usescases.Play;
import de.lostuxos.schniekern.usescases.dto.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameAdapter {

    @Autowired
    private Play play;

    @GetMapping("play")
    public List<Round> play(@RequestParam("rounds") Integer roundsParam) {
        var rounds = roundsParam != null?roundsParam:1;
        return play.play(rounds);
    }
}
