package org.volkov.spring.praktika.TrafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Red implements State{
    @Override
    public String getColor() {
        return "red";
    }

    @Override
    public void next(@Qualifier("trl") TrafficLight tf) {
        tf.setState(new YellowBGr());
        System.out.println("Yellow");

    }
}
