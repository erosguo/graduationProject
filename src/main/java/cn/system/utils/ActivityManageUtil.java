package cn.system.utils;

import cn.system.domain.ActivityPlace;

import java.util.*;

public class ActivityManageUtil {

    /**
     * 个体编码
     * 遗传算法的运算对象是表示个体的符号串，所以必须把变量 地点, 时间 编码为一种符号串。
     * 用十进制整数来表示。
     * 时间可分为，所以分别用6位无符号二进制整数来表示
     * 因地点的数量原则上不超过14，用二位十进制整数来表示
     * 将它们连接在一起所组成的十进制数就形成了个体的基因型
     * 表示一个可行解。
     * 例如，基因型 X＝7 6 6 所对应的表现型是：[ 时间星期6时间段6 ，活动地点编号6]
     * 基因型 X＝7 6 12 所对应的表现型是：[ 时间星期6时间段6 ，活动地点编号12]
     * 个体的表现型x和基因型X之间可通过编码和解码程序相互转换。
     */

    /**
     * 遗传算法是对群体进行的进化操作
     * 需要给其淮备一些表示起始搜索点的初始群体数据。
     * 群体规模的大小取为8，即群体由8个个体组成，每个个体可通过方法产生。
     * 将地点和地点的时间安排、创建者的空闲时间安排作为初始种群的值
     */
    /**
     * 产生初始个体
     * @param individualList
     * @param activityPlaceHashMap
     * @param weekDayNum
     */
    public static void createIndividualList(List<String> individualList,Map<String, ActivityPlace>activityPlaceHashMap,int weekDayNum,int[][][] c){
        //产生初始个体
        Set<String> keySet = activityPlaceHashMap.keySet();
        int placeSize=keySet.size();
        for (String key : keySet) {
            //地点时间安排作为初始个体
            ActivityPlace activityPlace = activityPlaceHashMap.get(key);
            /*System.out.println(key);*/
            String individual=""+activityPlace.getActivityPlaceWeekDay()+activityPlace.getActivityPlaceTeach()+key;
            /*System.out.println("createIndividualList:"+individual);*/
            individualList.add(individual);
            placeSize--;
            if(placeSize<=0){
                break;
            }
        }

        if(individualList.size()<8){
            for(int i=individualList.size()-1;i<8;i++){
                //创建者空闲时间作为初始个体
                int weekdayNumber=RandomUtil.returnSection(weekDayNum,7);
                int teachNumber=RandomUtil.returnSection(0,6);
                while (c[0][weekdayNumber][teachNumber]==1){
                    teachNumber=RandomUtil.returnSection(0,6);
                    weekdayNumber=RandomUtil.returnSection(weekDayNum,7);
                }
                String individual=""+ weekdayNumber+ teachNumber+RandomUtil.returnNum(keySet.size());
                /*System.out.println("createIndividualList"+individual);*/
                individualList.add(individual);
            }
        }

    }
    /**
     * 遗传算法中以个体适应度的大小来评定各个个体的优劣程度，从而决定其遗传机会的大小。
     * 故适应度有安排表的时间填充完成，填充的学生人数占比越高，个体适应度越高
     */
    /**
     * 适应度计算
     * @param individualZero
     * @param c
     * @param p
     * @return
     */
    public static double fitnessCalculation(String individualZero,int[][][] c, int[][][]p)throws Exception{
        double fitness=0.0;
        String individual=individualZero;
        char cWeekDayResult=individual.charAt(0);
        int weekDayResult=cWeekDayResult-'0';
        char cTeachResult=individual.charAt(1);
        int teachResult=cTeachResult-'0';
        String cPlaceId=individual.substring(2);
        /*System.out.println("fitnessCalculation:cPlaceId:"+cPlaceId);*/
        int placeId=Integer.parseInt(cPlaceId);
        /*System.out.println("fitnessCalculation:individual:"+individualZero);
        System.out.println("fitnessCalculation:PlaceId:"+PlaceId);
        System.out.println("weekDayResult"+weekDayResult+"teachResult"+teachResult+"PlaceId"+placeId);
        int userSize=0;*/

        try {
            //地点适应
            if(p[placeId-1][weekDayResult][teachResult]==1){
                double total=(double) c.length;
                double userCount=0.0;
                //计算人数
                for(int i=0;i<total;i++){
                    //
                    if(c[i][weekDayResult][teachResult]==0){
                        userCount++;
                    }
                }
                fitness=userCount/total;
            }else{
                fitness=0.0;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            /*e.printStackTrace();*/
        }

        return fitness;
    }

    /**
     * 选择运算(或称为复制运算)把当前群体中适应度较高的个体按某种规则或模型遗传到下一代群体中。
     * 一般要求适应度较高的个体将有更多的机会遗传到下一代群体中。                   
     * 我们采用与适应度成正比的概率来确定各个个体复制到下一代群体中的数量。
     * 其具体操作过程是：
     * 先计算出群体中所有个体的适应度的总和  fi  ( i=1.2,…,M );
     * 其次计算出每个个体的相对适应度的大小 fi / fi ，它即为每个个体被遗传到下一代群体中的概率，
     *每个概率值组成一个区域，全部概率值之和为1；
     *最后再产生一个0到1之间的随机数，依据该随机数出现在上述哪一个概率区域内来确定各个个体被选中的次数。
     */
    public static String selectGeneration(List<String> individualList,double[] fitnessList)throws Exception{
        //选择概率
        double[] adaptiveProbability =new double[8];
        //累计概率
        double totalProbability=0.0;
        //随机概率
        double randomProbability=RandomUtil.returnZeroToOne();


        for(int i=0;i<8;i++){
            adaptiveProbability[i]=fitnessList[i]/totalProbability;
            totalProbability+=adaptiveProbability[i];
            if(totalProbability>=randomProbability){
                return individualList.get(i);
            }
        }
        return individualList.get(0);
    }

    /**
     * 交叉运算是遗传算法中产生新个体的主要操作过程，它以某一概率相互交换某
     *     两个个体之间的部分染色体。
     *        本例采用单点交叉的方法，其具体操作过程是：
     *        • 先对群体进行配对；
     *        • 其次设置交叉点位置；
     *        • 最后再相互交换配对染色体之间的部分基因。
     */
    /**
     * 交叉操作 交叉率为60%，平均为60%的染色体进行交叉
     * @param chrNum
     * @param generationList
     */
    public static void crossOperation(int chrNum,List<String>generationList){
        String temp1, temp2;
        for (int i = 0; i < chrNum; i++) {
            if (RandomUtil.returnZeroToOne() < 0.60) {
                int pos = 2;     //pos位点,交换时间安排和地点安排
                temp1 = generationList.get(i).substring(0, pos) + generationList.get((i + 1) % chrNum).substring(pos);
                temp2 = generationList.get((i + 1) % chrNum).substring(0, pos) + generationList.get(i).substring(pos);
                generationList.set(i,temp1);
                generationList.set(i+1/ chrNum,temp2);
            }
        }
    }

    /**
     * 变异运算是对个体的某一个或某一些基因座上的基因值按某一较小的概率进行改变
     * 是产生新个体的一种操作方法。
     * 对时间或者地点进行变异
     */
    /**
     * 基因突变操作 1%基因变异
     */
    public static void mutationOperation(int placeSize,int chrNum,List<String>generationList){

        for(int i=0;i<chrNum;i++){
            //变异
            if(RandomUtil.returnZeroToOne()<0.1){
                //记录下变异后的染色体
                String weekday=generationList.get(i).substring(0, 1);
                String teach=generationList.get(i).substring(1,2);
                String placeId=generationList.get(i).substring(2);
                int num=RandomUtil.returnNum(3);
                if(num==1){
                    weekday=""+RandomUtil.returnNum(7);
                }else if(num==2){
                    teach=""+RandomUtil.returnNum(6);
                }
                else{
                    placeId=""+RandomUtil.returnNum(placeSize);
                }
                String temp=weekday+teach+placeId;

                generationList.set(i,temp);
            }

        }
    }

    public static String comparePlaceSoftConstraint(String individual1,String individual2){
        char cTeachResult1=individual1.charAt(1);
        int teachResult1=cTeachResult1-'0';
        char cTeachResult2=individual2.charAt(1);
        int teachResult2=cTeachResult2-'0';
        String str=(teachResult1<teachResult2)?individual1:individual2;
        return str;
    }

    public static String manageActivity(int[][][] c, int[][][]p, Map<String, ActivityPlace> activityPlaceHashMap, int weekDayNum)throws Exception{
        String answer="";//输出的个体
        int chrNum=8;//种群数量
        List<String> individualList=new ArrayList<>();//种群
        List<String> generationList=new ArrayList<>();//轮盘选择后的种群
        String bestGenerations="";//最好的染色体
        int generation = 0; 	//个体代号
        Set<String> keySet = activityPlaceHashMap.keySet();
        int placeSize=keySet.size();//地点编号
        double[] fitnessList=new double[8];//个体适应度
        /**
         * 步骤
         * 遗传算法采用类似基因演化的循环过程，其演算过程如下：
         *     1）随机产生一定数目的初始种群
         *     2）对个体适应度进行评估，如果个体的适应度符合优化准则，则输出最佳个体及其代表的最优解，并结束计算，否则转向第3步。
         *     3）依据适应度选择再生个体
         *     4）按照一定的交叉概率和交叉方法生成新的个体
         *     5）按照一定的变异概率和变异方法生成新的个体
         *     6）由交叉和变异产生新一代的种群，然后返回第2步。
         */

        //产生初始种群
        createIndividualList(individualList,activityPlaceHashMap,weekDayNum,c);

        //迭代次数
        int iterations=0;
        bestGenerations=individualList.get(0);
        double oldfitness=0.0;
        while (fitnessList[generation]<1){
            //统计适应度
            for(int i=0;i<8;i++){
                //解码计算个体适应度
                String individual=individualList.get(i);
                System.out.println("individual"+i+":"+individual);
                fitnessList[i]=fitnessCalculation(individual,c, p);
                if(fitnessList[i]>oldfitness){
                    //获取当代最高适应度
                    if(i>=1&&fitnessList[i]>fitnessList[i-1]){
                        generation=i;
                        bestGenerations=individualList.get(i);
                    }else if(i>=1&&fitnessList[i]==fitnessList[i-1]){//比较软约束，活动地点的时间安排
                        bestGenerations=comparePlaceSoftConstraint(bestGenerations,individualList.get(i));
                        if(bestGenerations.equals(individualList.get(i))){
                            generation=i;
                        }
                    }
                }

                //满足最优解,不再需要进行遗传运行
                if(fitnessList[i]==1){
                    answer=bestGenerations;
                    System.out.println("迭代次数："+iterations+"基因型："+answer);
                    return answer;
                }
            }
            oldfitness=fitnessList[generation];
            //产生下一代
            for(int i=0;i<chrNum;i++){
                generationList.add(selectGeneration(individualList,fitnessList));
            }
            //交叉运算
            crossOperation(chrNum,generationList);
            //变异运算
            mutationOperation(placeSize,chrNum,generationList);
            //
            individualList.clear();
            individualList.addAll(generationList);
            generationList.clear();
            iterations++;
            if(iterations>6){
                answer=bestGenerations;
                break;
            }
        }

        //
        System.out.println("迭代次数："+iterations+"基因型："+answer);
        return answer;
    }
}
