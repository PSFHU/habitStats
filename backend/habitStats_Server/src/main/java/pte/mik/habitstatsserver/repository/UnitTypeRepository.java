package pte.mik.habitstatsserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pte.mik.habitstatsserver.entity.UnitType;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Integer> {
}
