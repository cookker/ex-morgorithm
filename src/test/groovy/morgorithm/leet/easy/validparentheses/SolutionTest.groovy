package morgorithm.leet.easy.validparentheses

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "valid parentheses #IN || #OUT"() {
        given:
        Solution solution = new Solution()

        expect:
        OUT == solution.isValid2(IN)

        where:
        IN       || OUT
        "()"     || true
        "()[]{}" || true
        "(]"     || false
        "([)]"   || false
        "{[]}"   || true
        "]"      || false
        "){"     || false
        ""       || true
        "(])"    || false
    }
}
