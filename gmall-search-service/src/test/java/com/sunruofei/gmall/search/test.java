package com.sunruofei.gmall.search;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入整数：");

        Double[] wallPoints ={};
        Double[] lengthsi={};
        int n =0 ;
        int h =0 ;
        for(int i=0 ; i<=2;i++){
            if (i==0 ){
                if (scanner.hasNextLine()){
                    String s= scanner.nextLine();

                    String[] s1 = s.split("\\s+");
                    //n张海报
                    n = Integer.parseInt(s1[0]);
                    //身高
                    h = Integer.parseInt(s1[1]);
                }

            }
            //贴墙的高度
            if (i==1 ){
                if (scanner.hasNextLine()) {
                    String s = scanner.nextLine();

                    String[] s1 = s.split("\\s+");
                    for (int j = 0; j < s1.length; j++) {
                        wallPoints[j] = Double.parseDouble(s1[j]);
                    }
                }
            }
            //海报长度
            if (i==2 ){
                if (scanner.hasNextLine()) {
                    String s = scanner.nextLine();

                    String[] s1 = s.split("\\s+");
                    for (int j = 0; j < s1.length; j++) {
                        lengthsi[j] = Double.parseDouble(s1[j]);
                    }
                }
            }

        }

        //计算每个需要高度的数组
        double[] need = {};

        for (int i=0; i< wallPoints.length ; i++) {
            need[i] =  wallPoints[i] -lengthsi[i]/4 -(h-h*0.05);

        }

        //need[i]排序，取出最达高度梯子
        sortPlus(need);
        System.out.println(need[0]);

    }

    //排序算法
    public static void sortPlus(double[] arr){
        if(arr != null && arr.length > 1){
            for(int i = 0; i < arr.length - 1; i++){
                // 初始化一个布尔值
                boolean flag = true;
                for(int j = 0; j < arr.length - i - 1 ; j++){
                    if(arr[j] > arr[j+1]){
                        // 调换
                        double temp;
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        // 改变flag
                        flag = false;
                    }
                }
                if(flag){
                    break;
                }
            }
        }
    }


    //反转算法
    public static String reverse(String originStr) {
        System.out.println(originStr);
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static String fun1() {

        try {

            System.out.print("A");

            return fun2();

        } finally {

            System.out.print("B");

        }

    }



    public static String fun2() {

        System.out.print("C");

        return "D";

    }
}
