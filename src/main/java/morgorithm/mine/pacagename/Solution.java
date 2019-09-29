package morgorithm.mine.pacagename;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 패키지 이름을 로그로 출력하고 싶다.
 * 패키지 이름이름 출력시 고정된 길이로 출력한다.
 * 패키지 이름은 문자열로 입력받고, 패키지 길이는 자연수로 입력받는다.
 * 패키지 이름은 소문자영문자[a-z]와 마침표[.]로만 이루어져 있다.
 * 패키지 이름의 마침표는 소문자영문자로 이루어진 문자열 사이에만 올 수 있다.
 * 입력받은 패키지 문자열을 string, 그 문자열의 길이를 x, 고정된 패키지 길이를 n이라 했을 때,
 * x == n이면 string 그대로 출력한다.
 * x < n이면 string 뒤에 언더스코어(_)문자를 추가하여 x == n이 되도록 한다.
 * x > n이면 string을 규칙에 맞게 줄여 x==n이 되도록하여 출력한다.
 *
 * string을 줄이는 규칙
 * 1. 마침표로 나뉜 영단어의 각 첫글자만 취한다. 영어단어의 첫글자만 취할 때는 앞 단어부터 시작한다.
 * 2. 패키지명의 모든 단어에서 한글자씩만 취한경우에도 n보다 크다면, 문자열의 뒤에서부터 n글자만큼만 취한다.
 *
 * 입력: "abc.def", 8
 * 출력: "abc.def_"
 *
 * 입력: "abc.def", 3
 * 출력: "a.d"
 *
 * 입력: "a.b.c", 6
 * 출력: "a.b.c_"
 *
 * 입력: "abc.def.ghi", 1
 * 출력: "g"
 * */
public class Solution {

    public String packagename(String string, int n) {

        final var length = string.split("\\.").length;

        if (length == 1) {
            return string.substring(0, n);
        }


        if (string.length() <= n) {
            return string + new String(new char[n - string.length()]).replace("\0", "_");
        }

        final var split = string.split("\\.");

        boolean allShorten = true;

        for (int i = 0; i < split.length; i++) {
            if (split[i].length() != 1) {
                final var c = split[i].charAt(0);
                split[i] = String.valueOf(c);
                allShorten = false;
                break;
            }
        }

        if (allShorten && length + 2 > n) {
            return string.substring(string.length() - n);
        }

        return packagename(String.join(".", split), n);
    }

}
