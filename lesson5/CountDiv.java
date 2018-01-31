package lesson5;

import org.junit.Assert;
import org.junit.Test;

/***
 *
 * A와 B 사이에 K로 나뉘어떨어지는 수의 개수를 구하여라
 *
 * expected worst-case time complexity is O(1)
 *
 */
public class CountDiv {

    @Test
    public void test(){
        //Assert.assertEquals(solution(6,11,2),3);
        Assert.assertEquals(solution2(1,1,11),0);
    }
    public int solution(int A, int B, int K) { // 50%
        // write your code in Java SE 8
        int count =0;
        for(int i=A; i<=B; i++){
            if(i%K ==0)
                count++;
        }
        return count;
    }
    public int solution2(int A,int B,int K){
        int a1 = A/K;
        int rem1 = A%K;
        int a2 = B/K;
        if(rem1>0){
            return a2-a1;
        }else{
            return a2-a1+1;
        }
    }
}