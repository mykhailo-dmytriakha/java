package _hackerrank.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaArraylist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalLines = Integer.parseInt(in.nextLine());
        int lineCounter = 1;
        Map<Integer, ArrayList<Integer>> data = new HashMap<>();
        while (totalLines > 0) {
            data.put(lineCounter, getList(in));
            lineCounter++;
            totalLines--;
        }
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0){
            int line = in.nextInt();
            int index = in.nextInt();
            printResult(data, line, index);
            testCases--;
        }
    }

    private static void printResult(Map<Integer, ArrayList<Integer>> data, int line, int index) {
        if(data.containsKey(line)){
            ArrayList<Integer> list = data.get(line);
            if(index < list.size()){
                System.out.println(list.get(index));
            } else {
                System.out.println("ERROR!");
            }
        }else {
            System.out.println("ERROR!");
        }
    }

    private static ArrayList<Integer> getList(Scanner in) {
        String[] numbers = in.nextLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}
