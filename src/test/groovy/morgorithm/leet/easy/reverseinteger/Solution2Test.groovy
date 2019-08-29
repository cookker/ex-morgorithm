package morgorithm.leet.easy.reverseinteger

import spock.lang.Specification
import spock.lang.Unroll

class Solution2Test extends Specification {

    @Unroll
    def "reverse integer #IN <-> #OUT"() {

        given:
        Solution2 solution2 = new Solution2()

        when:
        def result = solution2.reverse(IN)

        then:
        OUT == result

        where:
        IN          || OUT
        123         || 321
        321         || 123
        -123        || -321
        120         || 21
        1534236469  || 0
        -2147483412 || -2143847412
    }
}
