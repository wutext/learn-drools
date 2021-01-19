package com.learn.learndrools.drools.service;

import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimerTest {

    @Test
    public void test_timer_timer_one() throws InterruptedException {
        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取回话对象
        KieSession kieSession = kieContainer.newKieSession();

        new Thread(new Runnable() {
            @Override
            public void run() {
                kieSession.fireUntilHalt(new RuleNameStartsWithAgendaFilter("timer_"));
            }
        }).start();

        Thread.sleep(10000);

        //结束规则引擎
        kieSession.halt();
        kieSession.dispose();
    }

    @Test
    public void test_timer_timer_cron() throws InterruptedException {
        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取回话对象
        KieSession kieSession = kieContainer.newKieSession();

        new Thread(new Runnable() {
            @Override
            public void run() {
                kieSession.fireUntilHalt(new RuleNameStartsWithAgendaFilter("timer_"));
            }
        }).start();

        Thread.sleep(10000);

        //结束规则引擎
        kieSession.halt();
        kieSession.dispose();
    }

}