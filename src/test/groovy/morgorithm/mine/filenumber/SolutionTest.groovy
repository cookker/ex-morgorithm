package morgorithm.mine.filenumber

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "파일명에 숫자붙히기"() {
        given:
        Solution solution = new Solution()

        expect:
        OUT == solution.suffixNumber(STR as String[])

        where:
        STR                                              || OUT
        ["filename.txt"]                                 || ["filename.txt"] //제외시키자1.
        ["filename.txt", "filename.txt"]                 || ["filename(1).txt"]
        ["filename.txt", "filename.txt", "filename.txt"] || ["filename(2).txt"] //제외시키자2.
        ["filename(1).txt", "filename.txt"]              || ["filename(1).txt", "filename.txt"]
        ["filename(1).txt", "filename(1).txt"]           || ["filename(2).txt"]
        ["filename(100).txt", "filename(100).txt"]       || ["filename(101).txt"]
        ["filename(a).txt", "filename(a).txt"]           || ["filename(a)(1).txt"]
        ["filename(a).txt", "filename(b).txt"]           || ["filename(a).txt", "filename(b).txt"]
        ["filename", "filename"]                         || ["filename(1)"]
//        ["filename(0).txt", "filename(0).txt"] || ["filename(0)(1).txt"]
    }
}
