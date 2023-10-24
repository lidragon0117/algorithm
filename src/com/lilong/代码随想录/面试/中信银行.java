package com.lilong.代码随想录.面试;



import java.util.Scanner;

/**
 * @author :lilong
 * @date :2023-10-19-13:40
 * @description :
 */
public class 中信银行 {
    /**
     * 2
     * 1 2
     * 3 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
        int ns=in.nextInt();
        int[][] matrix=new int[ns][ns];
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;i<n;j++){
                matrix[i][j]=in.nextInt();
            }
        }
        //水平
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-1-i][j];
                matrix[n-1-i][j]=temp;
            }
        }
        //垂直
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
//    public static void main(String[] args) {
//        Map<Character, Integer> result = new HashMap<Character, Integer>();
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        for (char c : str.toCharArray()){
//            result.put(c,result.getOrDefault(c,0)+1);
//        }
//        StringBuilder sb = new StringBuilder();
//        for(Map.Entry<Character,Integer> entry:result.entrySet()){
//            if(entry.getValue()>=2){
//                sb.append(entry.getKey());
//            }
//        }
//        System.out.println(sb.toString());
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (isVowel(c)){
//                sb.append(Character.toLowerCase(c));
//            }else{
//                sb.append(Character.toUpperCase(c));
//            }
//        }
//        System.out.println(sb.toString());
//    }

    public static boolean isVowel(char c) {
        char c1 = Character.toLowerCase(c);
        return c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u';
    }
}