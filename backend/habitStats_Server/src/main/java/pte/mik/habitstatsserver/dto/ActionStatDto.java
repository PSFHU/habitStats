package pte.mik.habitstatsserver.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ActionStatDto implements Serializable {
    private final Long id;
    private final String title;
    private final Long categoryId;
    private final Long unit_typeId;
}
