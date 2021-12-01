package md.springdemo.library;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import static java.time.Duration.ofSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@SpringBootTest(classes = {Heartbeat.class})
@Slf4j
public class HeartbeatTest
{
    @Autowired
    Flux<Long> heartbeats;

    @Test
    void test()
    {
        assertThat(
                catchThrowable(() ->
                        heartbeats.blockLast(ofSeconds(3))
                )).
                isInstanceOf(IllegalStateException.class).
                hasMessageContaining("Timeout on blocking read");
    }
}
