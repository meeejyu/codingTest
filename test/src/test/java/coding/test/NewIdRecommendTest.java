package coding.test;

import org.junit.jupiter.api.Test;

/*
 * 테스트 명 : 신규 아이디 추천
 * 테스트 레벨 : 1 Level
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72410
 * 문제 설명 : 
    카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다. "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
    다음은 카카오 아이디의 규칙입니다.

    아이디의 길이는 3자 이상 15자 이하여야 합니다.
    아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
    단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
    "네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
    신규 유저가 입력한 아이디가 new_id 라고 한다면,

    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    예를 들어, new_id 값이 "...!@BaT#*..y.abcdefghijklm" 라면, 위 7단계를 거치고 나면 new_id는 아래와 같이 변경됩니다.

    1단계 대문자 'B'와 'T'가 소문자 'b'와 't'로 바뀌었습니다.
    "...!@BaT#*..y.abcdefghijklm" → "...!@bat#*..y.abcdefghijklm"

    2단계 '!', '@', '#', '*' 문자가 제거되었습니다.
    "...!@bat#*..y.abcdefghijklm" → "...bat..y.abcdefghijklm"

    3단계 '...'와 '..' 가 '.'로 바뀌었습니다.
    "...bat..y.abcdefghijklm" → ".bat.y.abcdefghijklm"

    4단계 아이디의 처음에 위치한 '.'가 제거되었습니다.
    ".bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"

    5단계 아이디가 빈 문자열이 아니므로 변화가 없습니다.
    "bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"

    6단계 아이디의 길이가 16자 이상이므로, 처음 15자를 제외한 나머지 문자들이 제거되었습니다.
    "bat.y.abcdefghijklm" → "bat.y.abcdefghi"

    7단계 아이디의 길이가 2자 이하가 아니므로 변화가 없습니다.
    "bat.y.abcdefghi" → "bat.y.abcdefghi"

    따라서 신규 유저가 입력한 new_id가 "...!@BaT#*..y.abcdefghijklm"일 때, 네오의 프로그램이 추천하는 새로운 아이디는 "bat.y.abcdefghi" 입니다.

    [문제]
    신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.

    [제한사항]
    new_id는 길이 1 이상 1,000 이하인 문자열입니다.
    new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
    new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
 * 
 */
public class NewIdRecommendTest {
    
    @Test
    public void testCase() {
        mySolution("...!@BaT#*..y.abcdefghijklm");
        System.out.println("------------------------");
        realSolution("...!@BaT#*..y.abcdefghijklm");
    }

    // 내가 해결한 방법
    @Test
    public String mySolution(String new_id) {
        String test1 = null;
        String test2 = null;
        String test3 = null;
        String test4 = null;
        String test5 = null;
        String test6 = null;
        String test7 = null;

        //1단계
        test1 = new_id.toLowerCase();
        // String[] test1_array = test1.split("");
        System.out.println("test1 = " + test1);

        //2단계
        test2 = test1.replaceAll("[^a-z0-9._-]", "");
        System.out.println("test2 = " + test2);

        //3단계
        // new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String[] test3_array = test2.split("");
        int init_length = test1.length();
        for (int i = 0; i < test3_array.length; i++) {
            if (test3_array[i].equals(".")) {
                int count = 0;
                for (int j = i+1; j <test3_array.length; j++) {
                    if (test3_array[j].equals(".")) {
                        count++;
                        if(j==(test3_array.length-1)) {
                            if(count>0) {
                                for(int t = 1; t<=count; t++) {
                                    test3_array[j-t] = "";
                                }
                            }
                        }
                    }
                    else {
                        if(count>0) {
                            for(int t = 1; t<=count; t++) {
                                test3_array[j-t] = "";
                            }
                        }
                        break;
                    }
                }
            }
        }
        test3 = String.join("",test3_array);
        System.out.println("test3 = " + test3);

        // 4단계
        String[] test4_array = test3.split("");
        if(test4_array[0].equals(".")) {
            test4_array[0] = "";
            test4 = String.join("",test4_array);
        }
        if(test4_array[test4_array.length-1].equals(".")) {
            test4_array[test4_array.length-1] = "";
            test4 = String.join("",test4_array);
        }
        test4 = String.join("",test4_array);
        System.out.println("test4 = " + test4);

        // 5단계
        String[] test5_array = test4.split("");
        if(test5_array.length==1 && test5_array.length<=init_length && test5_array[0].equals("")) {
            test5_array[0] = "a";
            test5 = String.join("",test5_array);
        }
        else if(test5_array[0].equals("")) {
            String[] new_test5_array = new String[1];
            new_test5_array[0] = "a";
            test5 = String.join("",new_test5_array);
        }
        else {
            test5 = String.join("",test5_array);
        }
        System.out.println("test5 = " + test5);

        // 6단계
        String[] test6_array = test5.split("");
        if(test6_array.length>=16) {
            test6 = test5.substring(0,15);
            test6_array = test6.split("");
            if(test6_array[test6_array.length-1].equals(".")) {
                test6_array[test6_array.length-1] = "";
            }
            test6 = String.join("",test6_array);
        }
        else {
            test6 = test5;
        }
        System.out.println("test6 = " + test6);

        // 7단계
        String[] test7_array = test6.split("");
        if(test7_array.length<=2) {
            String[] test8_array = new String[3];
            test8_array[0] = test7_array[0];
            if(test7_array.length==2) {
            test8_array[1] = test7_array[1];
            test8_array[2] = test7_array[1];
            test7 = String.join("",test8_array);
            }
            else {
                test8_array[1] = test7_array[0];
                test8_array[2] = test7_array[0];
                test7 = String.join("",test8_array);
            }
        }
        else {
            test7 = String.join("",test7_array);
        }

        System.out.println("최종확인임");
        System.out.println(test7);
        
        String answer = test7;
        
        return answer;
    }

    // 코드 리팩토링
    @Test
    public String realSolution(String new_id) {

        String answer = "";
        
        // 1단계
        String temp = new_id.toLowerCase();

        // 2단계
        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);

        // 3단계
        temp = temp.replaceAll("[.]{2,}",".");
        
        // 4단계
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());

        // 5단계
        if(temp.equals(""))
            temp+="a";

        // 6단계
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            // 제거 후 마침표(.)가 아이디 끝에 위치하면 문자 제거
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        // 7단계
        if(temp.length()<=2)
            while(temp.length()<3)
                // 길이가 3일 될때까지 반복해서 끝에 붙임
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        System.out.println(answer);
        return answer;
    }


}
