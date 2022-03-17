package pte.mik.habitstatsserver.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STAT")
public class Stat {
    @Id
    private Integer id;
    private String title;
    @OneToMany(mappedBy = "stat")
    private List<Progress> progressList;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne
    @JoinColumn(name = "STAT_CATEGORY_ID")
    private StatCategory category;
    @ManyToOne
    @JoinColumn(name = "UNIT_TYPE_ID")
    private UnitType unit_type;
}
