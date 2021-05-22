package com.withWahib;
import java.util.Scanner;

public class Main{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
      /* تعريف متغير من كلاس سكانر باي اسم واستخدامه
       من أجل أستقبال مدخلات من المستخدم
       */

        System.out.println("أدخل عدد الأسطر والأعمدة للمصفوفة الأولى  : ");
        int rowsOfArray1 = in.nextInt();
        int columnOfArray1 = in.nextInt();
        System.out.println("أدخل عدد الأسطر والأعمدة للمصفوفة الثانية  : ");
        int rowsOfArray2 = in.nextInt();
        int columnOfArray2 = in.nextInt();

        int[][] array = new int[rowsOfArray1][columnOfArray1];
        int[][] array2 = new int[rowsOfArray2][columnOfArray2];
        if(rowsOfArray1==rowsOfArray2&&columnOfArray1==columnOfArray2) {
            System.out.println(" أدخل العملية الحسابية ( + - * / ) ");
            char op = in.next().charAt(0);
            // إنشاء حلقتين مدخلتين في بعض لاستقبال المدخلات وتخزينها في المصفوفة
            switch (op) {
                case '+' -> {
                    System.out.println("أدخل عناصر المصفوفة الأولى : ");
                    for (int r = 0; r < columnOfArray1; r++) {
                        for (int c = 0; c < rowsOfArray1; c++) {
                            System.out.printf(" أدخل العنصر [%d][%d] :\n ", r, c);
                            array[r][c] = in.nextInt();
                        }
                    }
                    System.out.println("أدخل عناصر المصفوفة الثانية : ");
                    for (int r = 0; r < rowsOfArray2; r++) {
                        for (int c = 0; c < columnOfArray2; c++) {
                            System.out.printf(" أدخل العنصر [%d][%d] :\n ", r, c);
                            array2[r][c] = in.nextInt();
                        }
                    }
                    addition(array, array2);
                }
                case '-' -> {
                    System.out.println("أدخل عناصر المصفوفة الأولى : ");
                    for (int r = 0; r < rowsOfArray1; r++) {
                        for (int c = 0; c < columnOfArray1; c++) {
                            System.out.printf(" أدخل العنصر [%d][%d] : %n", r, c);
                            array[r][c] = in.nextInt();
                        }
                    }
                    System.out.println("أدخل عناصر المصفوفة الثانية : ");
                    for (int r = 0; r < columnOfArray2; r++) {
                        for (int c = 0; c < rowsOfArray2; c++) {
                            System.out.printf(" أدخل العنصر [%d][%d] : %n", r, c);
                            array2[r][c] = in.nextInt();
                        }
                    }
                    subtraction(array, array2);
                }
                case '*' -> {
                    System.out.println("أدخل عناصر المصفوفة الأولى : ");
                    for (int r = 0; r < rowsOfArray1; r++) {
                        for (int c = 0; c < columnOfArray1; c++) {
                            System.out.printf(" أدخل العنصر [%d][%d] : %n", r, c);
                            array[r][c] = in.nextInt();
                        }
                    }
                    System.out.println("أدخل عناصر المصفوفة الثانية : ");
                    for (int r = 0; r < columnOfArray2; r++) {
                        for (int c = 0; c < rowsOfArray2; c++) {
                            System.out.printf(" أدخل العنصر [%d][%d] : %n", r, c);
                            array2[r][c] = in.nextInt();
                        }
                    }
                    int sum = 0;
                    int[][] multiply = new int[rowsOfArray1][columnOfArray1];
                    if (rowsOfArray1 != columnOfArray2) {
                        System.out.println("لا يمكن ضرب المصفوفتا!! يجب أن يكون عدد الأسطر في المصفوفة" +
                                " الاولى يساوي عدد الأسطر في المصفوفة الثانية.");
                    } else {
                        for (int i = 0; i < rowsOfArray1; i++) {
                            for (int d = 0; d < columnOfArray2; d++) {
                                for (int k = 0; k < rowsOfArray2; k++) {
                                    sum = sum + array[i][k] * array2[k][d];
                                }

                                multiply[i][d] = sum;
                                sum = 0;
                            }
                        }
                    }
                    printArray(multiply);
                }
                case '/' -> {
                    System.out.println("أدخل عناصر المصفوفة الأولى : ");
                    for (int r = 0; r < rowsOfArray1; r++) {
                        for (int c = 0; c < columnOfArray1; c++) {
                            System.out.printf(" أدخل العنصر [%d][%d] :\n ", r, c);
                            array[r][c] = in.nextInt();
                        }
                    }
                    System.out.println("أدخل عناصر المصفوفة الثانية : ");
                    for (int r = 0; r < columnOfArray2; r++) {
                        for (int c = 0; c < rowsOfArray2; c++) {
                            System.out.printf(" أدخل العنصر [%d][%d] : %n", r, c);
                            array2[r][c] = in.nextInt();
                        }
                    }
                    division(array, array2);
                }
                default -> System.out.println(" لقد أدخلت رمزا خارج العمليات الحسابية الموضحة في الأعلى ");
            }
        }
        else {
            System.out.println(" لقد ادخلت مصفوفتين مختلفتين !! ");
        }
    }


    // دالةعملية الجمع في المصفوفة
    private static void addition( int[][]array, int[][]array2){
        int row = array.length;
        int column= array[0].length;
        int [][] sum =new int[row][column];
        for(int i =0 ; i< row; i++){
            for(int j=0 ; j< column;j++){
                sum[i][j]=array[i][j] + array2[i][j];
            }
        }
        System.out.println("مجموع المصفوفتين يساوي : ");
        printArray(sum);
    }
    // دالة عملية الطرح في المصفوفة
    private static void subtraction(int[][]array, int[][]array2){
        int row = array.length;
        int column= array[0].length;
        int [][]sub=new int[row][column];
        for(int i =0 ; i< row; i++){
            for(int j=0 ; j< column;j++){
                sub[i][j]=array[i][j] - array2[i][j];
            }
        }
        System.out.println("حاصل طرح المصفوفتين يساوي : ");
        printArray(sub);
    }
    //دالة الطباعة
    private static  void printArray(int [][]matrices ){
        for (int[] matrix : matrices) {
            for (int c = 0; c < matrices[0].length; c++) {
                System.out.print(matrix[c] + "   \t");
            }
            System.out.println();
        }

    }
    // دالة عملية القسمة في المصفوفة
    private static void division(int[][]array, int[][]array2){
        int row = array.length;
        int column= array[0].length;
        int [][]div =new int[row][column];
        for(int i =0 ; i< row; i++){
            for(int j=0 ; j< column;j++){
                div[i][j]=array[i][j] / array2[i][j];
            }
        }
        System.out.println("حاصل قسمة المصفوفتين  : ");
        printArray(div);
    }

}
