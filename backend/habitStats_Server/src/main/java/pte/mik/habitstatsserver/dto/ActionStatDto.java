package pte.mik.habitstatsserver.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class CreateStatDto implements Serializable {
    private final String title;
    private final Integer categoryId;
    private final Integer unit_typeId;
}
