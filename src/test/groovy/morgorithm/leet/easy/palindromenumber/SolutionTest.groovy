package morgorithm.leet.easy.palindromenumber


import spock.lang.Specification

class SolutionTest extends Specification {


    def "Palindrome number test"() {

        given:
        Solution solution = new Solution()

        when:
        def result = solution.isPalindrome(IN)

        then:
        OUT == result

        where:
        IN    || OUT
        121   || true
        131   || true
        34543 || true
        -121  || false
        10    || false
        0     || true

    }
}
