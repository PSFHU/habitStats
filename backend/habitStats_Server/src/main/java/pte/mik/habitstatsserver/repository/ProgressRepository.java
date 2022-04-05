package pte.mik.habitstatsserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pte.mik.habitstatsserver.entity.Progress;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Integer>{
    @Query("select p FROM Progress p WHERE p.stat.id = ?1")
    public List<Progress> getByStatId(Integer statId);
}