package catcafe.catcafe;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:28
 * @Description 猫咖接口CatCafe
 * @Since version-1.0
 */

import catcafe.cat.Cat;
import catcafe.customer.Customer;

public interface CatCafe {
    void restock(Cat cat);
    void serveCustomer(Customer customer);
    void stopBusiness();
}
