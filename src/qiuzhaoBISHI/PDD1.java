package qiuzhaoBISHI;

import java.util.*;


/**
 * @author: 彭文杰
 * @create: 2018-08-16 21:23
 **/
public class PDD1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        string = string
                .replace("!", " ")
                .replace("-", " ")
                .replace("?", " ")
                .replace(",", " ")
                .replace(";", " ")
                .replace(":", " ")
                .replace(".", " ");
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toLowerCase();
        }
        Arrays.sort(strings);
        Map<String, Integer> map = new TreeMap<>();
        int max = 0;
        for (String str : strings
             ) {
            if (str.equals("")) continue;
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
                max = Math.max(max, map.get(str));
            }
        }
        for (String str : strings) {
            if (!map.containsKey(str)) continue;
            if (map.get(str).equals(max)) {
                System.out.print(str+" ");
                map.put(str, 0);
            }
        }
    }
}

//Connected to the target VM, address: VM VM VM
//i buy an apple watch from the aPple store, by the way I also like eating apple.