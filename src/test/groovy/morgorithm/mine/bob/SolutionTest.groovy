package morgorithm.mine.bob

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "밥먹는 조 짜기"() {
        given:
        Solution solution = new Solution()

        expect:
        OUT == solution.bob(TOTAL, N)

        where:
        TOTAL | N || OUT
        10    | 2 || [5, 5]
        10    | 1 || [10]
        10    | 3 || [4, 3, 3]
        10    | 4 || [3, 3, 2, 2]
        13    | 2 || [7, 6]
        13    | 3 || [5, 4, 4]
        13    | 4 || [4, 3, 3, 3]
    }
}
