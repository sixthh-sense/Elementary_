package KYH.Elementary.Algorithm.programmers;

import java.util.HashMap;

public class Spy { // 참고 사이트: https://hey-stranger.tistory.com/54
    public static void main(String[] args){
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Spy spy = new Spy();
        System.out.println(spy.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] one : clothes) {
            String type = one[1];
            hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
            System.out.println("hashMap: " + hashMap);
        }

        for (String key : hashMap.keySet()) {
            answer *= (hashMap.get(key) + 1);
        }
        return answer - 1;
    }
}
