package pte.mik.habitstatsserver.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class StatDto implements Serializable {
    private final Integer id;
    private final String title;
    private final List<ProgressDto> progressList;
    private final String categoryName;
    private final String unit_typeName;

    @Data
    public static class ProgressDto implements Serializable {
        private final Integer id;
        private final Float value;
        private final Timestamp timestamp;
    }
}
