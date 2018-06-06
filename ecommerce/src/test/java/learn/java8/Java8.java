package learn.java8;

import java.util.ArrayList;
import java.util.List;

public class Java8 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("bb");
        list.add("ccc");
        list.add("dddd");

        List<String> stream=list.stream().filter(action->{
            if(action.length()>2){
                return true;
            }else{
                return false;
            }
        }).collect(Collectors.toList());

        System.out.println(stream);

        // Convert elements to strings and concatenate them, separated by commas
        String joined = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(joined);

    }
}
