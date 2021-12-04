package catcafe;

import java.time.LocalDate;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:30
 * @Description 包含重写的toString方法的顾客类
 * @Since version-1.0
 */

public class Customer {
    String name;  //顾客姓名
    int ruaCount;  //想要rua猫的次数
    LocalDate arrivalTime;  //到店时间

    @Override
    public String toString() {
        return "该顾客名字为：" + this.name + " 想要rua猫的次数为：" + this.ruaCount + " 到店时间为：" + this.arrivalTime;
    }
}
