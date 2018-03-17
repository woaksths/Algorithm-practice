package lesson7;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Nesting {

    @Test
    public void test(){
        String s1= "(()(())())";
        String s2= "())";

        Assert.assertEquals(solution(s1),1);
        Assert.assertEquals(solution(s2),0);
    }

    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '('){
                stack.push(S.charAt(i)); // 집어넣고
            }else if(S.charAt(i) ==')'){
                if(stack.isEmpty()){
                    return 0;
                }else if(stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(S.charAt(i));
                }
            }
        }
        if(stack.isEmpty()){
            return 1;
        }else {
            return 0;
        }
    }
}
