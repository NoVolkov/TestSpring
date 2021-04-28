package org.volkov.spring.praktika;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.volkov.spring.praktika.Default.DABPR;

import java.util.*;

@Configuration
public class Config {
    /*@Bean
    public A getASingl(){
        return new A();
    }
    @Bean
    @Scope("prototype")
    public A getAPrototype(){
        return new A(new Random().nextInt());
    }*/
    @Bean
    @Scope("prototype")
    public org.volkov.spring.praktika.Default.Student getStDef(){
        return new org.volkov.spring.praktika.Default.Student();
    }
    @Bean
    public DABPR getDABPR(){return new DABPR();}
    @Bean
    public Student getStV(){
        return new Student("Вася",3);
    }
    @Bean
    public Student getStP(){
        return new Student("Петя",3);
    }
    @Bean
    public Student getStA(){
        return new Student("Аня",5);
    }
    @Bean("lst")
    public List<Student> getStudents(){
        return new ArrayList<>();
    }
    @Bean
    @Scope("prototype")
    public Student getTop(@Qualifier("lst") List<Student> st){
        return st.stream()
                .max(Comparator.comparingInt(Student::getAvrg))
                .orElseThrow(() -> new NoSuchBeanDefinitionException("top"));
        /*int s=0;
        for(int i=0;i<st.size()-1;i++){
            if(st.get(i).avrg>st.get(i+1).avrg){
                s=i;
            }else{
                if(st.get(i+1).avrg>st.get(s).avrg){
                    s=i+1;
                }
            }
        }
        return st.get(s);*/
    }
}
