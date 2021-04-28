package org.volkov.spring.praktika;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.volkov.spring.praktika.Default.DABPR;
import org.volkov.spring.praktika.Default.Student;
import org.volkov.spring.praktika.TrafficLight.TrafficLight;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class main {
    public static void change(String em, String dep, Statement st) throws Exception {
        ResultSet rsd=st.executeQuery("SELECT * FROM Departament");
        int depID=-1;
        while(rsd.next()){
            if(rsd.getString("name").equals(dep)){
                depID=Integer.parseInt(rsd.getString("id"));
                break;
            }
        }

        if (depID==-1){
            System.out.println(depID);
            throw new Exception("Not found department "+dep);
        }
        ResultSet rs=st.executeQuery("SELECT * FROM Employee");

        while (rs.next()){
            if(rs.getString("name").equals(em)){
               rs.updateInt("depID",depID);//Результирующий набор недоступен для обновления.
                System.out.println("working");
            }
        }
    }
    public static List<Employee> select(String dep, Statement ps) throws Exception {
        ResultSet rsd=ps.executeQuery("SELECT * FROM Departament");
        int depID=-1;
        while(rsd.next()){
            if(rsd.getString("name").equals(dep)){
                depID=Integer.parseInt(rsd.getString("id"));
                break;
            }
        }

        if (depID==-1){
            System.out.println(depID);
            throw new Exception("Not found department "+dep);
        }
        ResultSet rs=ps.executeQuery("SELECT * FROM Employee");
        List<Employee> res=new ArrayList<>();
        while(rs.next()){
            if(Integer.parseInt(rs.getString("depID"))==depID){
                Employee e=new Employee(Integer.parseInt(rs.getString("id")),rs.getString("name"),depID);
                res.add(e);
            }
        }
        return res;
    }
    public static void main(String[] args) throws Exception {

        //ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);


        String stringCon="jdbc:sqlserver://DESKTOP-CRJ5AJN:1433;" +
                "database=Test;" +
                "user=USER;" +
                "password=123456;" +
                //"encrypt=true;" +
                "trustServerCertificate=false;" +
                "loginTimeout=30;";
        Connection con= DriverManager.getConnection(stringCon);
        Statement st= con.createStatement();

       /* ResultSet rs=st.executeQuery("SELECT TOP 100 * FROM Employee");
        while(rs.next())System.out.println(rs.getString("id")+"//"+rs.getString("name")+"//"+rs.getString("depID"));*/


        //st.executeUpdate("INSERT INTO users ([id],[name]) VALUES (12,'Hello')");

        /*ResultSet rs=st.executeQuery("SELECT TOP 100 * FROM users");
        while(rs.next())System.out.println(rs.getString("id")+"//"+rs.getString("name"));*/

        /*st.executeUpdate(   "CREATE TABLE users " +
                                "(id INTEGER not NULL, " +
                                " name VARCHAR(50), " +
                                " PRIMARY KEY (id))");*/



        //System.out.println(String.class.getName().endsWith("String"));



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
