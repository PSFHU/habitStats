package pte.mik.habitstatsserver.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UNIT_TYPE")
public class UnitType {
    @Id
    private Integer id;
    private String name;
}
