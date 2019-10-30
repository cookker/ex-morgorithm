package morgorithm.mine.mincostclimbingstairs

import spock.lang.Specification
import spock.lang.Unroll

class MinCostClimbingStairsTest extends Specification {

    @Unroll
    def "최소비용으로 계단 오르기"() {
        given:
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs()

        expect:
        RESULT == minCostClimbingStairs.solution(COSTS as int[])

        where:
        COSTS                                || RESULT
        [10, 15, 20]                         || 15
        [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] || 6
    }
}
