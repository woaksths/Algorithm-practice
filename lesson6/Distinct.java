package lesson6;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    @Test
    public void test(){
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<A.length; i++){
            set.add(A[i]);
        }
        return set.size();
    }
}
