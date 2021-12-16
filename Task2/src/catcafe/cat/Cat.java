package catcafe.cat;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:17
 * @Description 包含构造方法和抽象的toString方法的抽象类Cat
 * @Since version-1.0
 */

public abstract class Cat {
    private String name;  //名字
    private int age;  //年龄
    private boolean gender;  //性别，false表示母猫，true表示公猫
    private double price;  //单只价格

    //getter方法
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }

    public double getPrice() {
        return price;
    }

    //setter方法
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //构造方法
    public Cat(String name, int age, boolean gender, double price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }

    //抽象的toString方法
    @Override
    public abstract String toString();
}
