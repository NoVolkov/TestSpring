package org.volkov.spring.praktika.TrafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Green implements State{
    @Override
    public String getColor() {
        return null;
    }

    @Override
    public void next(@Qualifier("trl") TrafficLight tf) {
        tf.setState(new YellowAGr());
        System.out.println("Yellow");

    }
}
