package nagoor.java;

public class MultiDimensinalArray {
    public static void main(String[] args) {
        int[][] a = new int[2][3];

        a[0][0] = 10;
        a[0][1] = 20;
        a[0][2] = 30;

        a[1][0] = 101;
        a[1][1] = 201;
        a[1][2] = 301;

        for (int[] x : a) {
            for (int i : x) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println(a);
        System.out.println(a[0]);
    }
}
