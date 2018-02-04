package lesson4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class PermCheck {
    @Test
    public void test(){
        int A[]={9, 5, 7, 3, 2, 7, 3, 1, 10, 8}; //4,6
        Assert.assertEquals(0, solution(A));
    }
    /***
     *
     * 풀이 순서
     * 1. A의 배열과 같은 길이의 배열을 만든다
     * 2. 새로운 배열에 반복을 돌면서 1부터 N (길이)만큼 값을 setting 한다
     * 3. 그리고 나서 A를 정렬시키고 정렬된 A와 새로운 배열 B를 비교하여
     * 4. 다른 부분이 있으면 missing Value가 있다고 가정하고 문제해결하였다.
     */


    public int solution(int[] A) {
        // write your code in Java SE 8
        int b[] = new int[A.length];
        int flag = 1;
        Arrays.sort(A);  // Arrays.sort() 를 쓰면 시간복잡도가 O(n*log(n)) 이 되므로 좋은 방법이 아님
        for(int i=0; i<A.length; i++){
            b[i] = i+1;
        }
        for(int i=0; i<b.length; i++){
            if(A[i] ==b[i]) {
                continue;
            }else{
                flag=0;
                break;
            }
        }
            return flag;
        }



    /*
	 *  해결전략 - jaeyoung
	 *  1. 전제
	 *  1.1. A배열에는 1 ~ n+1까지의 숫자 중 n개의 숫자만 존재
	 *  1.2. A배열에 존재하지 않는 숫자를 찾는다.
	 *
	 *  2. 프로세스
	 *  2.1. Set에 1~n+1의 숫자를 입력한다.
	 *  2.2. 배열을 순회하면서 존재하는 숫자를 제거한다.
	 *  2.3. Set에 최종으로 남는 숫자가 존재하지 않는 숫자다.
	 */

    static int solution2(int[] A) {
        Set<Integer> set = new HashSet<>();

        for(int i=1; i<A.length+1; i++)
            set.add(i);

        for(int i=0; i<A.length; i++)
            set.remove(A[i]);
        return set.iterator().hasNext()==true ? 0 : 1;
    }
}
