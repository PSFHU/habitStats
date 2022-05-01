package pte.mik.habitstatsserver.entity.stat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Table(name = Progress.TBL_NAME)
public class Progress extends AbstractEntity<Long>{

    public static final String TBL_NAME ="progress";
    public static final String FLD_STAT_ID="stat_id";
    public static final String FLD_PROG_VALUE="progress_value";
    public static final String FLD_PROG_TIMESTAMP="progress_timestamp";

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = FLD_STAT_ID)
    private Stat stat;

    @Column(name = FLD_PROG_VALUE)
    private Float value;

    @Column(name = FLD_PROG_TIMESTAMP)
    private Instant timestamp;
}
