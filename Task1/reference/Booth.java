public class Booth {
    //第二题
    private long id;
    private String name;
    private int total;
    private boolean isClosed;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public String toString() {
        return "Booth{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", isClosed=" + isClosed +
                '}';
    }

    public Booth(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
        System.out.println("瓜摊初始化成功！摊主的摊号为:" + id + ",姓名为:" + name + ",初始西瓜数为:" + total + "," + ",是否休整:" + isClosed);
    }

    public static void purchase(Booth booth,int number) {
        if (booth.isClosed) {
            System.out.println("由于商家休整,购买失败,摊主授剩余下西瓜为:" + booth.total);
        } else if (number < 0) {
            System.out.println("由于购买数量小于0,购买失败,摊主剩余西瓜为:" + booth.total);
        } else if (number > booth.total) {
            System.out.println("由于购买个数大于摊主所有个数,购买失败,摊主剩余西瓜为:" + booth.total);
        } else {
            booth.setTotal(booth.getTotal()-number);//静态方法若与Booth同类，也可以直接引用私有成员
            System.out.println("购买成功,摊主剩余西瓜为:" + booth.total);
        }
    }

    //进货方法
    public void restock(int number) {
        if (number >= 200||number<0) {
            System.out.println("进货失败,数量不得超过200或为负数");
        } else {
            this.total+=number;
            System.out.println("进货成功,摊主剩余西瓜为:" +total);
        }

    }

    public static void closeBooths(Booth[] booths) {
        //此处写法使用加强版for循环，也可以替换为普通循环
        for (Booth booth : booths) {
            if (!booth.isClosed()) {
                booth.setClosed(true);
            } else {
                System.out.println("这个瓜摊之前关了，瓜摊的信息:"+booth.toString());

            }
        }


    }
}


