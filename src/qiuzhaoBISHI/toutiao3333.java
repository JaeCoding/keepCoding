package qiuzhaoBISHI;


import java.util.Scanner;

/**
 * @author: 彭文杰
 * @create: 2018-09-09 10:02
 **/


import java.util.ArrayList;


public class toutiao3333 {
    public static ArrayList<String> ip(String s) {
        ArrayList<String> result=new ArrayList<String>();
        int len=s.length();

        for(int i=1;i<4&&i<len-2;i++){
            for(int j=i+1;j<i+4&&j<len-1;j++){
                for(int k=j+1;k<j+4&&k<len;k++){
                    if(len-k>=4)
                        continue;
                    int d=Integer.parseInt(s.substring(k));
                    int c=Integer.parseInt(s.substring(j,k));
                    int b=Integer.parseInt(s.substring(i,j));
                    int a=Integer.parseInt(s.substring(0,i));

                    if(a>255||b>255||c>255||d>255)
                        continue;
                    String ip=a+"."+b+"."+c+"."+d;
                    if(ip.length()<len+3)
                        continue;
                    result.add(ip);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        ArrayList<String> res = ip(str);

        System.out.println(res.size());

    }
}
