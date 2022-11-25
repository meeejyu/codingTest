package coding.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/*
 * 테스트 규칙
 * 테스트 명 : 연속합 (백준 1912번)
 * 테스트 레벨 : 완전 탐색
 * 문제 링크 : https://www.acmicpc.net/problem/1912
 * 문제 설명 : 
    문제
    n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.

    예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.

    입력
    첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

    출력
    첫째 줄에 답을 출력한다.

    예제 입력 1 
    10
    10 -4 3 1 5 6 -35 12 21 -1
    예제 출력 1 
    33
    예제 입력 2 
    10
    2 1 -4 3 4 -4 6 5 -5 1
    예제 출력 2 
    14
    예제 입력 3 
    5
    -1 -2 -3 -4 -5
    예제 출력 3 
    -1
 */
public class ContinueSumTest {
    
    @Test
    public void testCase() {

        Scanner in = new Scanner(System.in);
		// int N = in.nextInt();
		int N = 10;

        int[] X = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
        
        // int[] X = new int[N];
        // for(int i = 0; i < N; i++) {
            // X[i] = in.nextInt();
        // }
        HashSet<Integer> Y = new HashSet<>();
        // int yLength = ((N*(N+1))/2)+1;
		// int[] Y = new int[yLength];
        int count = 0;
        for(int i = 0 ; i < N ; i++) {
            int A = X[i];
            count = count+1;
            Y.add(A);
            // Y[count] = A;
            for (int j = i+1; j < N; j++) {
                A = A + X[j];
                // Y[count] = A;
                count = count+1;
                Y.add(A);
            }
		}
        Arrays.sort(Y);
        System.out.print(Y[yLength-1]);
    }    
}
