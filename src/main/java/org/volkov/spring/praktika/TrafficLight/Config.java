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
    public Green getGr(){//@Qualifeir (цвет) конструктор
        return new Green();
    }
    @Bean("ya")
    public YellowAGr getYA(){
        return new YellowAGr();
    }
    @Bean("yb")
    public YellowBGr getYB(){
        return new YellowBGr();
    }
    @Bean("r")
    public Red getR(){
        return new Red();
    }
}
