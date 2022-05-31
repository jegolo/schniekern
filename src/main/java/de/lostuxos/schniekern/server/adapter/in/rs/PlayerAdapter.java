package de.lostuxos.schniekern.server.adapter.in.rs;

import de.lostuxos.schniekern.server.adapter.in.rs.dto.RegistrationForm;
import de.lostuxos.schniekern.server.usescases.PlayerInfo;
import de.lostuxos.schniekern.server.usescases.Register;
import de.lostuxos.schniekern.server.usescases.dto.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/players")
public class PlayerAdapter {

    @Autowired
    private Register register;

    @Autowired
    private PlayerInfo playerInfo;

    @PostMapping()
    public Player register(@RequestBody RegistrationForm registrationForm) {
        return register.register(registrationForm.getName(), registrationForm.getClientURL());
    }

    @GetMapping(value="/{id}")
    public Player info(@PathVariable("id") String id) {
        return playerInfo.getPlayer(id).orElseThrow();
    }

    @GetMapping()
    public List<Player> getAllPlayer() {
        return playerInfo.getAll();
    }

}
