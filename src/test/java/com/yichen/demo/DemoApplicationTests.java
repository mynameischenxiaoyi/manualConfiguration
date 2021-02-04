package com.yichen.demo;

import com.yichen.demo.controller.PersonController1;
import com.yichen.demo.utils.ClassUtil;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private PersonController1 personController1;

  @Autowired
  private ClassUtil classUtil;
  @Test
  void contextLoads() {

    Set<Class<?>> classSet = ClassUtil.getClassSet("com.yichen.demo.utils");
    System.out.println();
  }

}
