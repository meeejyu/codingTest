package coding.test;

import org.junit.jupiter.api.Test;

/*
 * 테스트 규칙
 * 테스트 명 : 키패드 누르기
 * 테스트 레벨 : 1Level
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67256
 * 문제 설명 : 
    이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
    맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

    엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
    왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
    오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
    가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
    4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
    순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

    [제한사항]
    numbers 배열의 크기는 1 이상 1,000 이하입니다.
    numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
    hand는 "left" 또는 "right" 입니다.
    "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
    왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
    입출력 예
    numbers	hand	result
    [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
    [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
    입출력 예에 대한 설명
    입출력 예 #1

    순서대로 눌러야 할 번호가 [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]이고, 오른손잡이입니다.

    왼손 위치	오른손 위치	눌러야 할 숫자	사용한 손	설명
    *	#	1	L	1은 왼손으로 누릅니다.
    1	#	3	R	3은 오른손으로 누릅니다.
    1	3	4	L	4는 왼손으로 누릅니다.
    4	3	5	L	왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.
    5	3	8	L	왼손 거리는 1, 오른손 거리는 3이므로 왼손으로 8을 누릅니다.
    8	3	2	R	왼손 거리는 2, 오른손 거리는 1이므로 오른손으로 2를 누릅니다.
    8	2	1	L	1은 왼손으로 누릅니다.
    1	2	4	L	4는 왼손으로 누릅니다.
    4	2	5	R	왼손 거리와 오른손 거리가 1로 같으므로, 오른손으로 5를 누릅니다.
    4	5	9	R	9는 오른손으로 누릅니다.
    4	9	5	L	왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.
    5	9	-	-	
    따라서 "LRLLLRLLRRL"를 return 합니다.

    입출력 예 #2

    왼손잡이가 [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]를 순서대로 누르면 사용한 손은 "LRLLRRLLLRR"이 됩니다.

    입출력 예 #3

    오른손잡이가 [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]를 순서대로 누르면 사용한 손은 "LLRLLRLLRL"이 됩니다.
 */
public class KeyPadTest {
    
    @Test
    public void testCase() {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        mySolution(numbers, "right");
        System.out.println("------------------------");
        realSolution(numbers, "right");
    }

    @Test
    public String mySolution(int[] numbers, String hand) {
        int[][] array = {{1,2,3}
                        ,{4,5,6}
                        ,{7,8,9}
                        ,{11,0,12}};

        String answer = "";
        // 왼손 위치 저장
        int left_x = 0;
        int left_y = 3;

        // 오른손 위치 저장
        int right_x = 2;
        int right_y = 3;

        // 센터 위치 저장
        int center_x;
        int center_y;

        int leftDistance = 0;
        int rightDistance = 0;
        for (int number : numbers) {
            // 왼손으로 눌러야 할 경우
            if(1==number || 4==number || 7==number || 11==number) {
                answer += 'L';
                for (int i = 0; i < 4 ; i++) {
                    if(array[i][0]==number) {
                        left_x = 0;
                        left_y = i;
                    }
                }
            }

            // 오른손으로 눌러야 할 경우
            if(3==number || 6==number || 9==number || 12==number) {
                answer += 'R';
                for (int i = 0; i < 4 ; i++) {
                    if(array[i][2]==number) {
                        right_x = 2;
                        right_y = i;
                    }
                }
            }

            if(2==number || 5==number || 8==number || 0==number) {
                for (int i = 0; i < 4 ; i++) {
                    if(array[i][1]==number) {
                        center_x = 1;
                        center_y = i;
                        leftDistance = (center_x-left_x >0? center_x-left_x : -(center_x-left_x)) + (center_y-left_y >0? center_y-left_y : -(center_y-left_y));
                        rightDistance = (center_x-right_x >0? center_x-right_x : -(center_x-right_x)) + (center_y-right_y >0? center_y-right_y : -(center_y-right_y));
                        if(rightDistance>leftDistance){
                            answer += 'L';
                            left_y = center_y;
                            left_x = center_x;
                        }
                        else if(rightDistance<leftDistance) {
                            answer += 'R';
                            right_y = center_y;
                            right_x = center_x;
                        }
                        else if(rightDistance==leftDistance){
                            if(hand.equals("right")){
                                answer += 'R';
                                right_y = center_y;
                                right_x = center_x;
                            }
                            else {
                                answer += 'L';
                                left_y = center_y;
                                left_x = center_x;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    @Test
    public String realSolution(int[] numbers, String hand) {

        // 키패드 설정
        int[][] array = {{1,2,3}
        ,{4,5,6}
        ,{7,8,9}
        ,{11,0,12}};

        System.out.println("배열확인"+array[3][0]);

        String answer = "";
        // 왼손 위치 저장
        int left_x = 3;
        int left_y = 0;

        // 오른손 위치 저장
        int right_x = 3;
        int right_y = 2;

        // 센터 위치 저장
        int center_x;
        int center_y;

        int leftDistance = 0;
        int rightDistance = 0;

        for (int number : numbers) {
            // 왼손으로 눌러야 할 경우
            if(1==number || 4==number || 7==number || 11==number) {
                answer += 'L';
                for (int i = 0; i < 4 ; i++) {
                    if(array[i][0]==number) {
                        left_x = i;
                    }
                }
                left_y = 0;
            }

            // 오른손으로 눌러야 할 경우
            if(3==number || 6==number || 9==number || 12==number) {
                answer += 'R';
                for (int i = 0; i < 4 ; i++) {
                    if(array[i][2]==number) {
                        right_x = i;
                    }
                }
                right_y = 2;
            }

            if(2==number || 5==number || 8==number || 0==number) {
                center_y = 1;
                for (int i = 0; i < 4 ; i++) {
                    if(array[i][1]==number) {
                        center_x = i;
                        leftDistance = calculation(center_x, center_y, left_x, left_y);
                        rightDistance = calculation(center_x, center_y, right_x, right_y);
                        if(rightDistance>leftDistance){
                            answer += 'L';
                            left_y = center_y;
                            left_x = center_x;
                        }
                        else if(rightDistance<leftDistance) {
                            answer += 'R';
                            right_y = center_y;
                            right_x = center_x;
                        }
                        else if(rightDistance==leftDistance){
                            if(hand.equals("right")){
                                answer += 'R';
                                right_y = center_y;
                                right_x = center_x;
                            }
                            else {
                                answer += 'L';
                                left_y = center_y;
                                left_x = center_x;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    @Test
    public int calculation(int center_x, int center_y, int x, int y) {

        int distance = Math.abs(center_x - x) + Math.abs(center_y - y);
        return distance;
    }

}
