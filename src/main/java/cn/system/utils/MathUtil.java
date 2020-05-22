package cn.system.utils;

public class MathUtil {
    public static double sum(double[] list){
        double num=0.0;
        for(int i=0;i<list.length;i++){
            num+=list[i];
        }
        return num;
    }
}
