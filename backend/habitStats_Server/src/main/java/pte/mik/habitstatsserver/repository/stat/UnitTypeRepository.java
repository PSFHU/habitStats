package pte.mik.habitstatsserver.repository.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pte.mik.habitstatsserver.entity.stat.UnitType;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long> {
}
