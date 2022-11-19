package coding.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.Test;

/*
 * 테스트 규칙
 * 테스트 명 : 메뉴 리뉴얼
 * 테스트 레벨 : 2 LEVEL
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72411
 * 문제 설명 : 
    레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
    기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다. 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 
    이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
    단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

    예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
    (각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)

    손님 번호	주문한 단품메뉴 조합
    1번 손님	A, B, C, F, G
    2번 손님	A, C
    3번 손님	C, D, E
    4번 손님	A, C, D, E
    5번 손님	B, C, F, G
    6번 손님	A, C, D, E, H
    가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.

    코스 종류	메뉴 구성	설명
    요리 2개 코스	A, C	1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
    요리 3개 코스	C, D, E	3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
    요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐습니다.
    요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐습니다.
    [문제]
    각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때, 
    "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

    [제한사항]
    orders 배열의 크기는 2 이상 20 이하입니다.
    orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
    각 문자열은 알파벳 대문자로만 이루어져 있습니다.
    각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
    course 배열의 크기는 1 이상 10 이하입니다.
    course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
    course 배열에는 같은 값이 중복해서 들어있지 않습니다.
    정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
    배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
    만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
    orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.
    [입출력 예]
    orders	course	result
    ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
    ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
    ["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
    입출력 예에 대한 설명
    입출력 예 #1
    문제의 예시와 같습니다.

    입출력 예 #2
    AD가 세 번, CD가 세 번, ACD가 두 번, ADE가 두 번, XYZ 가 두 번 주문됐습니다.
    요리 5개를 주문한 손님이 1명 있지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 5개로 구성된 코스요리는 새로 추가하지 않습니다.

    입출력 예 #3
    WX가 두 번, XY가 두 번 주문됐습니다.
    3명의 손님 모두 단품메뉴를 3개씩 주문했지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 3개로 구성된 코스요리는 새로 추가하지 않습니다.
    또, 단품메뉴를 4개 이상 주문한 손님은 없으므로, 요리 4개로 구성된 코스요리 또한 새로 추가하지 않습니다.

 */

public class MenuRenewalTest {

    List<String> answerList = new ArrayList<>();
    Map<String, Integer> hashMap = new HashMap<>();

    @Test
    public void testCase() {
        // String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        String[] orders = { "XYZ", "XWY", "WXA" };
        int[] course = { 2, 3, 4 };
        mySolution(orders, course);
        // realSolution(orders, course);
        // System.out.println("뭐지? : " + "YZ".substring(1));
    }

    public String[] mySolution(String[] orders, int[] course) {
        
        // 1. 각 Order 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray(); // char 형태로 변환
            Arrays.sort(arr); // 순서정렬
            orders[i] = String.valueOf(arr);
            System.out.println("찍어보기 : " + orders[i]);
        }

        // 2. 각 order를 기준으로 courseLength 만큼의 조합 만들기
        for (int courseLength : course) {
            for (String order : orders) {
                System.out.println("order 확인 : " + order + " courseLength 확인 : " +courseLength);
                combination("", order, courseLength);
            }

            // 3. 가장 많은 조합 answer에 저장
            if (!hashMap.isEmpty()) {
                List<Integer> countList = new ArrayList<>(hashMap.values());
                int max = Collections.max(countList); // 큰 수찾기

                if (max > 1)
                    for (String key : hashMap.keySet())
                        if (hashMap.get(key) == max)
                            answerList.add(key);
                hashMap.clear();
            }
            System.out.println("맵 확인2 : " +hashMap.toString());
        }

        Collections.sort(answerList); // 
        System.out.println("맵 확인3 : " +answerList.toString());
        
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);

        return answer;

    }

    public void combination(String order, String others, int count) {
        // 탈출 조건 : count == 0
        if (count == 0) {
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            System.out.println("맵 확인 콤비 카운트 0임 : " +hashMap.toString());
            return;
        }

        // 0부터 length까지 조합
        for (int i = 0; i < others.length(); i++) {
            System.out.println("맵 확인 콤비 카운트 " +count +  " 일때 : " +hashMap.toString());
            System.out.println("재귀함수에 들어가는 값 " + (order + others.charAt(i)) +  " 2번 : " +others.substring(i + 1) + " 카운트 : "+ count );
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
            
    }

}
