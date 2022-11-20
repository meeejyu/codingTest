package coding.test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

/*
 * 테스트 규칙
 * 테스트 명 : 주차 요금 계산
 * 테스트 레벨 : 2 LEVEL
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * 문제 설명 : 
    주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다. 아래는 하나의 예시를 나타냅니다.

    요금표
    기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
    180	5000	10	600
    

    입/출차 기록
    시각(시:분)	차량 번호	내역
    05:34	5961	입차
    06:00	0000	입차
    06:34	0000	출차
    07:59	5961	출차
    07:59	0148	입차
    18:59	0000	입차
    19:09	0148	출차
    22:59	5961	입차
    23:00	5961	출차
    

    자동차별 주차 요금
    차량 번호	누적 주차 시간(분)	주차 요금(원)
    0000	34 + 300 = 334	5000 + ⌈(334 - 180) / 10⌉ x 600 = 14600
    0148	670	5000 +⌈(670 - 180) / 10⌉x 600 = 34400
    5961	145 + 1 = 146	5000
    어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
    0000번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.
    00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
    누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
    누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
    초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
    ⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다. 즉, 올림을 의미합니다.
    주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

    제한사항
    fees의 길이 = 4

    fees[0] = 기본 시간(분)
    1 ≤ fees[0] ≤ 1,439
    fees[1] = 기본 요금(원)
    0 ≤ fees[1] ≤ 100,000
    fees[2] = 단위 시간(분)
    1 ≤ fees[2] ≤ 1,439
    fees[3] = 단위 요금(원)
    1 ≤ fees[3] ≤ 10,000
    1 ≤ records의 길이 ≤ 1,000

    records의 각 원소는 "시각 차량번호 내역" 형식의 문자열입니다.
    시각, 차량번호, 내역은 하나의 공백으로 구분되어 있습니다.
    시각은 차량이 입차되거나 출차된 시각을 나타내며, HH:MM 형식의 길이 5인 문자열입니다.
    HH:MM은 00:00부터 23:59까지 주어집니다.
    잘못된 시각("25:22", "09:65" 등)은 입력으로 주어지지 않습니다.
    차량번호는 자동차를 구분하기 위한, `0'~'9'로 구성된 길이 4인 문자열입니다.
    내역은 길이 2 또는 3인 문자열로, IN 또는 OUT입니다. IN은 입차를, OUT은 출차를 의미합니다.
    records의 원소들은 시각을 기준으로 오름차순으로 정렬되어 주어집니다.
    records는 하루 동안의 입/출차된 기록만 담고 있으며, 입차된 차량이 다음날 출차되는 경우는 입력으로 주어지지 않습니다.
    같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않습니다.
    마지막 시각(23:59)에 입차되는 경우는 입력으로 주어지지 않습니다.
    아래의 예를 포함하여, 잘못된 입력은 주어지지 않습니다.
    주차장에 없는 차량이 출차되는 경우
    주차장에 이미 있는 차량(차량번호가 같은 차량)이 다시 입차되는 경우
    입출력 예
    fees	records	result
    [180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]	[14600, 34400, 5000]
    [120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	[0, 591]
    [1, 461, 1, 10]	["00:00 1234 IN"]	[14841]
    입출력 예 설명
    입출력 예 #1

    문제 예시와 같습니다.

    입출력 예 #2

    요금표
    기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
    120	0	60	591
    

    입/출차 기록
    시각(시:분)	차량 번호	내역
    16:00	3961	입차
    16:00	0202	입차
    18:00	3961	출차
    18:00	0202	출차
    23:58	3961	입차
    

    자동차별 주차 요금
    차량 번호	누적 주차 시간(분)	주차 요금(원)
    0202	120	0
    3961	120 + 1 = 121	0 +⌈(121 - 120) / 60⌉x 591 = 591
    3961번 차량은 2번째 입차된 후에는 출차된 내역이 없으므로, 23:59에 출차되었다고 간주합니다.
    

    입출력 예 #3

    요금표
    기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
    1	461	1	10
    

    입/출차 기록
    시각(시:분)	차량 번호	내역
    00:00	1234	입차
    

    자동차별 주차 요금
    차량 번호	누적 주차 시간(분)	주차 요금(원)
    1234	1439	461 +⌈(1439 - 1) / 1⌉x 10 = 14841
    1234번 차량은 출차 내역이 없으므로, 23:59에 출차되었다고 간주합니다.
 */

public class ParkingFeeTest {

    @Test
    public void testCase() {
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
        // mySolution(fees, records);
        realSolution(fees, records);

    }

    @Test
    public int[] mySolution(int[] fees, String[] records) {
        int[] answer = {};

            Map<String, Integer> fee = new HashMap<>();
            Map<String, String> car = new HashMap<>();
            
            for (int i = 0; i < records.length; i++) {
                String time = records[i].split(" ")[0];
                String num = records[i].split(" ")[1];
                String inOut = records[i].split(" ")[2];
                
                if(inOut.equals("IN")) {
                    car.put(num, time);
                }
                // out 일 경우
                else {
                    String inTime = car.get(num);
                    String outTime = time;
                    int saveTime = timeCal(inTime, outTime);
                    System.out.println("num : "+num + " 시간 : "+saveTime);
                    if(!fee.containsKey(num)) {
                        fee.put(num, saveTime);
                    }
                    else {
                        fee.put(num, fee.get(num) + saveTime);
                    }
                    car.remove(num);
                }
            System.out.println("car 맵 찍어보기"+car.toString());
            System.out.println("fee 맵 찍어보기"+fee.toString());
                
            }
            for(String key : car.keySet()) {
                String out = "23:59";
                String in = car.get(key);
                int save = timeCal(in, out);
                if(!fee.containsKey(key)) {
                    fee.put(key, save);
                }
                else {
                    fee.put(key, fee.get(key)+save);
                }
            }

            Map<String, Integer> lastFee = new TreeMap<>(fee);
            answer = new int[fee.size()];
            int i = 0;
            for(String carNum : lastFee.keySet()) {
                int min = lastFee.get(carNum);
                if(min<=fees[0]) {
                    answer[i++] = fees[1];
                }
                else {
                    answer[i++] = (int) (fees[1] + Math.ceil((double)(min-fees[0])/fees[2])*fees[3]);
                }
            }

        return answer;
    }

    public int timeCal(String inTime, String outTime) {


        int diffMin = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date1 = sdf.parse(inTime);
            Date date2 = sdf.parse(outTime);            
            long timeMil1 = date1.getTime();
            long timeMil2 = date2.getTime();
            long diff = timeMil2 - timeMil1;
            diffMin = (int)diff / (1000 * 60);

            System.out.println("시간 차이(분) : " + diffMin + "분");  
        } catch (Exception e) {

        }
        return diffMin;        
    }

    @Test
    public int[] realSolution(int[] fees, String[] records) {

        TreeMap<String, Integer> map = new TreeMap<>();

        for(String record : records) {
            String temp[] = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
            System.out.println("map 확인1 : "+ map.toString());
        }

        // fees[0] 기본시간 fees[1] 기본요금 fees[2] 단위시간 fees[3] 단위요금
        System.out.println("map 확인 : "+ map.toString());
        int idx = 0; 
        int ans[] = new int[map.size()];
        for(int time : map.values()) {
            if(time < 1) time += 1439; // 23시 59분을 의미
            time -= fees[0];
            int cost = fees[1];
            if(time > 0)
                cost += (time%fees[2] == 0 ? time/fees[2] : time/fees[2]+1)*fees[3];

            ans[idx++] = cost;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }

}
