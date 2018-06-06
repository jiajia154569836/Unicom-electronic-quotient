package learn.java8;

import com.beust.jcommander.internal.Maps;
import com.jiajia.main.model.User;
import net.sf.cglib.beans.BeanMap;

import java.util.Map;



public class BeanToMap {

    public static void main(String[] args) {

        User user = new User();
        user.setId(1);
        user.setUsername("1");
        user.setPassword("1");


            Map<String, Object> map = Maps.newHashMap();
            if (user != null) {
                BeanMap beanMap = BeanMap.create(user);
                for (Object key : beanMap.keySet()) {
                    map.put(key+"", beanMap.get(key));
                }
            }
            System.out.println(user.toString());
            System.out.println(map.toString());



    }

    }
