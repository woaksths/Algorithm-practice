package lesson4;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    @Test
    public void testSolution(){
        int A[] ={1,1,1,1};
        Assert.assertEquals(solution(2,A),-1);
    }
    /****
     * 풀이 순서
     * 1. 1부터 X 만큼 합을 구한다.
     * 2. Set에 배열 A의 값을 추가한다. setSum = 0 초기화
     * 2-1. 배열의 길이가 1인데 그 값이 1보다 크다면 개구리는 절때 반대편으로 건너갈 수가 없다
     * 2-2. set에 A[i]원소가 포함되어 있지 않으면 add 하고 setSum에 A[i]를 더한다
     * 3. setSum 과 sum 이 같아지면 반복을 멈추고 해당 인덱스를 반환한다
     */
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int setSum=0;
        int idx=0;
        for(int i=0; i<=X; i++){
            sum+=i;
        }
        for(int i=0; i<A.length;i++){
            if(A.length ==1 && A[0]>1) {
                return -1;
            }
            if(!set.contains(A[i])){
                set.add(A[i]);
                setSum+=A[i];
                if(setSum==sum){
                    idx = i;
                    break;
                }
            }
        }
        if(set.size()!=X){
            return -1;
        }
        return idx;
    }

    /**
     *  jaeyoung
     *
     * 1. set 에 1부터 x까지 값을 add 한다
     * 2. set에서 배열 A의 원소들을 하나씩 지우면서
     * 3. set이 사이즈가 0, 비는 (인덱스) 순간 최초로 개구리가 점프 할 수 있는 시간이된다
     *
     */
    static int solution2(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        int result = -1;

        for(int i=1; i<=X; i++)
            set.add(i);

        for(int i=0; i<A.length; i++) {
            set.remove(A[i]);
            if(set.size()==0) {	// iterator를 사용하면 시간복잡도가 O(n**2)로 나옴
                result = i;
                break;
            }
        }
        return result;
    }

}
