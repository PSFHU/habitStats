package pte.mik.habitstatsserver.repository.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pte.mik.habitstatsserver.entity.stat.Stat;

@Repository
public interface StatRepository extends JpaRepository<Stat, Integer> {

}
