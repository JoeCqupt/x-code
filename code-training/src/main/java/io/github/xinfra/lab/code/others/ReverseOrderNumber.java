package io.github.xinfra.lab.code.others;

import java.util.ArrayList;
import java.util.List;

public class ReverseOrderNumber {

    public static void main(String[] args) {
        ReverseOrderNumber reverseOrderNumber = new ReverseOrderNumber();
        List<Integer> nums = reverseOrderNumber.findNums();
        System.out.println(nums);
    }

    public List<Integer> findNums() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1000; i * 9 < 10000; i++) {
            if (i * 9 == reverseOrder(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public int reverseOrder(int num) {
        int result = 0;
        while (num >= 10) {
            int dev = num % 10;
            num = num / 10;
            result = 10 * result + dev;
        }
        return 10 * result + num;
    }
}
