package pte.mik.habitstatsserver.entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    private Integer id;
    private String username;
    private String password;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = {  @JoinColumn(name = "USER_ID")},
            inverseJoinColumns = { @JoinColumn(name = "ROLE_ID")}
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Stat> stats;
}
