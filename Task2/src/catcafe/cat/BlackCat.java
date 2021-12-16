package catcafe.cat;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:22
 * @Description 黑猫类，继承自Cat类
 * @Since version-1.0
 */

//黑猫
public class BlackCat extends Cat {
    public BlackCat(String name, int age, boolean gender) {
        super(name, age, gender, 350);
    }

    @Override
    public String toString() {
        return "该猫的名字为：" + this.getName() + " 年龄为：" + this.getAge() +  " 性别为：" + this.isGender() +
                " 单只价格为：" + this.getPrice();
    }
}

