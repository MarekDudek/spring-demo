package md.springdemo.library;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Checker
{
    public boolean check()
    {
        return new Random().nextBoolean();
    }
}
