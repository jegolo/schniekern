package de.lostuxos.schniekern.bot.adapter.in.params;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CallRequest {
    String opponent;
    String roundId;
}