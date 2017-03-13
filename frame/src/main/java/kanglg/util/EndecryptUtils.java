package kanglg.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 加密工具
 * Created by kanglg on 2017/2/24.
 */
@Component
public class EndecryptUtils {
    private static int hashIterations = 1;
    private static boolean storedCredentialsHexEncoded = false;

    public static String MD5Password(String password, String salt) {
        Md5Hash md5 = new Md5Hash(password, salt, hashIterations);
        if (storedCredentialsHexEncoded) {
            return md5.toHex();
        } else {
            return md5.toBase64();
        }
    }

    @Value("${shiro.credentialsMatcher.hashIterations}")
    public void setHashIterations(int hashIterations) {
        EndecryptUtils.hashIterations = hashIterations;
    }

    @Value("${shiro.credentialsMatcher.storedCredentialsHexEncoded}")
    public void setStoredCredentialsHexEncoded(boolean storedCredentialsHexEncoded) {
        EndecryptUtils.storedCredentialsHexEncoded = storedCredentialsHexEncoded;
    }
}
