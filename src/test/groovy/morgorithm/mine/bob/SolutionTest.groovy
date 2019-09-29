package morgorithm.mine.bob

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "밥먹는 조 짜기"() {
        given:
        Solution solution = new Solution()

        expect:
        OUT == solution.bob(N)

        where:
        N  || OUT
        10 || [4, 3, 3]
    }
}
