package md.springdemo.library;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "checker")
@Data
public class CheckerProperties
{
    public int chance;
}
