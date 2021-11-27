package md.springdemo.application.module;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@EnableAutoConfiguration
@Slf4j
public class Two
{
    @Bean
    ApplicationRunner runner()
    {
        return args ->
                log.info("Running {}", Two.class);
    }
}
