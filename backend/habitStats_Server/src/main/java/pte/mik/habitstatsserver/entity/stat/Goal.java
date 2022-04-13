package pte.mik.habitstatsserver.entity.stat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String title;
    @Column(name = "goal_value")
    @Getter
    @Setter
    private Float value;
    @Column(name = "goal_logic")
    @Getter
    @Setter
    private String logic;
    @Column(name = "goal_completed")
    @Getter
    @Setter
    private Boolean completed;

    @JsonBackReference
    @ManyToMany(mappedBy = "goalList")
    @Getter
    @Setter
    private List<Stat> statList;
}
