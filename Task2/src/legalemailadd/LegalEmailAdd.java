package legalemailadd;

/*
 * @Author PlanteraZ
 * @Date 2021/11/2 11:48
 * @Description 用于判断邮箱地址是否符合中文或英文格式
 * @Since version-1.0
 */

public class LegalEmailAdd {
    //例：gaozihang-001@gmail.com 只允许英文字母、数字、下划线、英文句号、以及中划线组成
    static String regexEn = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    //例：高子航001Abc@bowbee.com.cn 名称允许汉字、字母、数字，域名只允许英文域名
    static String regexZh = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    //判断邮箱地址是否符合格式
    public static void judgeLegalEmailAdd(String emailAddress) {
        if(emailAddress.matches(regexEn)) {
            System.out.println("该邮箱地址符合英文邮箱地址格式");
        } else if(emailAddress.matches(regexZh)) {
            System.out.println("该邮箱地址符合中文邮箱地址格式");
        } else {
            System.out.println("该邮箱不符合中文及英文邮箱地址格式");
        }
    }
}
