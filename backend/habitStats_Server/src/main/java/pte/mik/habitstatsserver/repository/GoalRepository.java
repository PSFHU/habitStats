package pte.mik.habitstatsserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pte.mik.habitstatsserver.entity.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Integer> {
}
