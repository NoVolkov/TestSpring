package org.volkov.spring.praktika;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.volkov.spring.praktika.Default.DABPR;
import org.volkov.spring.praktika.Default.Student;
import org.volkov.spring.praktika.TrafficLight.TrafficLight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class main {
    private static HashMap<String,String> m=new HashMap<>();

    static {
        m.put("String","Hello there");
        m.put("Integer","1234");
    }
    public static void main(String[] args) {

        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        System.out.println(
                context.getBean(Student.class)
        );
        //System.out.println(String.class.getName().endsWith("String"));
        String str="HI";
        //System.out.println(m.get("String"));
        /*m.entrySet().stream()
                //.filter(x->x.getKey().compareTo(name.endsWith()))
                .filter(x->str.getClass().getName().endsWith(x.getKey()))
                .forEach(x->{System.out.println(x.getValue());});*/

        /*TrafficLight tf=context.getBean(TrafficLight.class);
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();
        tf.next();*/

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
