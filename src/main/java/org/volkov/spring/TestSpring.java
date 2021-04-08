package org.volkov.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.volkov.spring.praktika.Config;

public class TestSpring {
    public static void main(String[] args) {

        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        Computer comp=context.getBean("computer",Computer.class);
        System.out.println(comp.toString());

        context.close();*/

        /*RockMusic r=context.getBean("musicR",RockMusic.class);
        Music c=context.getBean("musicC",ClassicMusic.class);
        MusicPlayer mp=new MusicPlayer();
        mp.setMusics(r,c);
        mp.playMusic();*/

        /*RockMusic r2=context.getBean("musicRBean",RockMusic.class);
        RockMusic r3=context.getBean("musicRBean",RockMusic.class);
        System.out.println(Stream.of(r,r2,r3).map(x->x.getSong()).reduce((x,y)->x.concat("\n"+y)).orElse(""));*/
        /*MusicPlayer musicBean = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicBean1 = context.getBean("musicPlayer", MusicPlayer.class);
        //musicBean.playMusic();
        System.out.println(musicBean.getName());
        musicBean.setVolume(10);
        System.out.println(musicBean.getVolume());
        System.out.println(musicBean1.getVolume());*/
        /*MusicPlayer pl=context.getBean("musicPlayer",MusicPlayer.class);
        pl.playMusic();*/

    }
}
