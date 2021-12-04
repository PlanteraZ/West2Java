import java.util.Scanner;

public class Score {
    //第一题
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入分数个数");
        int n = scanner.nextInt();
        System.out.println("依次输入各个分数");
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        System.out.println("平均分是: "+average(scores));
        System.out.println("分数最大的下标是: " + maxIndex(scores));
    }

    public static double average(int[] scores) {
        double num = 0;
        for (int i = 0; i < scores.length; i++) {
            num += scores[i];
        }
        //此处也可以使用加强版的for循环，见IDEA的提示进行替换
        return num / scores.length;
    }

    public static int maxIndex(int[] scores) {
        int max = 0, index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                index = i;
            }
        }
        return index;
    }
}
