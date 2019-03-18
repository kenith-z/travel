package xyz.hcworld.travel.lib;

/**
 * 静态资源
 * @author: 张红尘
 * @date: 2018/10/30 21:51
 */
public class Lib {
    /**用户信息常量字符*/
    public static final String  USERNAME = "userName",NETNAME = "netname",SEX = "sex",EMAIL = "email",PHONE = "phone",CREATETIME = "createtime";
    /**
     * 防止js注入
     * */
    public static String[] JSSECURITY = {"&","<",">","\"","\'","/",},JSSECURITYTRANSLATE = {"&amp","&lt","&gt","&quot","&#x27","&#x2f"};


}
