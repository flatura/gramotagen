package code.flatura.gramotagen;

import code.flatura.gramotagen.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "code.flatura.gramotagen.repository")
public class GramotagenApplication {
    public static void main(String[] args) {
        SpringApplication.run(GramotagenApplication.class, args);
    }
}
