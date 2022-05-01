package pte.mik.habitstatsserver.entity.stat;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Table(name = StatCategory.TBL_NAME)
public class StatCategory extends AbstractEntity<Long>{

    public static final String TBL_NAME="stat_category";
    public static final String FLD_CATEGORY_NAME="stat_category_name";

    @Column(name = FLD_CATEGORY_NAME)
    private String name;

}
