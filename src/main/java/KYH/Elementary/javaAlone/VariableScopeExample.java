package KYH.Elementary.javaAlone;

public class VariableScopeExample {
    public static void main(String[] args) {
        int v1 = 15;
        if (v1 > 10) {
            int v2;
            v2 = v1 - 10;
        }
//        int v3 = v1 + v2 + 5; -> 이렇게 쓰면 v2에서 compile error가 남(if문 안쪽에만 있는데 바깥쪽에서 소환을 했으니)
    }
}
