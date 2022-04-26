package pte.mik.habitstatsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"pte.mik.habitatsserver.entity"})
@EnableJpaRepositories(value = {"pte.mik.habitatsserver.repository"})
@SpringBootApplication
public class HabitStatsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitStatsServerApplication.class, args);
    }

}
