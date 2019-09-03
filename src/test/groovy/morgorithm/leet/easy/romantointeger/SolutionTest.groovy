package morgorithm.leet.easy.romantointeger

import org.spockframework.compiler.model.ThenBlock
import spock.lang.Specification

import javax.xml.transform.Result

class SolutionTest extends Specification {

    def "Roman To Integer"() {
        given:
        Solution solution = new Solution()

        expect:
        OUT == solution.romanToInt(IN)

        where:
        IN        || OUT
        "I"       || 1
        "V"       || 5
        "X"       || 10
        "L"       || 50
        "C"       || 100
        "D"       || 500
        "M"       || 1000
        "III"     || 3
        "IV"      || 4
        "IX"      || 9
        "LVIII"   || 58
        "MCMXCIV" || 1994
    }
}
