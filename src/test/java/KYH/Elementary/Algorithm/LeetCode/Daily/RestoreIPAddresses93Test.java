package KYH.Elementary.Algorithm.LeetCode.Daily;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RestoreIPAddresses93Test {

    RestoreIPAddresses_93 restoreIP = new RestoreIPAddresses_93();

    @Test
    void case1() {
        String s = "25525511135";
        List<String> actual = restoreIP.restoreIpAddresses(s);
        List<String> expected = new ArrayList<>(Arrays.asList("255.255.11.135", "255.255.111.35"));
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void case2() {
        String s = "0000";
        List<String> actual = restoreIP.restoreIpAddresses(s);
        List<String> expected = new ArrayList<>(List.of("0.0.0.0"));
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void case3() {
        String s = "101023";
        List<String> actual = restoreIP.restoreIpAddresses(s);
        List<String> expected = new ArrayList<>(Arrays.asList("1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"));
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}