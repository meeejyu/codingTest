package coding.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class PracticeTest {

    @Test
    public void testCase() {
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
        // mySolution(fees, records);
        // realSolution(fees, records);

    }

    public String realSolution(String[] survey, int[] choices) {

        String temp = "";
        Map<String, Integer> map = new HashMap<>();

        System.out.println(map.toString());

        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int i = 0; i < choices.length; i++) {
            String type = "";

            if(choices[i] > 4) {
                type = survey[i].split("")[1];
                map.put(type, map.get(type) + choices[i] - 4);
            }
            if(choices[i] < 4) {
                type = survey[i].split("")[0];
                map.put(type, map.get(type) - choices[i] + 4);
            }
        }
        System.out.println(map.toString());

        if(map.get("R") >= map.get("T")) {
            temp += "R";
        }
        else {
            temp += "T";
        }

        if(map.get("C") >= map.get("F")) {
            temp += "C";
        }
        else {
            temp += "F";
        }

        if(map.get("J") >= map.get("M")) {
            temp += "J";
        }
        else {
            temp += "M";
        }

        if(map.get("A") >= map.get("N")) {
            temp += "A";
        }
        else {
            temp += "N";
        }

        return temp;
    }
}
