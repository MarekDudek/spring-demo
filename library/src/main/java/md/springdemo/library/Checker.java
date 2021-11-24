package md.springdemo.library;

import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Value
public class Checker
{
    private static final Random GENERATOR = new Random();

    CheckerProperties properties;

    public boolean check()
    {
        return GENERATOR.nextInt(properties.chance) == 0;
    }
}
