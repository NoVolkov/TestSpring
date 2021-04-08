package org.volkov.spring.praktika.TrafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class TrafficLight {

    private State state;//=new Red();
    public TrafficLight(State st){
        this.state=st;
    }
    public void next(){
        state.next(this);
    }

    public void setState(State st){
        this.state=st;
    }

}
