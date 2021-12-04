package melon;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Melon {
    public static void main(String[] args) {
        Map<Long, Booth> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1.创建新摊位\t2.向指定摊位购买西瓜\t3.为指定摊位进货\t4.输出已歇业的摊位信息，让未歇业的摊位歇业整改\t5.退出程序");
            System.out.println("请输入想要进行的操作：");
            int choice = sc.nextInt();
            switch(choice) {
                case 1: {
                    long id;
                    do {
                        System.out.println("输入新摊位的摊号：");
                        id = sc.nextLong();
                        while (map.containsKey(id)) {
                            System.out.println("该摊号已存在，请重新输入：");
                        }
                    } while (map.containsKey(id));
                    System.out.println("输入新摊位的摊主姓名：");
                    String name = sc.next();
                    System.out.println("输入新摊位在售的西瓜数：");
                    int total = sc.nextInt();
                    System.out.println("输入新摊位是否休摊整改(true/false)：");
                    boolean isClosed = sc.nextBoolean();
                    Booth booth = new Booth(id, name, total, isClosed);
                    map.put(id, booth);
                    System.out.println("摊位创建完毕");
                    break;
                }
                case 2: {
                    System.out.println("输入想要去购买西瓜的摊位摊号：");
                    long id = sc.nextLong();
                    System.out.println("输入想要购买的西瓜数量");
                    int purchaseNum = sc.nextInt();
                    Booth.purchase(map.get(id), purchaseNum);
                    break;
                }
                case 3: {
                    System.out.println("输入想要进货的摊位摊号：");
                    long id = sc.nextLong();
                    System.out.println("输入想要进货的西瓜数：");
                    int restockNum = sc.nextInt();
                    map.get(id).restock(restockNum);
                    break;
                }
                case 4: {
                    Booth.closeBooths(map.values().toArray(new Booth[0]));
                    break;
                }
                case 5:
                    return;
            }
        }
    }
}

class Booth {
    private long id;  //摊号
    private String name;  //摊主姓名
    private int total;  //在售的西瓜数
    private boolean isClosed;  //是否休摊整改

    //构造方法
    Booth(long id, String name, int total, boolean isClosed) {
        this.setId(id);
        this.setName(name);
        this.setTotal(total);
        this.setIsClosed(isClosed);
    }

    //参数的set方法
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    //参数的get方法
    public long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getTotal() {
        return this.total;
    }
    public boolean getIsClosed() {
        return this.isClosed;
    }

    //输出该西瓜摊的所有信息
    @Override
    public String toString() {
        return "摊号为：" + this.id + " 摊主姓名为：" + this.name + " 在售西瓜数为：" + this.total + " 是否休摊整改：" + this.isClosed;
    }

    //向目标摊位卖家购买指定数量的西瓜
    public static void purchase(Booth booth, int purchaseNum) {
        if(purchaseNum <= 0) System.out.println("购买的西瓜数必须为正数!");
        if(booth.isClosed) System.out.println("商家不能处于休摊整改状态!");
        if(purchaseNum > booth.total) System.out.println("购买西瓜数不能大于在售西瓜数!");
        if(purchaseNum > 0 && !booth.isClosed && purchaseNum <= booth.total) {
            booth.total -= purchaseNum;
            System.out.println("交易成功!\n当前摊位在售西瓜数为:" + booth.total);
        }
    }

    //为对应摊位进货
    public void restock(int restockNum) {
        if(restockNum > 200) {
            System.out.println("单次进货量不能超过200, 进货失败!");
        } else {
            this.total += restockNum;
        }
    }

    //输出已歇业整改的摊位信息，让booths中所有未歇业整改的摊位歇业
    public static void closeBooths(Booth[] booths) {
        System.out.println("已在休业整改的摊位信息如下：");
        for(Booth booth : booths) {
            if(booth.isClosed) {
                System.out.println(booth);
            }
        }
        for(Booth booth : booths) {
            if(!booth.isClosed) {
                booth.isClosed = true;
            }
        }
        System.out.println("所有未被休业整改的摊位已调整为歇业");
    }
}
