package pte.mik.habitstatsserver.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    private Integer id;
    @ManyToMany(mappedBy = "roles")
    private List<User> userList;
    @Column(name = "role_name")
    private String name;
}
