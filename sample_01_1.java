import java.util.Scanner;


public class sample_01_1 {
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
	    
	    
	    System.out.print("���͂��鐔 > ");
	    int n = scan.nextInt();
	    int[] array = new int[n];
	    
	    System.out.println(n + "�̐����l����͂��Ă��������B");
	    for (int i=0; i<n; i++) {
	        System.out.print(i+1 + "�� > ");
	        array[i] = scan.nextInt();
	    }
	    
	    int sum = 0;
	    for (int i=0; i<n; i++) {
	       sum += array[i];
          }
            System.out.println("���v : " + sum);
	  
	  
	    int max = array[0];
            for (int i=1; i<n; i++) {
	        if (array[i] > max) {
	               max = array[i];
	        }
	   }
	   System.out.println("�ő�l : " + max);
	   
    }
}