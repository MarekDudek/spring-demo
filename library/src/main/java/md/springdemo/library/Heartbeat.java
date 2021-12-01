package md.springdemo.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import static java.time.Duration.ofSeconds;

@Configuration
public class Heartbeat
{
    @Bean
    public Flux<Long> heartbeats()
    {
        return Flux.
                interval(ofSeconds(1)).
                metrics().
                log();
    }
}
