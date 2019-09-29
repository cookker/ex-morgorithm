package morgorithm.leet.easy.mergetwolist

import spock.lang.Specification
import spock.lang.Unroll

class SolutionTest extends Specification {

    @Unroll
    def "merge two sort list"(){
        given:
        Solution solution = new Solution()
        a1 = new ListNode(1)
        a2 = new ListNode(2)
        a4 = new ListNode(4)

        b1 = new ListNode(1)
        b3 = new ListNode(3)
        b4 = new ListNode(4)

        c1 =

        a1.next = a2
        a2.next = a4

        b1.next = b3
        b3.next = b4

        expect:
        OUT == solution.mergeTwoLists(IN1, IN2)

        where:
        IN1 | IN2 || OUT
//        a1 | b1 ||
    }
}
