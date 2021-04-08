package org.volkov.spring;

import org.springframework.stereotype.Component;

@Component("musicE")
public class ElectroMusic implements Music{
    @Override
    public String getSong() {
        return "Harder Better Faster Stronger";
    }
}
