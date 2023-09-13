import java.util.Scanner;

public class Basic3 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int aSize = in.nextInt();
        int bSize = in.nextInt();
        int r = in.nextInt();

        int[] a = new int[aSize];
        int[] b = new int[bSize];
        for (int i = 0; i < aSize; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < bSize; i++) {
            b[i] = in.nextInt();
        }

        solve(a, b, r);

    }


    private static void solve(int[] a, int[] b, int r) {


        for (int i = 0; i < a.length; i++) {
            int aNum = a[i];
            for (int j = i; j < b.length; j++) {
                int bNum = b[j];
                if (aNum <= bNum && bNum - aNum <= r) {
                    System.out.println(aNum + " " + bNum);
                    break;
                }
            }
        }

    }


}
