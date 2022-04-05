package pte.mik.habitstatsserver.entity.stat;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stat_category")
public class StatCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;
    @Column(name = "stat_category_name")
    @Getter
    @Setter
    private String name;

}
