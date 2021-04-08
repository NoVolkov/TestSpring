package org.volkov.spring.praktika.TrafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean("trl")
    public TrafficLight getTrL(@Qualifier("gr") State st){
        return new TrafficLight(st);
    }


    @Bean("gr")
    public Green getGr(@Qualifier("ya") State st){//@Qualifeir (цвет) конструктор
        return new Green(st);
    }
    @Bean("ya")
    public YellowAGr getYA(@Qualifier("r") State st){
        return new YellowAGr(st);
    }
    @Bean("r")
    public Red getR(@Qualifier("yb") State st){
        return new Red(st);
    }
    @Bean("yb")
    public YellowBGr getYB(@Qualifier("gr") State st){
        return new YellowBGr(st);
    }

}
