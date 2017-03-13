package kanglg.config.annotation;

import kanglg.config.Constants;

import java.lang.annotation.*;

/**
 * 当前用户注解，用于实现获取当前用户
 * Created by kanglg on 2017/3/10.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
    String value() default Constants.CURRENT_USER;
}
