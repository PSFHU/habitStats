package pte.mik.habitstatsserver.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MapperGoalDto implements Serializable {
    // TODO Make it use lists for ease of use
    private final Long statId;
    private final Long goalId;
}
