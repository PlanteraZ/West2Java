package catcafe.exception;

/*
 * @Author PlanteraZ
 * @Date 2021/10/30 23:35
 * @Description 余额不足异常类，继承自RuntimeException
 * @Since version-1.0
 */

//余额不足异常
public class InsufficientBalanceException extends RuntimeException {
    private static final long serialVersionUID = 2L;
    public InsufficientBalanceException(String message) {
        super(message);
    }
}