package com.example.demo;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/2/24 1:55 下午
 */
public class MybatisCacheTest extends DemoApplicationTests {

    @Autowired
    private OrderService orderServiceImpl;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * mybatis一级缓存   默认开启   必须要手动使用sqlSession，因为缓存在sqlSession中,如果不通过手动的方式，直接使用mybatis，那么需要开启事务，
     * 是为了多次查询确保使用的是同一个sqlSession对象
     * 一级缓存或二级缓存，如果在同一个sqlSession对象中操作了update insert delete将会清除缓存中的数据
     * 一级缓存有两种作用域：session 和 statement 而statement只针对一次查询相等于是关闭了一级缓存
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void orderInsert() {

        /*手动使用sqlSession方式演示一级缓存*/
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionTemplate.getSqlSessionFactory(),sqlSessionTemplate.getExecutorType(),sqlSessionTemplate.getPersistenceExceptionTranslator());
//
//        OrderDao mapper = sqlSession.getMapper(OrderDao.class);
//        Order order = mapper.queryById(1);
//        order.setPrice(200);
//        System.out.println("第一次查询结果：" + order);
//        Order order1 = mapper.queryById(1);
//        System.out.println("第二次查询结果：" + order1);

        /*通过开启事务，确保同一个sqlSession演示一级缓存*/
        Order order2 = orderServiceImpl.queryById(1);
        order2.setPrice(10000);
        System.out.println(order2);
        System.out.println(orderServiceImpl.queryById(1));
//        Order order = new Order();
//        order.setPrice(100);
//        Order insert = orderServiceImpl.insert(order);
//        System.out.println(insert.getId());
//        Map<String,Object> map = new HashMap<>();
//        map.put("price",123.456);
//        System.out.println(orderServiceImpl.insertOrder(map));
    }

    /**
     * 开启二级缓存：
     *  在orderDao.xml文件中添加标签：<cache eviction="LRU" flushInterval="1000000" readOnly="true" size="1024"></cache>
     *  单个查询直接使用<cache></cache>标签
     *  如果是关联查询，还需要关联对应的mapper接口<cache-ref></cache-ref>
     *
     */
    @Test
    public void mybatisTwoCache() {
        Order order = orderServiceImpl.queryById(1);
        order.setPrice(1290);
        System.out.println(order);
        System.out.println(orderServiceImpl.queryById(1));
    }
}
