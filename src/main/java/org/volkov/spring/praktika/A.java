package org.volkov.spring.praktika;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class A {
    int x;
    public A(){ }
    public A(int x){
        this.x=x;
    }

    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                '}';
    }
}
