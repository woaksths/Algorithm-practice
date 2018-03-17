package lesson8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class EquiLeader {

    @Test
    public void test() {
        int A[] = {4, 3, 4, 4, 4, 2};
      //  Assert.assertEquals(solution(A), 2);
        Assert.assertEquals(solution2(A), 2);
    }
    public int solution(int[] A) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        int dominate = -1;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                dominate = A[i];
                stack.push(A[i]);
            } else {
                if (stack.peek().equals(A[i])) {
                    stack.push(A[i]);
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() > 0) {
            for (int i = 0; i < A.length; i++) {
                int Lcount = 0;
                int Rcount = 0;
                for (int j = 0; j <= i; j++) { // i - j +1
                    if (dominate == A[j]) {
                        Lcount++;
                    }
                }
                for (int k = i + 1; k < A.length; k++) { // a.length -k
                    if (dominate == A[k]) {
                        Rcount++;
                    }
                }
                if (((i + 1) / 2) < Lcount && (A.length - (i + 1)) / 2 < Rcount) {
                    count++;
                }
            }
        } else { // dominator가 없으면 EquiLeader가 없을 것이다
            count = 0;
        }
        return count;
    }

    public int solution2(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int dominate = -1;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                dominate = A[i];
                stack.push(A[i]);
            } else {
                if (stack.peek().equals(A[i])) {
                    stack.push(A[i]);
                } else {
                    stack.pop();
                }
            }
        }
        // 4 3 4 4 4 2
        // 1 1 2 3 4 4
        // 누적 카운팅 작업.
        int result[] = new int[A.length];
        for(int i=0; i<result.length; i++){
            if(i==0){
                if(A[i] == dominate){
                    result[i] = 1;
                }else{
                    result[i] = 0;
                }
            }else{
                if(A[i] == dominate){
                  result[i] = result[i-1]+1;
                }else{
                    result[i] = result[i-1];
                }
            }
        }
        for(int i=0; i<result.length; i++){
            if(result[i] > (float)(i+1)/2&&(result[result.length-1]-result[i])> (float)(result.length-i-1)/2){
            count++;
            }
        }
        return count;
    }
}