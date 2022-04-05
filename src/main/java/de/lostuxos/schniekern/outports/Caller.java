package de.lostuxos.schniekern.outports;

import de.lostuxos.schniekern.usescases.dto.Player;

public interface Caller {
    Move callPlayer(Player left);
}
