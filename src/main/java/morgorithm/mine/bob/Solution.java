package morgorithm.mine.bob;


/*
* 밥먹는 조 짜기.
*
* 10명 -> [4,3,3]
* 9명 -> [3,3,3]
* */
public class Solution {

    public int [] bob(int total, int groupCount){

        int[] bobjo = new int[groupCount];
        int totalCount = 0;

        for(int i = 0 ; i < groupCount ; i ++){
            bobjo[i] = total / groupCount;
            totalCount += total / groupCount;
        }

        for(int i = 0 ; i < total - totalCount ; i++){
            bobjo[i]++;
        }

        return bobjo;
    }
}
