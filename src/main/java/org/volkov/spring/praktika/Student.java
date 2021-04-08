package org.volkov.spring.praktika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.List;

public class Student {
    String name;
    int avrg;
    public Student(String name, int avrg) {
        this.name = name;
        this.avrg = avrg;
    }
    @Autowired
    private void addToList(@Qualifier("lst") List<Student> st){
        st.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAvrg() {
        return avrg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvrg(int avrg) {
        this.avrg = avrg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", avrg=" + avrg +
                '}';
    }
    @PostConstruct
    public void test(){
        System.out.println("Test");
    }
}
