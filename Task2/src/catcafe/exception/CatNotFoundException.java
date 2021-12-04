package catcafe.exception;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:33
 * @Description 找不到猫异常类，继承自RuntimeException
 * @Since version-1.0
 */

//找不到猫异常
public class CatNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public CatNotFoundException(String message) {
        super(message);
    }
}