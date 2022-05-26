package pte.mik.habitstatsserver.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pte.mik.habitstatsserver.entity.stat.AbstractEntity;
import pte.mik.habitstatsserver.entity.stat.Stat;
import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Table(name = User.TBL_NAME)
public class User extends AbstractEntity<Long> {

    public static final String TBL_NAME="users";
    public static final String FLD_USERNAME="username";
    public static final String FLD_PASSWORD="password";
    public static final String JN_TABLE_NAME="user_role";
    public static final String JN_FLD_USER_ID="user_id";
    public static final String JN_FLD_ROLE_ID="role_id";

    @Column(name = User.FLD_USERNAME)
    private String username;
    @JsonIgnoreProperties
    @Column(name = User.FLD_PASSWORD)
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = User.JN_TABLE_NAME,
            joinColumns = {  @JoinColumn(name = User.JN_FLD_USER_ID)},
            inverseJoinColumns = { @JoinColumn(name = User.JN_FLD_ROLE_ID)}
    )
    private List<Role> roles;

    @OneToMany(mappedBy = Stat.TBL_NAME)
    private List<Stat> stats;
}
