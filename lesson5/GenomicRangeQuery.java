package lesson5;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class GenomicRangeQuery {
    @Test
    public void test(){
        String S= "CAGCCTA";
        int P[] = {2,5,0};
        int Q[] = {4,5,6};
        int result[] = {2,4,1};
        Assert.assertArrayEquals(solution(S,P,Q),result);
    }


    /**
     *
     * 문제 해석:
     *
     */
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int M = P.length;
        int result[] = new int[M];
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('A',1);hashMap.put('C',2);
        hashMap.put('G',3);hashMap.put('T',4);

        for(int i=0; i<M; i++){
            int min = Integer.MAX_VALUE;
            for(int j=P[i]; j<=Q[i];j++){
                int compareVal = hashMap.get(S.charAt(j)).intValue();
                if(min > compareVal){
                    min = compareVal;
                }
            }
            result[i] = min;
        }
        //expected worst-case time complexity is O(N+M);
        return result;
    }
}











