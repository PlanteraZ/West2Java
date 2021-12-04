public class BoothMain {
    //第二题的main方法
    public static void main(String[] args){
        Booth[] booths=new Booth[5];
        for(int i=0;i<5;i++){
            booths[i]=new Booth(i,"瓜摊"+i,i*5,false);
            //初始化五个瓜摊
        }
        booths[3].restock(233);
        booths[3].restock(-9);
        booths[4].restock(20);//进货成功，剩余库存应为40
        Booth.purchase(booths[0],20);//库存数量为0,购买失败
        Booth.purchase(booths[1],5);//购买成功
        Booth.purchase(booths[4],29);
        booths[4].setClosed(true);
        booths[0].setClosed(true);
        Booth.closeBooths(booths);
    }
}
