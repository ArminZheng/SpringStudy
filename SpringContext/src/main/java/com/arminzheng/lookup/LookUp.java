package com.arminzheng.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LookUp
 *
 * @author zy
 * @version 2022/4/30
 */
@Controller
public class LookUp {

    // @Autowired // 错误使用方式，被创建的时一次性放入到容器中，拿到还会是单例
    // PrototypeService prototypeService;

    @RequestMapping(path = "hi", method = RequestMethod.GET)
    public String hi() {
        return "helloworld, service is : " + prototypeService();
    }

    /**
     * 不允许有参数，不能是private
     *
     * @return 非单例的类型
     */
    @Lookup
    public PrototypeService prototypeService() {
        // @Lookup只能注解在方法上，这个时候可以注解在一个抽象方法
        // 如果是抽象方法，CGLIB的动态代理类就会实现这个方法，如果不是抽象方法，就会覆盖这个方法
        return null;
    }
}
