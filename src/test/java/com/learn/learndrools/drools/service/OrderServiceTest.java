package com.learn.learndrools.drools.service;

import com.learn.learndrools.drools.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Test
    public void test_book_discount() {
        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取回话对象
        KieSession kieSession = kieContainer.newKieSession();

        //Fact对象，事实对象
        Order order = new Order();
        order.setOriginalPrice(280d);
        //将Order对象插入到工作内存中
        kieSession.insert(order);

        //激活规则，由Drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("优惠后的价格：" +order.getRealPrice());
    }

}