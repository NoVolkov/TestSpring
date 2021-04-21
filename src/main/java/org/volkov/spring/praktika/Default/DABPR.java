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
    private static HashMap<String,String> m=new HashMap<>();

    static {
        //System.out.println("Here");
        m.put("String","Hello there");
        m.put("Integer","1234");
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("EnterBef");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //System.out.println("EnterPost");
        Field[] fields=bean.getClass().getDeclaredFields();

        Arrays.stream(fields)
                .filter(q->q.isAnnotationPresent(DefaultName.class))
                .findFirst()
                .ifPresent(y->{
                    try {
                        System.out.println("EnterInAnnotation");
                        //ReflectionUtils.setField(y,bean,"HELLO");
                        //System.out.println(y.getName().getClass().getSimpleName());
                        String name=y.getName().getClass().getSimpleName();
                        m.entrySet().stream()
                                //.filter(x->x.getKey().compareTo(name.endsWith()))
                                .filter(x->name.compareTo(x.getKey())==0)
                                .forEach(z->{
                                    System.out.println(z.getKey());
                                    if(z.getClass().getTypeName().compareTo("Integer")==0){
                                        System.out.println(z);
                                    }
                                    ReflectionUtils.setField(y,bean,z.getValue());
                                });

                    }
                    catch (Exception e){
                        throw new RuntimeException(e);
                    }
                });




        return bean;
    }
}
