package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day4ote {
  /*
  1.Stream Api
    java.util.stream package
        intermediate operation  return a stream
            filter, map, distinct, limit, flatmap
        terminal operation  return a normal datatype not a stream
            collect, forEach, reduce,min, max...
        all variable create by stream is immutable dataype, so it is thread safe
   */

    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>(Arrays.asList(1,2,3,5,8,4,6,7));
        List<Integer> res = list.stream().map(e -> e+ 1).filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(res);

        Character[] array = new Character[] {'a', 'c', 'd','z','r', 'c'};
        Map<Character, Integer> map =  Arrays.stream(array).collect(Collectors.toMap(c -> c, c->1,(a, b) -> a + b));
        System.out.println(map);
    }
}
