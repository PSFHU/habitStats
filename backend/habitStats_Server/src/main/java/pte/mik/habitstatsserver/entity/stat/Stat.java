package pte.mik.habitstatsserver.entity.stat;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stat")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    private Integer id;
    @Column(name = "stat_name")
    @Getter
    @Setter
    private String title;

    @JsonManagedReference
    @OneToMany(mappedBy = "stat", fetch = FetchType.LAZY)
    @Getter
    private List<Progress> progressList;

    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "goal_stat",
            joinColumns = { @JoinColumn(name = "stat_id")},
            inverseJoinColumns = { @JoinColumn(name = "goal_id")}
    )
    @Getter
    @Setter
    private List<Goal> goalList;

    /*@ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;*/
    @ManyToOne
    @JoinColumn(name = "stat_category_id")
    @Getter
    @Setter
    private StatCategory category;
    @ManyToOne
    @JoinColumn(name = "unit_type_id")
    @Getter
    @Setter
    private UnitType unit_type;
}
