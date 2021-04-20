package com.example.demo.controller;

import com.example.demo.conf.TestAnnotaionConditionalOnProperties;
import com.example.demo.conf.TestSetDefaultValue;
import com.example.demo.entity.FanXing;
import com.example.demo.entity.Hello;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Order)表控制层
 *
 * @author sunchuanyin
 * @since 2021-02-24 13:55:04
 */
@RestController
@RequestMapping("/order")
//@Scope("prototype") // 这个注解只可用在controller层，表示多例模式，这样如果两个不同的请求访问了同一个成员变量，是不影响的，但是如果是在service调用同一个方法
// 中的同一个成员变量，会有影响,如果在service层中添加这个注解，是没有用的
public class OrderController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderService orderServiceImpl;

    private int num = 1;


    private TestSetDefaultValue testSetDefaultValue;

    @Autowired
    private TestAnnotaionConditionalOnProperties testAnnotaionConditionalOnProperties;

    @Autowired
    private PeopleService service;

    @Autowired
    public OrderController(TestSetDefaultValue testSetDefaultValue) {
        this.testSetDefaultValue = testSetDefaultValue;
    }


    public void hello() {
        System.out.println("OrderController->@PostConstruct注解的使用->hello()，服务器加载的时候运行，PostConstruct在构造函数之后执行，init（）方法之前执行");
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Order selectOne(Integer id) {
        return this.orderServiceImpl.queryById(id);
    }

    /**
     * 两个请求最好不要访问同一个全局的变量
     *
     * @return
     */
    @GetMapping("/hello1")
    public int hello1() {
//        int num = orderServiceImpl.getHello();
//        System.out.println("hello11111");
//        boolean hello = false;
//        assert hello;
//        System.out.println("assert hello != null -》 assert 断言");
//        Map<String, Object> defaultMap = testSetDefaultValue.getDefaultMap();
//        System.out.println(defaultMap);
        System.out.println(service);
        //num++;
        return num;
    }

    @GetMapping("/hello2")
    public int hello2() {
        int num = orderServiceImpl.getHello();
        System.out.println("测试TestAnnotaionConditionalOnProperties是否被注入到spring中：" + testAnnotaionConditionalOnProperties);
        //num++;
        return num;
    }


    public <T> T heloo(T hello) {
        return hello;
    }

    /**
     * 传参只能穿Hello的子类
     *
     * @param hello
     * @param <T>
     * @return
     */
    public <T extends Hello> T shangXian(T hello) {
        return hello;
    }

    /**
     * 方法上无法定义泛型的的下界
     *
     * @param args
     */
    /*public <T super Hello> T xiaXian(T hello) {
        return hello;
    }*/
    public static void main(String[] args) {
        FanXing hello = new FanXing<>("world");
        Object t = hello.getT();
        System.out.println(t);

        OrderController orderController = new OrderController(null);
        orderController.shangXian(new Hello()); // 上限  World继承了Hello
//        orderController.xiaXian(new HelloWorld()); 报错 HElloWorld是Hello的父类

    }

}