package catcafe;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:22
 * @Description 黑猫类，继承自Cat类
 * @Since version-1.0
 */

//黑猫
public class BlackCat extends Cat {
    double price = 350;

    public BlackCat(String name, int age, boolean gender, double price) {
        super(name, age, gender, price);
    }

    @Override
    public String toString() {
        return "该猫的名字为：" + this.name + " 年龄为：" + this.age +  " 性别为：" + this.gender + " 单只价格为：" + this.price;
    }
}

