package md.springdemo.application;

import lombok.extern.slf4j.Slf4j;
import md.springdemo.application.module.One;
import md.springdemo.application.module.Three;
import md.springdemo.application.module.Two;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.springframework.boot.WebApplicationType.NONE;

@SpringBootConfiguration
@EnableAutoConfiguration
@Slf4j
class SpringDemoApplication
{
    public static void main(String[] args)
    {
        log.info("Main app");
        new SpringApplicationBuilder().
                parent(One.class).web(NONE).
                child(Two.class).web(NONE).
                sibling(Three.class).web(NONE).
                run(args);
    }
}
