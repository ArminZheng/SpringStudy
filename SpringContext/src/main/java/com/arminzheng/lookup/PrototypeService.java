package com.arminzheng.lookup;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeService {
    // 这种方式会在Autowired 时 bean 实例被创建的时候就一次性放入到容器中了，所以在后续拿的情况还会是单例的
}