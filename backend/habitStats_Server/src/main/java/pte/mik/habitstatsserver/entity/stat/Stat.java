package pte.mik.habitstatsserver.entity.stat;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pte.mik.habitstatsserver.entity.user.User;

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
    public static final String FLD_UNIT_TYPE_ID="unit_type_id";
    public static final String FLD_STAT_CAT_ID="stat_category_id";
    public static final String FLD_USER_ID="user_id";
    public static final String JN_GOAL_LIST="goal_stat";
    public static final String JN_FLD_STAT_ID="stat_id";
    public static final String JN_FLD_GOAL_ID="goal_id";


    @Column(name = FLD_TITLE)
    private String title;

    @JsonManagedReference
    @OneToMany(mappedBy = TBL_NAME, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Progress> progressList;

    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = JN_GOAL_LIST,
            joinColumns = { @JoinColumn(name = JN_FLD_STAT_ID)},
            inverseJoinColumns = { @JoinColumn(name = JN_FLD_GOAL_ID)}
    )
    private List<Goal> goalList;

    @ManyToOne
    @JoinColumn(name = FLD_USER_ID)
    private User user;

    @ManyToOne
    @JoinColumn(name = FLD_STAT_CAT_ID)
    private StatCategory category;

    @ManyToOne
    @JoinColumn(name = FLD_UNIT_TYPE_ID)
    private UnitType unit_type;
}
