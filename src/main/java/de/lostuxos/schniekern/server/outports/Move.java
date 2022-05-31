package de.lostuxos.schniekern.server.outports;

import de.lostuxos.schniekern.commons.dto.Symbol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Move {
   private Symbol symbol;
   private int stake;
}
