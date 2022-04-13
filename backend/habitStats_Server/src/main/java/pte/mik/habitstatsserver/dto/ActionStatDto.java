package pte.mik.habitstatsserver.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ActionStatDto implements Serializable {
    private final Integer id;
    private final String title;
    private final Integer categoryId;
    private final Integer unit_typeId;
}
