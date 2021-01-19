package com.learn.learndrools.drools.service;

import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobalTest {

    @Autowired
    private UserService userService;

    @Test
    public void test_book_discount() {
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm");
        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取回话对象
        KieSession kieSession = kieContainer.newKieSession();


        List<String> list = new ArrayList<>();
        list.add("永威");
        kieSession.setGlobal("count", 10);
        kieSession.setGlobal("gList", list);
        kieSession.setGlobal("userService", userService);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("global_"));
        kieSession.dispose();

        System.out.println("代码中的gList:" +list.size());
    }

}