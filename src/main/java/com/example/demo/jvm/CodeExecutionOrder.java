package com.example.demo.jvm;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description 代码的执行顺序
 * @date 2021/8/19 3:13 下午
 */


/**
 * 执行顺序结果打印：
 *          CodeExecutionOrder的静态代码块555
 *          ==分割线============CodeExecutionOrder的main方法777
 *          Code的静态代码块3333
 *          Code的构造方法块2222
 *          Code的构造方法1111
 *          ------------------
 *          Code的构造方法块2222
 *          Code的构造方法1111
 *          ------------
 *          CodeExecutionOrder的构造块444
 *          CodeExecutionOrder的构造方法666
 *
 *
 *     结果分析：
 *          第一：静态的数据先行加载。类加载器会根据编译的.class文件，将类的结构信息加载到方法区中。所以静态修饰的数据会先加载执行，并且只会加载一次
 *          第二：main方法是一切程序的入口
 *          第三：JVM的语法规定：静态 > 构造块 > 构造方法
 *
 */

class CodeZY{
    public CodeZY() {
        System.out.println("Code的构造方法1111");
    }

    {
        System.out.println("Code的构造方法块2222");
    }

    static {
        System.out.println("Code的静态代码块3333");
    }
}

public class CodeExecutionOrder {

    {
        System.out.println("CodeExecutionOrder的构造块444");
    }

    static {
        System.out.println("CodeExecutionOrder的静态代码块555");
    }

    public CodeExecutionOrder() {
        System.out.println("CodeExecutionOrder的构造方法666");
    }

    public static void main(String[] args) {
        System.out.println("==分割线============CodeExecutionOrder的main方法777");

        new CodeZY();
        System.out.println("------------------");
        new CodeZY();
        System.out.println("------------");
        new CodeExecutionOrder();
    }
}
