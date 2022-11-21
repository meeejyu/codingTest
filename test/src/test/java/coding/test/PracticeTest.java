package coding.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class PracticeTest {

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    long sumQ1 = 0;
    long sumQ2 = 0;
    long sumQ12 = 0;

    @Test
    public void testCase() {
        // int[] a = {3, 2, 7, 2};
        // int[] b = {4, 6, 5, 1};
        int[] a = {1, 2, 1, 2};
        int[] b = {1, 10, 1, 2};
        mySolution(a, b);

    }
    
    public int mySolution(int[] queue1, int[] queue2) {

        int answer = 0;

        for (int i = 0; i < queue2.length; i++) {
            q1.add(queue1[i]);
            sumQ1 += queue1[i];
            q2.add(queue2[i]);
            sumQ2 += queue2[i];
        }

        sumQ12 = sumQ1 + sumQ2;

        if(sumQ1==sumQ2) {
            return answer;
        }

        if(sumQ12%2!=0) {
            answer = -1;
            return answer;
        }
        
        int maxCount = queue1.length*3;
        while(sumQ1!=sumQ2) {
            maxCount--;
            if(maxCount==0) {
                answer = -1;
                break;
            }
            while(sumQ1 > sumQ12/2) {
                int temp = q1.poll();
                q2.add(temp);
                sumQ1 -= temp;
                sumQ2 += temp;
                answer++;
            }
            while(sumQ2 > sumQ12/2) {
                int temp = q2.poll();
                q1.add(temp);
                sumQ2 -= temp;
                sumQ1 += temp;
                answer++;
            }
        }
        return answer;
    }
}
