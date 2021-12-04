package catcafe;

import java.time.LocalDate;
import java.util.*;

import catcafe.exception.*;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:37
 * @Description 包含买入猫猫、招待顾客、歇业三个方法的MyCatCafe类，实现CatCafe接口
 * @Since version-1.0
 */

public class MyCatCafe implements CatCafe {
    double balance;  // 店内余额
    double ruaFee = 15.0;  //rua一只猫的费用
    LinkedList<Cat> catList = new LinkedList<>();  //猫猫列表
    ArrayList<Customer> customerList = new ArrayList<>();  //顾客列表

    //买入猫猫
    public void restock(Cat cat) throws InsufficientBalanceException {
        if(this.balance < cat.price) {
            //店内余额不足时抛出异常
            throw new InsufficientBalanceException("店内余额不足，无法购买此猫猫");
        } else {
            catList.add(cat);
            this.balance -= cat.price;
            System.out.println("购买成功，该猫猫已入驻猫咖！");
        }
    }

    //招待顾客
    public void serveCustomer(Customer customer) throws CatNotFoundException {
        if(catList.isEmpty()) {
            //店内没有待rua的猫猫时抛出异常
            throw new CatNotFoundException("目前店内所有猫猫正在被rua，没有待rua的猫猫呢，请您稍等片刻！");
        } else {
            balance += ruaFee;
            //猫猫列表中随机取一只猫
            for(int i = 1; i <= customer.ruaCount; i++) {
                int randomCatNum = (int)(Math.random() * (catList.size()));
                System.out.println("该顾客第" + i + "次rua猫情况：");
                System.out.println("已为顾客找到猫猫，被rua的猫的信息如下：\n" + catList.get(randomCatNum));
            }
            customerList.add(customer);
        }
    }

    //歇业
    public void stopBusiness() {
        int totalRuaCount = 0;
        System.out.println("以下是今天光顾该店的所有顾客信息：");
        for(Customer customer : customerList) {
            if(Objects.equals(customer.arrivalTime, LocalDate.now())) {
                System.out.println(customer);
                totalRuaCount += customer.ruaCount;
            }
        }
        System.out.println("今天本店利润为：" + 15 * totalRuaCount);
    }
}





