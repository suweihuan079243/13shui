package algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class out {
    public static ArrayList<String> resort(String handPoker) {
        String[] strs = handPoker.split(" ");
        for (int i = 0; i < strs.length; i++) {
            char color = strs[i].charAt(0);
            char card = strs[i].charAt(1);
            if (card == 'J') {
                strs[i] = color + "11";
            } else if (card == 'Q') {
                strs[i] = color + "12";
            } else if (card == 'K') {
                strs[i] = color + "13";
            } else if (card == 'A') {
                strs[i] = color + "14";
            }
        }
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].substring(1);
        }
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1)
                sb.append(" ");
        }
        String[] temp = sb.toString().split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (temp[i].equals("11")) {
                temp[i] = "J";
            } else if (temp[i].equals("12")) {
                temp[i] = "Q";
            } else if (temp[i].equals("13")) {
                temp[i] = "K";
            } else if (temp[i].equals("14")) {
                temp[i] = "A";
            }
        }
        strs = handPoker.split(" ");
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < strs.length; j++) {

                if (temp[i].equals(strs[j].substring(1))) {
                    temp[i] = strs[j];
                    strs[j] = "NULL";
                }
            }
        }
        ArrayList<String> al = new ArrayList<>();
        for (int i =0;i<temp.length;i++)
        {
            char color = temp[i].charAt(0);
            char card = temp[i].charAt(1);
            if (card =='1'){
                temp[i] = Character.toString(color)+"￥";
            }
        }
        for (int i =0;i<temp.length;i++)
        {
           al.add(temp[i]);
        }
        return al;
    }
}


