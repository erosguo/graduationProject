package cn.system.utils;

import cn.system.domain.Activity;
import cn.system.domain.User;

import java.util.List;

/**
 * 活动推荐
 */
public class RecommendUtil {
    public static Boolean recommendUtil(Activity activity, String userHobby, List<User> userList){
        Boolean isRecommend =true;
        int activityType=Integer.parseInt(activity.getActivityType());
        double recommendNum=0;
        int personCount=userList.size();

        //1.计算用户兴趣相似度
        //2.同一活动，相同用户可能参与活动的几率
        //3.推荐的可能性总和归一化

        //获得兴趣爱好标签
        int item1=0;
        int item2=0;
        String[] hobby=userHobby.split(",");
        for(String s:hobby){
            if("体育健将".equals(s)){
                item1=1;
            }else if("文艺新星".equals(s)){
                item2=1;
            }
        }
        if(item1==1&&item2==1){
            //相似度
            for(User user:userList){
                double similarity=0.0;
                if(user.getUserHobby().equals("体育健将,文艺新星")){
                    similarity=1.0;
                }else{
                    similarity=0.5;
                }
                //用户参与了活动，贡献度为1
                recommendNum+=similarity*1;
            }
            //归一化
            recommendNum=recommendNum/personCount;
        }
        else if(item1==1&&item2!=1){
            //相似度
            for(User user:userList){
                double similarity=0.0;
                if(user.getUserHobby().equals("体育健将,文艺新星")){
                    similarity=0.5;
                }else{
                    //不存在就返回-1
                    if(user.getUserHobby().indexOf("体育健将")>=0) {
                        similarity=0.5;
                    }
                }
                //用户参与了活动，贡献度为1
                recommendNum+=similarity*1;
            }
            //归一化
            recommendNum=recommendNum/personCount;
        }
        else if(item1!=1&&item2==1){
            //相似度
            for(User user:userList){
                double similarity=0.0;
                if(user.getUserHobby().equals("体育健将,文艺新星")){
                    similarity=0.5;
                }else{
                    //不存在就返回-1
                    if(user.getUserHobby().indexOf("文艺新星")>=0) {
                        similarity=0.5;
                    }
                }
                //用户参与了活动，贡献度为1
                recommendNum+=similarity*1;
            }
            //归一化
            recommendNum=recommendNum/personCount;
        }
        isRecommend = recommendNum>0.5?true:false;
        return isRecommend;
    }
}
