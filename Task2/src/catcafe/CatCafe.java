package catcafe;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:28
 * @Description 猫咖接口CatCafe
 * @Since version-1.0
 */

public interface CatCafe {
    default void restock(Cat cat) {}
    default void serveCustomer(Customer customer) {}
    default void stopBusiness() {}
}
