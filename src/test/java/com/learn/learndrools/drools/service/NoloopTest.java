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
public class NoloopTest {

    @Test
    public void test_book_discount() {
        KieServices kieServices = KieServices.Factory.get();
        //获取Kie容器对象
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        //从Kie容器对象中获取回话对象
        KieSession kieSession = kieContainer.newKieSession();

        //Fact对象，事实对象
        Student student = new Student();
        student.setAge(50);
        student.setName("张三");
        //将Order对象插入到工作内存中
        kieSession.insert(student);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("noloop_"));
        kieSession.dispose();
        System.out.println(student.toString());
    }

}