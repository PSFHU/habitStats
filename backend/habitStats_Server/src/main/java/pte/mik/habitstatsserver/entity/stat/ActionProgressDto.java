package pte.mik.habitstatsserver.entity.stat;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class ActionProgressDto implements Serializable {
    private final Long id;
    private final Long statId;
    private final Float value;
    private final Instant timestamp;
}
