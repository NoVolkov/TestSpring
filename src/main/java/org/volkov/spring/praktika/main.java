package org.volkov.spring.praktika;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.volkov.spring.praktika.TrafficLight.Config;
import org.volkov.spring.praktika.TrafficLight.TrafficLight;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        TrafficLight tf=context.getBean(TrafficLight.class);
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();

        /*ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        System.out.println(context.getBean("getTop",Student.class));
        context.getBean("getStV",Student.class).setAvrg(8);
        System.out.println(context.getBean("getTop",Student.class));
        context.getBean("lst", ArrayList.class).add(new Student("Petr",10));
        System.out.println(context.getBean("getTop",Student.class));
        //System.out.println(context.getBean("lst",List.class).get(0));
*/
    }
}
