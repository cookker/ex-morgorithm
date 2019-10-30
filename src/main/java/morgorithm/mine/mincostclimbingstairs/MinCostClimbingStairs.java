package morgorithm.mine.mincostclimbingstairs;

public class MinCostClimbingStairs {
    /*
    *
    * Once you pay the cost, you can either climb one or two steps.
    *
    *
    * Example 1:
    *
    * input: cost = [10, 15 20]
    * output: 15
    *
    * Example 2:
    * input: cost = [1, 100, 1,1,1, 100, 1,1, 100, 1]
    * output: 6
    *
    * */



}


/*
* public int solution(int [] costs){
        int answer = 0;
        int stepCount = 0;

        for(int currentStep = 0 ; currentStep < costs.length -1 ; ){

            System.out.println(costs[currentStep] + ", " + costs[currentStep + 1]);
            if(costs[currentStep] < costs[currentStep + 1]){
                stepCount += costs[currentStep];
                currentStep +=2;
            }else{
                stepCount += costs[currentStep + 1];
                currentStep++;
            }
        }

        return stepCount;
    }
* */