package legalemailadd;

import java.util.Scanner;

/*
 * @Author PlanteraZ
 * @Date 2021/11/2 11:51
 * @Description 判断邮箱地址是否符合中文或英文格式的测试类
 * @Since version-1.0
 */

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("1.输入邮箱地址，判断是否合法；2.退出程序");
            System.out.println("请输入选项：");
            int choice = in.nextInt();
            switch(choice) {
                case 1: {
                    System.out.println("请输入需要判断的邮箱地址：");
                    String emailAddress = in.next();
                    LegalEmailAdd.judgeLegalEmailAdd(emailAddress);
                    break;
                }
                case 2:
                    return;
                default: {
                    System.out.println("请输入正确的选项！");
                    break;
                }
            }
        }
    }
}
