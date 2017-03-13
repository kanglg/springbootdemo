package kanglg.util;

import java.util.UUID;

/**
 * 随机数据生产工具
 * Created by kanglg on 2017/2/24.
 */
public final class RandomUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
