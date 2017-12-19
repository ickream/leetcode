package com.ickream.leetcode;

/**
 * Created by xf on 2017/11/22.
 */
public class Test
{
    static
    {
        System.out.println("blockbbbB");
    }
    public static Test t1 = new Test();
    int a =99;
    {
        System.out.println("blockA"+a);
    }
    static
    {
        System.out.println("blockB");
    }
    public static void main(String[] args)
    {
//        Test t2 = new Test();
//        int i = 5;
//        int j = 10;
//        System.out.println(2);
    }
}
