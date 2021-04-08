package org.volkov.spring;

import org.springframework.stereotype.Component;

@Component("musicR")
public class RockMusic implements Music{
    private RockMusic() {}
    public static RockMusic getRockMusic(){
        return new RockMusic();
    }

    @Override
    public String getSong() {
        return "Smoke on the water And fire in the sky.";
    }
    public void doMyInit(){
        System.out.println("Doing my initialization.");
    }
    public void doMyDestroy(){
        System.out.println("Doing my destroying.");
    }
}
