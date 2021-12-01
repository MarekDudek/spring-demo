package md.springdemo.library;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static java.time.Duration.ofSeconds;
import static reactor.core.scheduler.Schedulers.boundedElastic;
import static reactor.core.scheduler.Schedulers.newParallel;

public class ReactorDemoTest
{
    @Test
    void empty_mono()
    {
        Mono<Object> mono = Mono.empty();
        StepVerifier.create(mono).
                expectSubscription().
                verifyComplete();
    }

    @Test
    void interval()
    {
        Flux<Long> interval =
                Flux.
                        interval(ofSeconds(1)).
                        take(3).
                        log();
        StepVerifier.create(interval).
                expectSubscription().
                expectNext(0L).
                expectNext(1L).
                expectNext(2L).
                verifyComplete();
    }

    @Test
    void ordinary()
    {
        Flux.range(1, 10).
                subscribeOn(boundedElastic()).
                publishOn(newParallel("numbers")).
                log().
                map(i -> Integer.toString(i)).
                publishOn(newParallel("strings")).
                log().
                blockLast();
    }
}
