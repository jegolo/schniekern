package de.lostuxos.schniekern.server.usescases.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private String id;
    private String name;
    private int score;
    private int won;
    private int lost;
    private String clientUrl;

}
