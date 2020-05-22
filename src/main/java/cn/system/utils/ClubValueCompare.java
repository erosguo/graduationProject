package cn.system.utils;

import cn.system.domain.Club;

import java.util.Comparator;

public class ClubValueCompare implements Comparator<Club> {

    //对社团进行评分
    public int calculatedValue(Object o){
        int value=0;
        //类型转化
        Club club=(Club)o;
        int memberNum=1;
        if(club.getBelongList().size()!=0)
        {
            memberNum=club.getBelongList().size();
        }
        int discussNum=1;
        if(club.getClubDiscusses().size()!=0){
            discussNum=club.getClubDiscusses().size();
        }
        int activityNum=1;
        if(club.getClubHoldList().size()!=0){
            activityNum=club.getClubHoldList().size();
        }
        int total=memberNum+activityNum+discussNum;
        //活动权重
        double w1=0.2+0.4*(activityNum/total);
        //讨论权重
        double w2=0.2+0.4*(discussNum/total);
        //成员权重
        double w3=0.2+0.4*(memberNum/total);
        //加权平均
        value=(int)((activityNum*w1+discussNum*w2+memberNum*w3)/(w1+w2+w3));
        System.out.println("社团"+club.getClubId()+"评分："+value);
        return value;
    }

    @Override
    public int compare(Club o1, Club o2) {
        int num1=calculatedValue(o1);
        int num2=calculatedValue(o2);
        //应当设置为降序排列
        return num2-num1;
    }

}
