package com.learn.learndrools.drools.service;


import com.learn.learndrools.drools.entity.Student;
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
public class SalienceTest {

    @Test
    public void test_book_discount() {
        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取回话对象
        KieSession kieSession = kieContainer.newKieSession();


        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("salience_"));
        kieSession.dispose();
    }
}
