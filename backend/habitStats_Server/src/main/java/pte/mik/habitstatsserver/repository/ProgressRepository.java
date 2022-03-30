package pte.mik.habitstatsserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pte.mik.habitstatsserver.entity.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Integer>{

}
