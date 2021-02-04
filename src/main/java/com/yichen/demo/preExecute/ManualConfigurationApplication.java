package com.yichen.demo.preExecute;

import com.yichen.demo.utils.ClassUtil;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author 陈易chenyi01
 * @version 1.0
 * @date 2021/2/4 8:44 下午 phone 13172680119
 */
@Component
public class ManualConfigurationApplication implements InitializingBean {
  public static String osName;
  public static File root;
  public static HashMap<String, Set<Class<?>>> map=new HashMap<>();

  // 可以指定要读取的路径
  String packageName = "";

  @Override
  public void afterPropertiesSet() throws Exception {
    getOsName();
    getRootPath();
    getFilePath();
  }

  private void getFilePath() throws Exception {
    loop(root, packageName);
  }

  public static void loop(File folder, String packageName) throws Exception {
    File[] files = folder.listFiles();
    for (int fileIndex = 0; fileIndex < files.length; fileIndex++) {
      File file = files[fileIndex];
      if (file.isDirectory()) {
        loop(file, packageName + file.getName() + ".");
      }else {
        String absolutePath = file.getAbsolutePath();
        int beginIndex = absolutePath.indexOf("java")+5;
        String substring = absolutePath.substring(beginIndex);
        Set<Class<?>> classSet = ClassUtil.getClassSet(substring);
        if(classSet.size()>0){
          if( map.get(substring)==null|| map.get(substring).size()==0 ){
            Set<Class<?>> objects = new HashSet<>();
            objects.add()
            map.put(substring)
          }

          map.put(substring,classSet);
        }
      }
    }
    System.out.println();
  }
  public static void listMethodNames(String filename, String packageName) {
    try {
      String name = filename.substring(0, filename.length() - 5);
      Object obj = Class.forName(packageName + name);
      Method[] methods = obj.getClass().getDeclaredMethods();
      System.out.println(filename);
      //    Set<Class<?>> classSet =
      for (int i = 0; i < methods.length; i++) {
        System.out.println("\t" + methods[i].getName());
      }
    } catch (Exception e) {
      System.out.println("exception = " + e.getLocalizedMessage());
    }
  }

  private void getRootPath() {
    if(osName.equals("mac")){
      root = new File(System.getProperty("user.dir") + "/src/main/java");
    }
    if(osName.equals("win")){
      root = new File(System.getProperty("user.dir") + "\\src\\main\\java");
    }
    if(osName==null){
      throw new RuntimeException("暂不支持该系统");
    }
  }

  private void getOsName() {
    String property = System.getProperty("os.name");
    osName = property.substring(0, 3).toLowerCase();
    if(osName==null){
      throw new RuntimeException("未获取到osName！");
    }
  }


}
