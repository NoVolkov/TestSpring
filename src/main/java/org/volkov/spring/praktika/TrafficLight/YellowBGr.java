package org.volkov.spring.praktika.TrafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class YellowBGr implements State{
    private static State color;
    static {
        color=new Green();
    }
    public YellowBGr() {

    }

    public YellowBGr(State st){
        color=st;
    }
    @Override
    public String getColor() {
        return "yellow";
    }

    @Override
    public void next(@Qualifier("trl") TrafficLight tf) {
        tf.setState(color);//new Green()
        System.out.println(color.getColor());//"Green"
    }
}
