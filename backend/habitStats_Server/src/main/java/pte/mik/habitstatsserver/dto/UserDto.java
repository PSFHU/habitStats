package pte.mik.habitstatsserver.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {
    private final Integer id;
    private final String username;
    private final List<RoleDto> roles;
    private final List<ActionStatDto> stats;
}
