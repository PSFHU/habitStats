package pte.mik.habitstatsserver.repository.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pte.mik.habitstatsserver.entity.stat.StatCategory;

@Repository
public interface StatCategoryRepository extends JpaRepository<StatCategory, Integer> {
}
