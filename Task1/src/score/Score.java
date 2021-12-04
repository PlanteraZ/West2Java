package score;

public class Score {
    public static void main(String[] args) {
        int[] scores = {45, 37, 76, 89, 44, 99, 54, 68, 59};
        System.out.println("平均成绩为：" + average(scores));
        System.out.println("最大成绩的下标为：" + max(scores));
    }

    static double average(int[] scores) {  //求平均成绩
        double avg = 0;
        for (int score : scores) {
            avg += score;
        }
        avg /= scores.length;
        return avg;
    }

    static int max(int[] scores) {  //求最大成绩的下标
        int max = 0;
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] > scores[max]) max = i;
        }
        return max;
    }
}
