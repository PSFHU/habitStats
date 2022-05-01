package pte.mik.habitstatsserver.entity.stat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Table(name = Goal.TBL_NAME)
public class Goal extends AbstractEntity<Long>{

    public static final String TBL_NAME="goal";
    public static final String FLD_TITLE="title";
    public static final String FLD_VALUE="goal_value";
    public static final String FLD_LOGIC="goal_logic";
    public static final String FLD_COMPLETED="goal";

    @Column(name = FLD_TITLE)
    private String title;
    @Column(name = FLD_VALUE)
    private Float value;
    @Column(name = FLD_LOGIC)
    private String logic;
    @Column(name = FLD_COMPLETED)
    private Boolean completed;

    @JsonBackReference
    @ManyToMany(mappedBy = "goalList")
    private List<Stat> statList;
}
