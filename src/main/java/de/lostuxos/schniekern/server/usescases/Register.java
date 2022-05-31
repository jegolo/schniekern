package de.lostuxos.schniekern.server.usescases;

import de.lostuxos.schniekern.server.usescases.dto.Player;

public interface Register {

    Player register(String name, String clientUrl);

}
