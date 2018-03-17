package lesson8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Dominator {

    @Test
    public void test(){
        int A[] = {3,4,3,2,3,-1,3,3};
    }

    public int solution(int A[]){
        Stack<Integer> stack = new Stack<>();
        int candidiate = -1;
        for(int i=0; i<A.length; i++){
            if(stack.isEmpty()){
                candidiate = A[i];
                stack.push(A[i]);
            }else{
                if(stack.peek().equals(A[i])){
                    stack.push(A[i]);
                }else{
                    stack.pop();
                }
            }
        }
        int dominate = candidiate;
        if(stack.size() > 0){
            int count = 0;
            for(int i=0; i<A.length; i++){
                if(dominate == A[i]){
                    count++;
                }else{
                    continue;
                }
            }
            if(count > A.length/2){
                for(int i=0; i<A.length; i++){
                    if(A[i] == dominate){
                        return i; // return the index // 이 부분 헷갈렸어..
                    }
                }
            }else{
                return -1;
            }
        }else{
            return -1;
    }
        return -1;
    }
}
