package org.volkov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private MusicPlayer mpl;
    @Autowired
    public Computer(MusicPlayer mpl) {
        this.id=1;
        this.mpl=mpl;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", mpl=\n" + mpl.playMusic() +
                '}';
    }
}
