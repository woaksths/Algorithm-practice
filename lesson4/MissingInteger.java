package lesson4;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 * 문제 해석: given an array A of N integers,
 * returns the smallest positive integer (greater than 0) that does not occur in A.
 * A의 배열의 원소에 해당하지 않는 것 중에서 가장 최소 양의 정수 값을 구해라
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 *
 * Assume that:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MissingInteger {
    @Test
    public void testSolution(){
        int A[] = {1,2,3,6,4,1,2};
        int B[] = {-1,-3};
      //  Assert.assertEquals(4, solution(A));
        Assert.assertEquals(solution2(A), 5);
    }
    public int solution(int[] A) { // 55%
        // write your code in Java SE 8
        Arrays.sort(A);
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<A.length; i++){
            set.add(A[i]);
        }
        int last = set.last();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=last; i++){
            list.add(i);
        }
        if(set.last()<=0){
            return 1;
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
                list.remove(iterator.next());
        }
        if(list.isEmpty()){ //
            return last+1;
        }
        return list.get(0);
    }

    public int solution2(int[] A){ // 77% 개선
        Arrays.sort(A);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            if (max < A[i]) {
                max = A[i];
            }
        }
        if(max <0){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<= max; i++){
          set.add(i);
        }
        for(int i=0; i<A.length; i++){
         set.remove(A[i]);
        }
        int min =Integer.MAX_VALUE;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            int num = (int) iterator.next();
            if(min > num){
                min = num;
            }
        }
        if(set.size()==0){
            return max+1;
        }else{
            //set 에서 제일 작은 수
            return min;
        }
    }
}