package lesson6;


import java.util.HashSet;
import java.util.Set;

public class Distinct {
    /*
        배열의 원소 중 distinct 원소 갯수 -> set 집합
     */
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++){
            set.add(A[i]);
        }
        return set.size();
    }
}
