package kanglg;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World!
 * Created by kanglg on 2017/3/7.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "Hello World!!";
    }
}
