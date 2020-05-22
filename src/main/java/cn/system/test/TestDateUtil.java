package cn.system.test;

import cn.system.utils.DateUtil;
import org.junit.Test;

import java.util.Date;

public class TestDateUtil {
    @Test
    public void timeCompare() throws Exception{
        Date nowDate =new Date();
        System.out.println("nowDate"+nowDate);
        System.out.println("2020-04-20 20:09:37"+ DateUtil.getStringDate("2020-04-20 20:09:37"));
        System.out.println("2020-04-20 20:09:37:"+nowDate.before(DateUtil.getStringDate("2020-04-20 20:09:37")));
        System.out.println("2020-04-25 20:09:38:"+nowDate.before(DateUtil.getStringDate("2020-04-25 20:09:38")));
    }
    @Test
    public void getNowWeek(){
        System.out.println("当前周次"+ DateUtil.returnWeekNum());
    }

    @Test
    public void testGetWeekDay() throws Exception{
        System.out.println(DateUtil.returnWeekDayNum("2020-05-08 16:43:17"));
    }
    @Test
    public void testReturnManageTime() throws Exception{
        System.out.println(DateUtil.returnWeekDayNum("2020-05-15 23:00:00"));
        String[] str= DateUtil.returnManageTime("2020-05-15 23:00:00",5,6,1);
        for(int i=0;i<2;i++){
            System.out.println(str[i]);
        }
    }
}
