package md.springdemo.application;

import lombok.extern.slf4j.Slf4j;
import md.springdemo.library.Checker;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(Checker.class)
@Slf4j
public class SpringDemoApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(Checker checker)
    {
        return args ->
                log.info("Checks ? {}", checker.check());
    }
}
