package de.lostuxos.schniekern.server.outports;

import de.lostuxos.schniekern.server.usescases.dto.Player;

public interface Caller {
    Move callPlayer(Player left);
}
