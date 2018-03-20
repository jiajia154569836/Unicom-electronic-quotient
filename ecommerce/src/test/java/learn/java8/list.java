package learn.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class list {
    public static void main(String[] args) {
     List<User> list = new ArrayList<User>();
     for(int i=0;i<=5;i++)
     {
         User user = new User();
         user.setId(i);
         user.setUsername(i+"");
         user.setPassword(i+"");
         list.add(user);
         User user1 = new User();
         user1.setId(i);
         user1.setUsername(i+"");
         user1.setPassword(i+"");
         list.add(user1);
     }

        System.out.println(list.toString());

     // 查找集合中的第一个对象。（符合条件的）
        Optional<User> firstA= list.stream() .filter(a -> "4".equals(a.getUsername())).findFirst();
        System.out.println(firstA.get().getUsername());

      //  查找集合中所有对象。（符合条件的）
        List<User> listA= list.stream() .filter(a -> "4".equals(a.getUsername())) .collect(Collectors.toList());
        System.out.println(listA.toString());
        list.get(0).getUsername();

     //  将集合中的所有对象的ID抽取出来。（符合条件的）
        List<Integer> listid = list.stream().map(User::getId).collect(Collectors.toList());
        List<String> listu = list.stream().map(User::getUsername).collect(Collectors.toList());
        System.out.println(listid.toString());
        System.out.println(listu.toString());
    }

}
