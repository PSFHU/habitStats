package pte.mik.habitstatsserver.entity.stat;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;

@Data
public class ActionProgressDto implements Serializable {
    private final Integer id;
    private final Integer statId;
    private final Float value;
    private final Instant timestamp;
}
