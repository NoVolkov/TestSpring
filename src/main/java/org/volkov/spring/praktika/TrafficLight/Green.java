package org.volkov.spring.praktika.TrafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Green implements State{
    private static State color;
    static {
        color=new YellowAGr();
    }
    public Green() {

    }

    public Green(State st){
        color=st;
    }
    @Override
    public String getColor() {
        return "green";
    }

    @Override
    public void next(@Qualifier("trl") TrafficLight tf) {
        tf.setState(color);//new YellowAGr()
        System.out.println(color.getColor());//"Yellow"

    }
}
