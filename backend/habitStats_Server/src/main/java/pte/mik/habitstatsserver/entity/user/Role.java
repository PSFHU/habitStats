package pte.mik.habitstatsserver.entity.user;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pte.mik.habitstatsserver.entity.stat.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Table(name = Role.TBL_NAME)
public class Role extends AbstractEntity<Long> {

    public static final String TBL_NAME ="roles";
    public static final String FLD_ROLE_NAME="role_name";

    @ManyToMany(mappedBy = User.TBL_NAME)
    private List<User> userList;
    @Column(name = FLD_ROLE_NAME)
    private String name;
}