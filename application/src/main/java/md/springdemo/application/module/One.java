package md.springdemo.application.module;

import lombok.extern.slf4j.Slf4j;
import md.springdemo.library.Checker;
import md.springdemo.library.CheckerProperties;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({
        Checker.class,
        CheckerProperties.class,
})
@Slf4j
public class One
{
    @Bean
    ApplicationRunner runner(Checker checker)
    {
        return args ->
                log.info("Running {}", One.class);
    }
}
