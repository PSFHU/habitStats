/*
package pte.mik.habitstatsserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "user_role",
            joinColumns = {  @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id")}
    )
    @Getter
    @Setter
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    @Getter
    @Setter
    private List<Stat> stats;
}
*/
