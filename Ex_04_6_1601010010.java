import java.util.Scanner;

public class Ex_04_6_1601010010 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double c, a = 9, b = 5, d = 32, k;
        
        System.out.println("摂氏温度 (C) > ");
        c = scan.nextDouble();
        
        
        k = ((a / b) * c) + d;
        System.out.printf("華氏温度 (F) : %.1f\n" , k);
        
        
        double e = 50.0, f = 65.0, g = 80.0;
        
        
        if (k < e){
            System.out.println("寒いです");
        } else if (k >= e && f > k){
            System.out.println("涼しいです");
        } else if (k >= f && g > k){
            System.out.println("暖かいです");
        } else {
            System.out.println("暑いです");
        }
    }
}