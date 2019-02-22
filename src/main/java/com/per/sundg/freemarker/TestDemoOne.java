package com.per.sundg.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.*;

/**
 * <br>
 * freemarker第一个案例
 * @ClassName: TestDemoOne
 * @Description: TODO
 * @Author sundg
 * @Date 2019/2/1 9:08
 * @VERSION 1.0
 */
public class TestDemoOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_0);
        try {
            //获取项目根路径
            File file = new File("");
            System.out.println( file.getAbsolutePath());
            String pathname = file.getCanonicalPath();

            //获取当前类路径
            String currentClassPath = new TestDemoOne().getClass().getResource("").getPath();
            System.out.println(currentClassPath);
            configuration.setDirectoryForTemplateLoading(new File(currentClassPath));
            configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS));
            configuration.setDefaultEncoding("utf-8");
            Template template = configuration.getTemplate("test.ftl");

            Map<String,Object> map = new HashMap<>(16);
            String stringShow = "String类型测试";
            map.put("stringShow",stringShow);

            Record record = new Record();
            record.setId(1L);
            record.setName("记录一");

            //往页面输出对象
            User user = new User();
            user.setUsername("小明1");
            user.setAge(18);
            user.setRecord(record);
            map.put("user", user);

            //输出list集合
            List<String> list = new ArrayList<>();
            list.add("测试freemarker list集合1");
            list.add("测试freemarker list集合2");
            list.add("测试freemarker list集合3");
            list.add("测试freemarker list集合4");
            map.put("numList", list);

            boolean booleTest = true;
            map.put("boolTest",booleTest);

            Date utildate = new Date();
            map.put("utildate",utildate);

            String nullVal = null;
            map.put("nullVal",nullVal);

            Map<String,Object> freeMap = new HashMap<>(16);
            freeMap.put("user","user123");
            freeMap.put("obj",user);
            map.put("map",freeMap);

            Writer writer = new OutputStreamWriter(new FileOutputStream(currentClassPath + "success.html"),"utf-8");
            template.process(map,writer);

            System.out.println("生成成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
