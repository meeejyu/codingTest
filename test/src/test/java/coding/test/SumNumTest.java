package coding.test;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

/*
 * 테스트 규칙
 * 테스트 명 : 백준 8393번 
 * 테스트 레벨 : 빅오 표기법, 시간복잡도, 공간복잡도
 * 문제 링크 : https://www.acmicpc.net/problem/8393
 * 문제 설명 : 
   문제
    n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

    출력
    1부터 n까지 합을 출력한다.

    예제 입력 1 
    3

    예제 출력 1 
    6

 */
public class SumNumTest {
    
    @Test
    public void mySolution() {

        Scanner in = new Scanner(System.in);
		int N = in.nextInt();

        int value = 0;
		for(int i = 1 ; i <= N ; i++) {
			value = value + i;
		}
        System.out.print(value);
    }   
}

/*
    import java.util.Scanner;

    public class Main {
    
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
		    int N = in.nextInt();

            int value = 0;
		    for(int i = 1 ; i <= N ; i++) {
			    value = value + i;
		    }
            System.out.print(value);
        }
    }
 */
