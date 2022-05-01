package pte.mik.habitstatsserver.entity.stat;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Table(name = Stat.TBL_NAME)
public class Stat extends AbstractEntity<Long>{

    public static final String TBL_NAME="stat";
    public static final String FLD_TITLE="stat_name";
    public static final String CON_GOAL_LIST="goal_stat";

    @Column(name = FLD_TITLE)
    private String title;

    @JsonManagedReference
    @OneToMany(mappedBy = "stat", fetch = FetchType.LAZY)
    private List<Progress> progressList;

    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = CON_GOAL_LIST,
            joinColumns = { @JoinColumn(name = Stat.FLD_ID)},
            inverseJoinColumns = { @JoinColumn(name = Goal.FLD_ID)}
    )
    private List<Goal> goalList;

    /*@ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;*/

    @ManyToOne
    @JoinColumn(name = StatCategory.FLD_ID)
    private StatCategory category;

    @ManyToOne
    @JoinColumn(name = UnitType.FLD_ID)
    private UnitType unit_type;
}
