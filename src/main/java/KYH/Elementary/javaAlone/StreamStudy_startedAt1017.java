package KYH.Elementary.javaAlone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 출처: https://stackoverflow.com/questions/61070979/java-8-listmap-into-single-map
public class StreamStudy_startedAt1017 {
    public static void main(String[] args) {
        /* List<Map<Integer, String>> mapList = new ArrayList<>();

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "One");
        map1.put(2, "Two");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, "Three");
        map2.put(4, "Four");

        mapList.add(map1);
        mapList.add(map2);

        Map<Integer, Integer> finalMap = new HashMap<>();
        finalMap = mapList.stream().flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getKey)); */
        Map<String, Map<Integer, String>> map1 = new HashMap<>();
        List<Map<String, Object>> render = new ArrayList<>();
        Map<String, Object> first = new HashMap<>();
        first.put("id", 1);
        first.put("username", "banana");
        first.put("nickname", "yellow");

        Map<String, Object> second = new HashMap<>();
        second.put("id", 2);
        second.put("username", "coconut");
        second.put("nickname", "brownie");
        render.add(first);
        render.add(second);

        Map<Integer, String> sortingList = render.stream() // .flatMap(m -> m.values().stream())
                .collect(Collectors.toMap(e1 -> (int) e1.get("id"), e2 -> (String) e2.get("username")));
        System.out.println(sortingList);
    }
}
