package coding.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class PracticeTest {
    
    @Test
    public void testCase() {
        // mySolution("...!@BaT#*..y.abcdefghijklm");
        System.out.println("------------------------");
        realSolution("...!@BaT#*..y.abcdefghijklm");
    }

    // 코드 리팩토링
    @Test
    public String realSolution(String new_id) {

        String answer = "";

        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]", "");

        temp = temp.replaceAll("[.]{2,}", ".");

        temp = temp.replaceAll("^[.]|[.]$", "");

        if(temp.equals("")) {
            temp = "a";
        }

        if(temp.length() >= 16) {
            temp = temp.substring(0, 15);
            temp = temp.replaceAll("^[.]|[.]$", "");
        }

        if(temp.length() <= 2) {
            while(temp.length() < 3) {
                temp += temp.charAt(temp.length()-1);
            }
        }

        answer = temp;
        
        return answer;

    }

}
