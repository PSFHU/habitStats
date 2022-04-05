package pte.mik.habitstatsserver.entity.stat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "progress")
public class Progress {
    @Id
    @Getter
    @Setter
    private Integer id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stat_id")
    @Getter
    @Setter
    private Stat stat;
    @Column(name = "progress_value")
    @Getter
    @Setter
    private Float value;
    @Column(name = "progress_timestamp")
    @Getter
    @Setter
    private Timestamp timestamp;
}
