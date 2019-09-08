package morgorithm.leet.easy.longestcommonprefix

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {


    @Unroll
    def "longest common prefix #IN --> #OUT"() {

        given:
        Solution solution = new Solution()

        expect:
        OUT == solution.longestCommonPrefix(IN as String[])

        where:
        IN                           || OUT
        ["flower", "flow", "flight"] || "fl"
        ["aaa", "aaa", "aaa"]        || "aaa"
        ["dog", "racecar", "car"]    || ""
        ["a", "a"]                   || "a"
        ["a", "b"]                   || ""
        ["z", "z", "z"]              || "z"
    }

}
