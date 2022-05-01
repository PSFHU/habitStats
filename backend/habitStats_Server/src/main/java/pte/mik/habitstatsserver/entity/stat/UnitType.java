package pte.mik.habitstatsserver.entity.stat;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Table(name = UnitType.TBL_NAME)
public class UnitType extends AbstractEntity<Long>{

    public static final String TBL_NAME="unit_type";
    public static final String FLD_UNIT_NAME="unit_type_name";

    @Column(name = FLD_UNIT_NAME)
    private String name;
}
