package coding.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class PracticeTest {
    
    @Test
    public void testCase() {
        String s = "one4seveneight";
        realSolution(s);
    }

    @Test
    private int realSolution(String s) {
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < number.length; i++) {
            if(s.contains(str[i])) {
                s = s.replace(str[i], number[i]);
            }
        }

        int answer = Integer.parseInt(s);

        System.out.println("answer = " + answer);
        return answer;
    }

}
