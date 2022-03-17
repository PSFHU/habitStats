package pte.mik.habitstatsserver.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "PROGRESS")
public class Progress {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "STAT_ID",nullable = false)
    private Stat stat;
    @Column(name = "PROGRESS_VALUE")
    private Float value;
    @Column(name = "PROGRESS_TIMESTAMP")
    private Timestamp timestamp;
}
