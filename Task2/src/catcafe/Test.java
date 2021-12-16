package catcafe;

import java.util.*;
import java.time.LocalDate;

import catcafe.cat.BlackCat;
import catcafe.cat.OrangeCat;
import catcafe.catcafe.MyCatCafe;
import catcafe.customer.Customer;
import catcafe.exception.CatNotFoundException;
import catcafe.exception.InsufficientBalanceException;

/*
 * @Author PlanteraZ
 * @Date 2021/12/3 22:48
 * @Description 用于测试猫咖程序能否正常实现所有功能的测试类
 * @Since version-1.0
 */

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyCatCafe myCatCafe = new MyCatCafe();
        System.out.println("请输入要为该猫咖注入的启动资金：");
        myCatCafe.setBalance(in.nextDouble());
        System.out.println("猫咖创建成功！");
        while(true) {
            System.out.println("1.为该猫咖买入新猫猫\t2.创建新顾客，让该猫咖招待该顾客\t3.让该猫咖歇业\t4.退出程序");
            System.out.println("请输入想要进行的操作：");
            int choice = in.nextInt();
            label:
            switch(choice) {
                case 1: {
                    System.out.println("请输入想为该猫咖购买的猫猫的品种：1.橘猫 2.黑猫");
                    int kind = in.nextInt();
                    switch(kind) {
                        case 1: {
                            System.out.println("请输入该猫的名字：");
                            String name = in.next();
                            System.out.println("请输入该猫的年龄：");
                            int age = in.nextInt();
                            System.out.println("请输入该猫的性别，false表示母猫，true表示公猫：");
                            boolean gender = in.nextBoolean();
                            OrangeCat orangeCat = new OrangeCat(name, age, gender);
                            try {
                                myCatCafe.restock(orangeCat);
                            } catch (InsufficientBalanceException e) {
                                e.printStackTrace();
                            }
                            break label;
                        }
                        case 2: {
                            System.out.println("请输入该猫的名字：");
                            String name = in.next();
                            System.out.println("请输入该猫的年龄：");
                            int age = in.nextInt();
                            System.out.println("请输入该猫的性别，false表示母猫，true表示公猫：");
                            boolean gender = in.nextBoolean();
                            BlackCat blackCat = new BlackCat(name, age, gender);
                            try {
                                myCatCafe.restock(blackCat);
                            } catch (InsufficientBalanceException e) {
                                e.printStackTrace();
                            }
                            break label;
                        }
                        default: {
                            System.out.println("请输入正确的选项！");
                            break label;
                        }
                    }
                }
                case 2: {
                    Customer customer = new Customer();
                    System.out.println("请输入该顾客的姓名：");
                    customer.setName(in.next());
                    System.out.println("请输入该顾客想rua猫的次数：");
                    customer.setRuaCount(in.nextInt());
                    System.out.println("请分别输入该顾客到店时间的年、月、日，格式为：年(回车)月(回车)日(回车)：");
                    int year = in.nextInt();
                    int month = in.nextInt();
                    int day = in.nextInt();
                    customer.setArrivalTime(LocalDate.of(year, month, day));
                    System.out.println("顾客创建完成!");
                    try {
                        myCatCafe.serveCustomer(customer);
                    } catch (CatNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3: {
                    myCatCafe.stopBusiness();
                    System.out.println("本店已歇业！");
                    break;
                }
                case 4: return;
                default: {
                    System.out.println("请输入正确的选项！");
                    break;
                }
            }
        }
    }
}

