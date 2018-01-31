package lesson6;

import org.junit.Assert;
import org.junit.Test;

public class Triangle {

    @Test
    public void test(){
        int A[] = {10,2,5,1,8,20};
        // 0,2,4 is triangular
        int B[] = {10,50,5,1};

        Assert.assertEquals(solution(A),1);
        Assert.assertEquals(solution(B),0);
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        return 0;
    }
}
