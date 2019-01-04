package util;/*
 * @Description  -  -    :  BCrypt工具类
 * @Create    -  -  -    ： 2019/1/3 20:58
 * @Author    -  -  -    ： Ti
 * @Version   -  -  -    :  1.0
 **/

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {

    //生成加密字串
    public static String encode(String str) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedStr = bCryptPasswordEncoder.encode(str);

        return encodedStr;
    }


    //校验目标字串与加密字串是否匹配
    public static boolean verify(String str, String encodedStr) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(str, encodedStr);
    }
}
