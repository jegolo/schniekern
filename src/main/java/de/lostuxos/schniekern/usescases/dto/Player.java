package de.lostuxos.schniekern.usescases.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

    private String id;
    private String name;
    private int score;
    private int won;
    private int lost;
    private String clientUrl;

}
