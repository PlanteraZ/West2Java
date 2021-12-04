package multithreading;

public class Test {
    public static void main(String[] args) {
        //该实现方法必须保证 a1、a2整型数组长度相同
        Multithreading multiThreading = new Multithreading();
        //可以修改下方两个数组的值
        int[] a1= {1,3,5,7,9};
        int[] a2= {2,4,6,8,10};
        //实现的void方法，传入两个数组
        multiThreading.mutex(a1,a2);
    }
}
