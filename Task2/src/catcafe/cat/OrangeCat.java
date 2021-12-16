package catcafe.cat;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:25
 * @Description 橘猫类，继承自Cat类
 * @Since version-1.0
 */

//橘猫
public class OrangeCat extends Cat { //200
    private boolean isFat;

    //getter方法
    public boolean isFat() {
        return isFat;
    }

    //setter方法
    public void setFat(boolean fat) {
        this.isFat = fat;
    }

    public OrangeCat(String name, int age, boolean gender) {
        super(name, age, gender, 200);
    }

    @Override
    public String toString() {
        return "该猫的名字为：" + this.getName() + " 年龄为：" + this.getAge() + " 性别为：" + this.isGender() +
                " 单只价格为：" + this.getPrice() + " 该猫是否很胖：" + this.isFat();
    }
}