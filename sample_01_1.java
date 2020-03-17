import java.util.Scanner;


public class sample_01_1 {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
	    
	    
	    System.out.print("入力する数 > ");
	    int n = scan.nextInt();
	    int[] array = new int[n];
	    
	    System.out.println(n + "個の整数値を入力してください。");
	    for (int i=0; i<n; i++) {
	        System.out.print(i+1 + "個目 > ");
	        array[i] = scan.nextInt();
	    }
	    
	    int sum = 0;
	    for (int i=0; i<n; i++) {
	       sum += array[i];
          }
            System.out.println("合計 : " + sum);
	  
	  
	    int max = array[0];
            for (int i=1; i<n; i++) {
	        if (array[i] > max) {
	               max = array[i];
	        }
	   }
	   System.out.println("最大値 : " + max);
	   
    }
}