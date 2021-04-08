package org.volkov.spring.praktika.TrafficLight;

public interface State {
    String getColor();
    void next(TrafficLight tf);
}
