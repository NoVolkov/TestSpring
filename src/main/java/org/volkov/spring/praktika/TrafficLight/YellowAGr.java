package org.volkov.spring.praktika.TrafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class YellowAGr implements State{
    private static State color;
    static {
        color=new Red();
    }
    public YellowAGr() {

    }

    public YellowAGr(State st){
        color=st;
    }
    @Override
    public String getColor() {
        return "yellow";
    }

    @Override
    public void next(@Qualifier("trl") TrafficLight tf) {
        tf.setState(color);//new Red()
        System.out.println(color.getColor());//"Red"

    }
}
