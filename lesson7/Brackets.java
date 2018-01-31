package lesson7;

import org.junit.Assert;
import org.junit.Test;
import java.util.Stack;

public class Brackets {
    @Test
    public void test(){
        String S= "{[()()]}";
        String S2 = "([)()]";
        String S3 = ")(";

        Assert.assertEquals(solution(S),1);
        Assert.assertEquals(solution(S2),0);
        Assert.assertEquals(solution(S3),0);
    }
    /**
     *
     * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")"
     *
     * @param S
     * @return
     */
    public int solution(String S) {
        // write your code in Java SE 8
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '[') {
                stack.push(S.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return 0;
                }else {
                    if (stack.peek() == '(') {
                        if (S.charAt(i) == ')') {
                            stack.pop();
                        }
                    } else if (stack.peek() == '{') {
                        if (S.charAt(i) == '}') {
                            stack.pop();
                        }
                    } else if (stack.peek() == '[') {
                        if (S.charAt(i) == ']') {
                            stack.pop();
                        }
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
