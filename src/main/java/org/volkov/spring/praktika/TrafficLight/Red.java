package org.volkov.spring.praktika.TrafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Red implements State{
    private State color;

    public Red() {
    }

    public Red(State st){
        color=st;
    }
    @Override
    public String getColor() {
        return "red";
    }

    @Override
    public void next(@Qualifier("trl") TrafficLight tf) {
        tf.setState(color);//new YellowBGr()
        System.out.println(color.getColor());//"Yellow"

    }
}
