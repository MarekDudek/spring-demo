package md.springdemo.application.module;

import lombok.extern.slf4j.Slf4j;
import md.springdemo.library.Heartbeat;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.task.TaskExecutor;
import reactor.core.publisher.Flux;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(Heartbeat.class)
@Slf4j
public class Two
{
    @Bean
    ApplicationRunner runner
            (
                    Flux<Long> heartbeats,
                    TaskExecutor executor
            )
    {
        return args -> {
            log.info("Running {}", Two.class);
            executor.execute(
                    heartbeats::subscribe
            );
        };
    }
}
