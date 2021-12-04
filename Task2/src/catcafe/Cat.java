package catcafe;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:17
 * @Description 包含构造方法和抽象的toString方法的抽象类Cat
 * @Since version-1.0
 */

public abstract class Cat {
    protected String name;  //名字
    protected int age;  //年龄
    protected boolean gender;  //性别，false表示母猫，true表示公猫
    protected double price;  //单只价格

    //构造方法
    public Cat(String name, int age, boolean gender, double price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }

    //抽象的toString方法
    public abstract String toString();
}
