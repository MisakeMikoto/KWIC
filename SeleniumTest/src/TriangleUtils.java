public class TriangleUtils {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }


    public static boolean SJX1(int a, int b, int c) {

        if (a > 0 && b > 0 && c > 0) {

            if (a + b > c && a + c > b && b + c > a) {

                System.out.println("是一个三角形");
                return true;

            }

        } else {

            System.out.println("不能构成三角形");
            return false;

        }
        return false;

    }

    public static boolean dengyao(int a, int b, int c) {

        if (a == b || a == c || b == c) {

            System.out.println("是一个等腰三角形");
            return true;

        } else {

            System.out.println("不是一个等腰三角形");
            return false;

        }

    }

    public static boolean dengbian(int a, int b, int c) {

        if (a == b && a == c && b == c) {

            System.out.println("是一个等边三角形");
            return true;

        } else {

            System.out.println("不是一个等边三角形");
            return false;

        }

    }
}