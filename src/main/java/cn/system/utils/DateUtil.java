package cn.system.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 */
public class DateUtil {

    private SimpleDateFormat dateFormat;

    //
    public String returnFormatDate() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        String dateString = dateFormat.format(nowDate);
        return dateString;
    }

    /**
     * 将当前日期转化为字符串
     *
     * @return
     */
    public static String getNowDateFormat() {
        SimpleDateFormat nowDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        String dateString = nowDateFormat.format(nowDate);
        return dateString;
    }

    /**
     * 根据字符串获得标准时间
     *
     * @param date
     * @return
     */
    public static String getDateFormat(Date date) {
        SimpleDateFormat nowDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = nowDateFormat.format(date);
        return dateString;
    }

    /**
     * 根据字符串返回标准日期
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static Date getStringDate(String date) throws Exception {
        //大小写错误会导致少一年
        SimpleDateFormat nowDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return nowDateFormat.parse(date);
    }

   public static int returnWeekNum(){
       Calendar c = new GregorianCalendar();
       c.set(Calendar.YEAR, 2020);
       c.set (Calendar.MONTH, Calendar.FEBRUARY);
       c.set(Calendar.DATE, 17);//2020年2月17号,初始为0
       Calendar now = Calendar.getInstance();//现在
       //WEEK_OF_YEAR不支持跨年
       System.err.println( now.get(Calendar.WEEK_OF_YEAR) - c.get(Calendar.WEEK_OF_YEAR));
       //当前周次
       return now.get(Calendar.WEEK_OF_YEAR) - c.get(Calendar.WEEK_OF_YEAR)+1;
   }
   public static int returnWeekDayNum(String date)throws Exception{
        Date nowDate=getStringDate(date);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowDate);
        int w=calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(w<0){
            w=0;
        }
        return w;
   }
   public static String[] returnManageTime(String date,int beginWeekDayNum,int endWeekDay,int teach){
        String[] time=new String[2];
        String year=date.substring(0,4);
        String month=date.substring(5,7);
        String day=date.substring(8,10);
        //考虑跨月份
        int dayNum=Integer.parseInt(day);
        int num=endWeekDay-beginWeekDayNum;
       System.out.println("dayNum:"+dayNum);
        if(num>=0){
            dayNum+=num;
        }else{
            dayNum+=7+num;
        }
       String dayResult="";
        if(dayNum<10){
            dayResult="0"+dayNum;
        }else{
            dayResult=""+dayNum;
        }
       System.out.println(dayResult);
        String[] teachTime=new String[]{"08","10","14","16","18","20","22"};
        String strTail=":00:00";
        String teachBeginResult=teachTime[teach-1];
        String teachEndResult=teachTime[teach];
        time[0]=year+"-"+month+"-"+dayResult+" "+teachBeginResult+strTail;
        time[1]=year+"-"+month+"-"+dayResult+" "+teachEndResult+strTail;
        return time;
   }
}
