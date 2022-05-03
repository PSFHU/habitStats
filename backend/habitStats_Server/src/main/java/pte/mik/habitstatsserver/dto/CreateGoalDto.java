package pte.mik.habitstatsserver.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateGoalDto implements Serializable {
    private final String title;
    private final Float value;
    private final String logic;
    private final Boolean completed;
    private final List<Long> statListIds;
}
