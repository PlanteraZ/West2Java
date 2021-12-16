package multithreading;

/*
 * @Author PlanteraZ
 * @ClassName Multithreading
 * @Package multithreading
 * @Description 利用synchronized信号量实现进程同步，交替打印
 * @Time 2021-12-03, Friday, 23:30
 */

public class Multithreading {
    private volatile boolean flag;

    private synchronized void printArr1(int[] array1) throws InterruptedException {
        for (int i : array1) {
            if(flag) {
                this.wait();
            }
            System.out.print(i + " ");
            flag = !flag;
            this.notifyAll();
        }
    }

    private synchronized void printArr2(int[] array2) throws InterruptedException {
        for (int j : array2) {
            if (!flag) {
                this.wait();
            }
            System.out.print(j + " ");
            flag = !flag;
            this.notifyAll();

        }
    }

    public void mutex(int[] arr1, int[] arr2) {
        Thread t1 = new Thread(()->{
            try {
                this.printArr1(arr1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");

        Thread t2 = new Thread(()->{
            try {
                this.printArr2(arr2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
