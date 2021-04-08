package org.volkov.spring;

import org.springframework.stereotype.Component;

@Component("musicC")
public class ClassicMusic implements Music{
    @Override
    public String getSong() {
        return "Щелкунчик 1892";
    }
}
