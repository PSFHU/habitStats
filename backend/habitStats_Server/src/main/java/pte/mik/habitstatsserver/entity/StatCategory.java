package pte.mik.habitstatsserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAT_CATEGORY")
public class StatCategory {
    @Id
    private Integer id;
    private String name;
}
