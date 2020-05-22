package cn.system.utils;

import java.util.Random;

/**
 * 随机数工具类
 */
public class RandomUtil {

    /**
     * 随机返回bool
     * @return
     */
    public static Boolean returnBool(){
        Boolean answer=false;
        int i=(int)Math.random()*10;
        if(i>5){
            answer=true;
        }
        return answer;
    }

    /**
     * 返回[0~size]的值
     * @param size
     * @return
     */
    public static int returnNum(int size){
        int num=0;
        Random random=new Random();
        num=random.nextInt(size);
        return num;
    }

    /**
     * 返回一个[min，max]区间中的数
     * @param min
     * @param max
     * @return
     */
    public static int returnSection(int min,int max){
        int num=0;
        Random random=new Random();
        num=random.nextInt(max-min+1);
        return num+min;
    }

    /**
     *产生0~1的随机数
     * @return
     */
    public static double returnZeroToOne(){
        double num=Math.random();
        return num;
    }
}
