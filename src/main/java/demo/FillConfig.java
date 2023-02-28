package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class FillConfig {

    @Bean
    CommandLineRunner commandLineRunnerFill(
            UserService userService) {
        return args -> {
            User elke = new User("Elke", 44, "elke@ucll.be", "elke");
            User miyo = new User("Miyo", 15, "miyo@ucll.be", "miyo");
            User eric = new User("Eric", 65, "eric@kuleuven.be", "eric");
            User yuki = new User("Yuki", 13, "yuki@ucll.be", "yuki");

            userService.addUser(elke);
            userService.addUser(miyo);
            userService.addUser(eric);
            userService.addUser(yuki);

            System.out.println("users added");
        };
    }

}