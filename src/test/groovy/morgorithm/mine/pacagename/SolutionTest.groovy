package morgorithm.mine.pacagename

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "패키지이름 포맷팅 #STR, #N, #OUT"() {
        given:
        Solution solution = new Solution()

        expect:
        OUT == solution.packagename(STR, N)

        where:
        STR           | N || OUT
        "abc.def"     | 7 || "abc.def"
        "abc.def"     | 8 || "abc.def_"
        "a.def"       | 6 || "a.def_"
        "abc.def"     | 3 || "a.d"
        "a.b.c"       | 5 || "a.b.c"
        "a.b.c"       | 6 || "a.b.c_"
        "a.b.c"       | 4 || ".b.c"
        "abc.def.ghi" | 4 || ".d.g"
        "abc.def.ghi" | 1 || "g"
        "abcde"       | 1 || "a"
    }
}
