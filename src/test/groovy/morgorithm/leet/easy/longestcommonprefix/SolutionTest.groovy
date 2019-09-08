package morgorithm.leet.easy.longestcommonprefix

import spock.lang.Specification

class SolutionTest extends Specification {


    def "longest common prefix"() {

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
