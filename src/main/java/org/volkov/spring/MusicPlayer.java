package org.volkov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MusicPlayer {
    //Зависимость через поле
    //@Autowired
    private List<Music> musics = new ArrayList<>();

    private String name;
    private int volume;

    //IoC
    public MusicPlayer() {
    }
    //Зависимость через конструктор
    //@Autowired
    public MusicPlayer(Music...music) {
        setMusics(music);
    }
    //Зависимость через сеттер
    @Autowired
    public void setMusics(@Qualifier("musicE") Music[] music) {
        for (Music m : music) musics.add(m);
    }

    public String playMusic() {
        return "playing:\n" +
                musics.stream()
                        .map((x) -> x.getSong())
                        .reduce((x, y) -> x.concat("\n" + y))
                        .orElse("")
        ;
    }

    /*public void setMusic(Music music) {
        this.music = music;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
