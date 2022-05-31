package de.lostuxos.schniekern.server.usescases;

import de.lostuxos.schniekern.server.usescases.dto.Round;

import java.util.List;

public interface Play {

    List<Round> play(int rounds);
}
