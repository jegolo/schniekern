package de.lostuxos.schniekern.adapter.in.rs;

import de.lostuxos.schniekern.adapter.in.rs.dto.RegistrationForm;
import de.lostuxos.schniekern.usescases.GetServerInfo;
import de.lostuxos.schniekern.usescases.Register;
import de.lostuxos.schniekern.usescases.dto.Player;
import de.lostuxos.schniekern.usescases.dto.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchnickernAdapter {

    @Autowired
    private GetServerInfo getServerInfo;

    @Autowired
    private Register register;

    @GetMapping(value="/info")
    public ServerInfo getServerInfo() {
        return getServerInfo.info();
    }

    @PutMapping(value="/register")
    public Player register(RegistrationForm registrationForm) {
        return register.register(registrationForm.getName(), registrationForm.getClientUrl());
    }

}
