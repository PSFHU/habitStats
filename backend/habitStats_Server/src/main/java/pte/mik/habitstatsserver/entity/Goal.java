package pte.mik.habitstatsserver.entity;

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
    private List<Stat> statList = new ArrayList<>();
}
