
import org.junit.Assert;
import org.junit.Test;

/***
 *
 * 2018 01 18
 *
 * 문제 해석 = [ 1 ~ 배열의 길이 +1] 값 중 missing Element 값을 구하는 문제
 *
 * 해결 전략 2:
 *  1 부터 배열 길이+1 까지 합에서
 *  배열의 원소들을 순차적으로 반복을 돌리면서 뺴서
 *  최종적으로 나온 결과값이 missing Element가 될 것 같다. 100%
 */

public class PermMissingElem {

    @Test
    public void testSolution(){
        int A[] = {2,3,1,5};
        Assert.assertEquals(4,solution2(A));
    }

    public int solution2(int[] A){
        int sum=0;
        for(int i=0; i<A.length+2; i++){
            sum+=i;
        }
        for(int i=0; i<A.length; i++){
            sum-= A[i];
        }
        return sum;
    }
}

