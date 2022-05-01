package pte.mik.habitstatsserver.repository.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pte.mik.habitstatsserver.entity.stat.Progress;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long>{
    @Query("select p FROM Progress p WHERE p.stat.id = ?1")
    public List<Progress> getByStatId(Long statId);
}