package kanglg.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密工具
 * Created by kanglg on 2017/2/24.
 */
public final class EndecryptUtils {
    public static String MD5Password(String password, String salt) {
        Md5Hash md5 = new Md5Hash(password, salt, 2);
            return md5.toBase64();
    }
}
