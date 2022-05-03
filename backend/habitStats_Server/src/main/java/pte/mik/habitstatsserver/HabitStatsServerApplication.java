package pte.mik.habitstatsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"pte.mik.habitstatsserver.entity"})
@EnableJpaRepositories(value = {"pte.mik.habitstatsserver.repository"})
@SpringBootApplication
public class HabitStatsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HabitStatsServerApplication.class, args);
    }

}
