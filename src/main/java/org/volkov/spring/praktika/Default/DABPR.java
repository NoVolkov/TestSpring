package org.volkov.spring.praktika.Default;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
@Component
public class DABPR implements BeanPostProcessor {
    //взять из ApplicationContext
    //завести map(тип, значение)
    //использовать postProccessBefore (заранее, если не прописаны поля)
    private static HashMap<Class,String> m=new HashMap<>();

    static {
        //System.out.println("Here");
        m.put(String.class,"Hello there");
        m.put(Integer.class,"1234");
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("EnterBef");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields=bean.getClass().getDeclaredFields();
        Arrays.stream(fields)
                .filter(q->q.isAnnotationPresent(DefaultName.class))
                .forEach(x->{
                        Class cl=x.getType();
                        m.entrySet().stream()
                                .filter(y->y.getKey().equals(cl))
                                .forEach(z-> {
                                    try {
                                        Number n;
                                        if (x.getType().equals(Integer.class)){
                                            n=Integer.parseInt(z.getValue());
                                            x.set(bean,n);
                                        }else{
                                            x.set(bean,z.getValue());
                                        }
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    }
                                });
                });
        return bean;
    }
}
