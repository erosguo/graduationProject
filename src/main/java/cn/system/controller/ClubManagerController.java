package cn.system.controller;


import cn.system.domain.*;
import cn.system.service.*;
import cn.system.utils.ActivityUserList;
import cn.system.utils.DateUtil;
import cn.system.utils.Page;
import cn.system.utils.UserApplyActivityUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 社团管理员
 */
@Controller
@RequestMapping("/ClubManager")
public class ClubManagerController {

    @Autowired
    private ClubManagerService clubManagerService;
    @Autowired
    private ClubService clubService;
    @Autowired
    private ClubDiscussService clubDiscussService;
    @Autowired
    private UserService userService;
    @Autowired
    private BelongService belongService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ClubHoldService clubHoldService;
    @Autowired
    private JoinActivityService joinActivityService;
    /**
     * 判断是否登录成功
     * @param account
     * @param userPassword
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/judgeLogIn",method = RequestMethod.POST)
    public Map<String, Object> judgeLogIn(String account, String userPassword, HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("表现层，前端输入 clubManager "+"account:"+account+" password:"+userPassword+ new Date().getTime());

        //
        System.out.println("表现层，社团管理员登录校验"+new Date().getTime());
        ClubManager clubManager= clubManagerService.findClubManagerById(account);
        System.out.println("get clubManager:"+clubManager);

        try{
            if(clubManager!=null&&clubManager.getClubManagerPassword().equals(userPassword)){
                //
                map.put("msg", "1");
                System.out.println("表现层，登录成功");
                HttpSession session=request.getSession();
                session.setAttribute("account",clubManager.getClubManagerId());
            }

            else {
                map.put("msg","用户名或密码错误，请重新登陆！");
                System.out.println("表现层，登录失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        System.out.println("表现层，返回map");
        return map;
    }


    /**
     * 进入社团管理页
     * @return
     */
    @RequestMapping("/showClubManagerStation")
    public String showUserStation(Model model,HttpServletRequest request){
        String account=(String)request.getSession().getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);

        model.addAttribute("club",clubManager.getClub());
        return "club/clubManagerStation";
    }

    /**
     * 展示密码修改页
     * @return
     */
    @RequestMapping("/showClubManagerPasswordInfo")
    public String showClubManagerPasswordInfo(){
        return "club/clubManagerPasswordPage";
    }

    /**
     * 修改密码
     * @param userPassword1
     * @param userPassword2
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    public Map<String,Object> changePassword(String userPassword1,String userPassword2,HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求更改密码"+"Password1:"+userPassword1+" Password2:"+userPassword2+ new Date().getTime());

        //
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        System.out.println("获得社团管理员："+clubManager);

        try{
            if(clubManager!=null&&clubManager.getClubManagerPassword().equals(userPassword1)){
                System.out.println("表现层，更改密码");
                int i=clubManagerService.updateClubManagerPasswordById(account,userPassword2);
                if(i>0){
                    System.out.println("表现层，修改成功");
                    map.put("msg","1");
                    return map;
                }
                else {
                    /*System.out.println("表现层，修改失败");*/
                    map.put("msg","数据库不能成功更新");
                    return map;
                }
            }else if(!clubManager.getClubManagerPassword().equals(userPassword1)){
                map.put("msg","旧密码错误");
                return map;
            }
            else {
                map.put("msg","新密码不符合规则");
                return map;
            }

        }catch(Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     * 展示社团公告修改页
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showClubNoticePage")
    public String showClubNoticePage(Model model,HttpServletRequest request){
        //
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        model.addAttribute("club",clubManager.getClub());
        return "club/clubManagerClubNoticePage";
    }

    /**
     * 展示个人信息修改页
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showClubManagerInfo")
    public String showClubManagerInfo(Model model,HttpServletRequest request){

        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        model.addAttribute("clubManager",clubManager);
        return "club/clubManagerInfoPage";
    }

    /**
     * 修改名字
     * @param userName
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/changeName",method = RequestMethod.POST)
    public Map<String,Object> changeName(String userName,HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求改变姓名"+"userName:"+userName+ new DateUtil().returnFormatDate());

        //
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);


        try{
            if(clubManager!=null){
                System.out.println("表现层，更改姓名");
                int i=clubManagerService.updateClubManagerNameById(account,userName);
                if(i>0){
                    System.out.println("表现层，修改成功");
                    map.put("msg","1");
                    return map;
                }
                else {
                    /*System.out.println("表现层，修改失败");*/
                    map.put("msg","数据库不能成功更新");
                    return map;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     * 修改邮箱
     * @param userEmail
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/changeEmail",method = RequestMethod.POST)
    public Map<String,Object> changeEmail(String userEmail,HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求改变教师邮箱"+"userEmail:"+userEmail+ new DateUtil().returnFormatDate());

        //
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager = clubManagerService.findClubManagerById(account);


        try{
            if(clubManager!=null){
                System.out.println("表现层，更改邮箱");
                int i=clubManagerService.updateClubManagerEmailById(account,userEmail);
                if(i>0){
                    System.out.println("表现层，修改成功");
                    map.put("msg","1");
                    return map;
                }
                else {
                    System.out.println("表现层，修改失败");
                    map.put("msg","数据库不能成功更新");
                    return map;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     * 修改电话
     * @param userTel
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/changeTel",method = RequestMethod.POST)
    public Map<String,Object> changeTel(String userTel,HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求改变联系方式"+"userTel:"+userTel+ new DateUtil().returnFormatDate());

        //
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);


        try{
            if(clubManager!=null){
                System.out.println("表现层，更改教师联系手机");
                int i=clubManagerService.updateClubManagerTelById(account,userTel);
                if(i>0){
                    System.out.println("表现层，修改成功");
                    map.put("msg","1");
                    return map;
                }
                else {
                    System.out.println("表现层，修改失败");
                    map.put("msg","数据库不能成功更新");
                    return map;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     * 创建公告
     * @param clubNotice
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/changeNotice",method = RequestMethod.POST)
    public Map<String,Object> changeNotice(String clubNotice,HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求改变社团公告"+"clubNotice:"+clubNotice+ new Date().getTime());

        //
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        System.out.println("当前社团管理员及社团信息"+clubManager);
        Club club=clubManager.getClub();

        try{
            if(club!=null&&club.getClubNotice()!=null){
                System.out.println("表现层，更改公告");
                int i=clubService.updateClubNoticeById(club.getClubId(),clubNotice);
                if(i>0){
                    System.out.println("表现层，修改成功");
                    map.put("msg","1");
                    return map;
                }
                else {
                    System.out.println("表现层，修改失败");
                    map.put("msg","数据库不能成功更新");
                    return map;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }
    /*//未分页
    @RequestMapping(value = "/showClubDiscussInfo")
    public String showClubDiscussInfo(Model model,HttpServletRequest request){
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);

        List<ClubDiscuss> clubDiscussList =clubDiscussService.findClubDiscussByClubIdAll(clubManager.getClub().getClubId());
        model.addAttribute("clubDiscuss",clubDiscussList);
        return "club/clubManagerDiscussInfo";
    }*/

    /**
     * 分页展示社团讨论
     * @param page
     * @param size
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/showClubDiscussInfo")
    public ModelAndView showClubDiscussInfo(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,HttpServletRequest request)throws Exception{
        System.out.println("调用展示社团讨论页方法");
        ModelAndView mv=new ModelAndView();
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);

        List<ClubDiscuss> clubDiscussList= clubDiscussService.findClubDiscussByClubIdPageAll(clubManager.getClub().getClubId(),page,size);
        //pageinfo就是分页bean
        PageInfo pageInfo= new PageInfo(clubDiscussList);
        mv.addObject("pageInfo",pageInfo);
        /*System.out.println("pageInfo :"+pageInfo);*/
        mv.setViewName("club/clubManagerDiscussInfo");
        return mv;

    }

    @RequestMapping("/showCreateClubDiscuss")
    public String showCreateClubDiscuss(){

        return "club/clubManagerCreateClubDiscuss";
    }

    /**
     * 展示社团讨论详情页
     * @param clubDiscussId
     * @param model
     * @return
     */
    @RequestMapping("/showClubDiscussDetail")
    public String showClubDiscussDetail(int clubDiscussId,Model model){
        ClubDiscuss clubDiscuss=clubDiscussService.findClubDiscussByClubDiscussId(clubDiscussId);
        try{
            int i=clubDiscussService.updateClubDiscussClick(clubDiscussId,clubDiscuss.getClubDiscussClickNumber()+1);

        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("clubDiscuss",clubDiscuss);
        return "base/clubDiscuss";
    }

    /**
     *
     * @param clubDiscussName
     * @param clubDiscussContent
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/createClubDiscuss")
    @ResponseBody
    public Map<String,Object> createClubDiscuss(String clubDiscussName,String clubDiscussContent,HttpServletRequest request, HttpServletResponse response)throws Exception{
        System.out.println("成功调用创建社团讨论方法"+"Name:"+clubDiscussName+"content:"+clubDiscussContent);
        Map<String, Object> map = new HashMap<String, Object>();
        HttpSession session=request.getSession();
        String account=(String)session.getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        /*System.out.println("clubManager:"+clubManager);*/
        ClubDiscuss clubDiscuss =new ClubDiscuss();
        System.out.println("1.new clubDiscuss"+clubDiscuss);
        clubDiscuss.setClubDiscussName(clubDiscussName);
        clubDiscuss.setClubDiscussClickNumber(0);
        clubDiscuss.setClubId(clubManager.getClub().getClubId());
        /*System.out.println("2.new clubDiscuss"+clubDiscuss);*/
        ClubDiscuss clubDiscuss1=clubDiscussService.findClubDiscussBiggestId();
        System.out.println("clubDiscuss1:"+clubDiscuss1);
        if(clubDiscuss1==null){
            clubDiscuss.setClubDiscussId(1);
        }else{
            int num=clubDiscuss1.getClubDiscussId()+1;
            clubDiscuss.setClubDiscussId(num);
        }

        clubDiscuss.setClubDiscussContent(clubDiscussContent);
        System.out.println("clubDiscuss"+clubDiscuss);
        try{
            int i =clubDiscussService.saveClubDiscuss(clubDiscuss);
            if(i>0){
                map.put("msg","1");
            }else{
                map.put("msg","2");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println(map);
        System.out.println("createClubDiscuss 返回map");
        return map;

    }

    /**
     * 点击递增？返回的视图spring mvc未解析
     * @param clubDiscussId
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/updateClubDiscussClick")
    public String updateClubDiscussClick(int clubDiscussId,Model model) {

        ClubDiscuss clubDiscuss=clubDiscussService.findClubDiscussByClubDiscussId(clubDiscussId);

        try{
            int i=clubDiscussService.updateClubDiscussClick(clubDiscussId,clubDiscuss.getClubDiscussClickNumber()+1);

        }catch(Exception e){
            e.printStackTrace();
        }
        model.addAttribute("clubDiscuss",clubDiscuss);
        return "base/clubDiscuss";
    }

    /**
     * 评论社团讨论，社团管理员不能做。
     * @param clubDiscussId
     * @param clubDiscussComment
     * @param request
     * @param response
     * @return
     */
    /*
    @ResponseBody
    @RequestMapping(value="/addNewClubDiscussComment",method = RequestMethod.POST)
    public Map<String,Object> addNewClubDiscussComment(int clubDiscussId,String clubDiscussComment,HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();

        //只保留最新评论
        try{
            int i=clubDiscussService.updateClubDiscussComment(clubDiscussId,clubDiscussComment);
            if(i>0){
                map.put("msg","1");

            }else {
                map.put("msg","2");
            }
        }catch(Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }
*/
    /**
     * 社团用户管理
     * @param model
     * @return
     */
    @RequestMapping("/showClubManagerUserManageInfo")
    public String showClubManagerUserManageInfo(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,Model model,HttpServletRequest request){
        String account =(String)request.getSession().getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);

        List<Belong> belongList=clubManager.getClub().getBelongList();
        List<User> myUser=new ArrayList<User>();
        for(Belong belong:belongList){
            if(belong.getBelongIsEnable()==1){
                myUser.add(userService.findUserById(belong.getUserId()));
            }
        }
        Page pageList=new Page();
        //设置当前界面为第一页
        pageList.setCurrentPage(page);
        //设置每页数据
        pageList.setPageSize(size);
        //每页的开始数
        pageList.setStar((pageList.getCurrentPage() - 1) * pageList.getPageSize());
        //list的大小
        int count = myUser.size();
        //设置总页数
        pageList.setTotalPage(count % size == 0 ? count / size : count / size + 1);
        //对list进行截取
        pageList.setDataList(myUser.subList(pageList.getStar(),count-pageList.getStar()>pageList.getPageSize()?pageList.getStar()+pageList.getPageSize():count));

        model.addAttribute("pageList",pageList);
        return "club/clubManagerUserManageInfo";
    }

    /**
     * 开除学生
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(String userId,HttpServletRequest request) throws Exception{
        System.out.println("get userId:"+userId);
        String account =(String)request.getSession().getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        ModelAndView mv = new ModelAndView();
        int i=belongService.deleteBelong(userId,clubManager.getClub().getClubId());
        if(i>0){
            mv.setViewName("redirect:showClubManagerUserManageInfo?page=1&size=3");
        }
        else{
            mv.setViewName("base/tips");
            mv.addObject("tips","服务器出错，请重试");
        }
        return mv;
    }

    /**
     * 社团申请用户管理
     * @param model
     * @return
     */
    @RequestMapping("/showClubManagerUserApplyManageInfo")
    public String showClubManagerUserApplyManageInfo(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,Model model,HttpServletRequest request){
        String account =(String)request.getSession().getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);

        List<Belong> belongList=clubManager.getClub().getBelongList();
        List<User> myUser=new ArrayList<User>();
        for(Belong belong:belongList){
            if(belong.getBelongIsEnable()==0){
                myUser.add(userService.findUserById(belong.getUserId()));
            }
        }
        Page pageList=new Page();
        //设置当前界面为第一页
        pageList.setCurrentPage(page);
        //设置每页数据
        pageList.setPageSize(size);
        //每页的开始数
        pageList.setStar((pageList.getCurrentPage() - 1) * pageList.getPageSize());
        //list的大小
        int count = myUser.size();
        //设置总页数
        pageList.setTotalPage(count % size == 0 ? count / size : count / size + 1);
        //对list进行截取
        pageList.setDataList(myUser.subList(pageList.getStar(),count-pageList.getStar()>pageList.getPageSize()?pageList.getStar()+pageList.getPageSize():count));

        model.addAttribute("pageList",pageList);
        return "club/clubManagerUserApplyManageInfo";
    }

    /**
     * 通过学生申请
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/passUserApply")
    public ModelAndView passUserApply(String userId,HttpServletRequest request) throws Exception{
        String account =(String)request.getSession().getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        System.out.println("get userId:"+userId);
        ModelAndView mv = new ModelAndView();
        int i=belongService.updateBelongIsEnable(userId,clubManager.getClub().getClubId(),1);
        if(i>0){
            //重定向
            mv.setViewName("redirect:showClubManagerUserApplyManageInfo?page=1&size=3");
        }
        else{
            mv.setViewName("base/tips");
            mv.addObject("tips","服务器出错，请重试");
        }
        return mv;
    }
    /**
     * 不通过学生申请
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/rejectUserApply")
    public ModelAndView rejectUserApply(String userId,HttpServletRequest request) throws Exception{
        System.out.println("get userId:"+userId);
        String account =(String)request.getSession().getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        ModelAndView mv = new ModelAndView();
        int i=belongService.deleteBelong(userId,clubManager.getClub().getClubId());
        if(i>0){
            mv.setViewName("redirect:showClubManagerUserApplyManageInfo?page=1&size=3");
        }
        else{
            mv.setViewName("base/tips");
            mv.addObject("tips","服务器出错，请重试");
        }
        return mv;
    }

    @RequestMapping("/showCreateActivityPage")
    public String showCreateActivityPage(){
        return "club/clubManagerCreateActivity";
    }

    @RequestMapping("/createClubActivity")
    @ResponseBody
    public Map<String,Object> createClubActivity(String ActivityName,String ActivityIntroduction,
                                                 String ActivityContent,String ActivityPlace,
                                                 String ActivityJoinBeginTime,String ActivityJoinEndTime,
                                                 int ActivityJoinWay,int ActivityPersonCount,
                                                 int ActivityPersonMethod,String ActivityType,
                                                 String ActivityBeginTime,String ActivityEndTime,
                                                 HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("method:createClubActivity"+"ActivityName:"+ActivityName+
                "ActivityIntroduction:"+ActivityIntroduction+"ActivityContent:"+ActivityContent+
                "ActivityPlace:"+ActivityPlace+"ActivityJoinBeginTime:"+ActivityJoinBeginTime
                +"ActivityJoinEndTime:"+ActivityJoinEndTime+"ActivityJoinWay:"+ActivityJoinWay+
                "ActivityPersonCount:"+ActivityPersonCount+"ActivityPersonMethod:"+ActivityPersonMethod+
                "ActivityType:"+ActivityType+"ActivityBeginTime:"+ActivityBeginTime+"ActivityEndTime:"+ActivityEndTime);
        Map<String, Object> map = new HashMap<String, Object>();
        String account=(String)request.getSession().getAttribute("account");

        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        Activity newActivity=new Activity();
        Activity oldActivity=activityService.findActivityBiggestId();
        if(oldActivity!=null){
            newActivity.setActivityId(oldActivity.getActivityId()+1);
        }else{
            newActivity.setActivityId(1);
        }
        newActivity.setActivityName(ActivityName);
        newActivity.setActivityIntroduction(ActivityIntroduction);
        newActivity.setActivityContent(ActivityContent);
        newActivity.setActivityPlace(ActivityPlace);
        newActivity.setActivityPersonCount(ActivityPersonCount);
        newActivity.setActivityJoinWay(ActivityJoinWay);
        newActivity.setActivityPersonMethod(ActivityPersonMethod);
        newActivity.setActivityJoinBeginTime(ActivityJoinBeginTime);
        newActivity.setActivityJoinEndTime(ActivityJoinEndTime);
        newActivity.setActivityBeginTime(ActivityBeginTime);
        newActivity.setActivityEndTime(ActivityEndTime);
        newActivity.setActivityType(ActivityType);
        //0表示状态未知
        newActivity.setActivityState(0);

        System.out.println("new activity:"+newActivity);

        ClubHold clubHold=new ClubHold();
        clubHold.setActivityId(newActivity.getActivityId());
        clubHold.setClubId(clubManager.getClubId());

        try{
            //先创建活动
            int j=activityService.saveActivity(newActivity);
            //引入外键
            int i=clubHoldService.saveClubHold(clubHold);

            if(i>0&&j>0){
                map.put("msg","1");
            }
            else{
                if(i>0){
                    clubHoldService.deleteClubHold(clubHold);
                }else if(j>0){
                    activityService.deleteActivity(newActivity);
                }
                map.put("msg","活动创建失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return map;

    }

    @RequestMapping("/showActivityState")
    public String showActivityState(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,Model model,HttpServletRequest request){
        String account =(String)request.getSession().getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);
        Club club =clubManager.getClub();
        List<ClubHold> clubHoldList=club.getClubHoldList();
        List<Activity> activityList=new ArrayList<Activity>();
        for(ClubHold clubHold:clubHoldList){
            Activity activity=activityService.findActivityActivityById(clubHold.getActivityId());
            Date date=new Date();
            try{
                //可以直接调用Date的compareTo()方法来比较大小，compareTo()方法的返回值，
                // date1小于date2返回-1，date1大于date2返回1
                //当前时间小于活动报名开始时间
                if((date.compareTo(DateUtil.getStringDate(activity.getActivityJoinBeginTime())))==-1){
                    //1表示活动未开放报名
                    activityService.updateActivityStateById(activity.getActivityId(),1);
                    activity.setActivityState(1);
                    System.out.println(activity.getActivityId()+"活动未开放报名");
                }else {
                    //当前时间小于活动报名截至时间
                    if((date.compareTo(DateUtil.getStringDate(activity.getActivityJoinEndTime())))==-1){
                        //2表示活动正处于报名状态
                        activityService.updateActivityStateById(activity.getActivityId(),2);
                        activity.setActivityState(2);
                        System.out.println(activity.getActivityId()+"正处于报名状态");
                    }else{

                        if((date.compareTo(DateUtil.getStringDate(activity.getActivityBeginTime())))==-1){
                            //3表示活动正在进行中
                            activityService.updateActivityStateById(activity.getActivityId(),3);
                            activity.setActivityState(3);
                            System.out.println(activity.getActivityId()+"活动正在进行中");
                        }
                        else{
                            //4表示活动已经结束
                            activityService.updateActivityStateById(activity.getActivityId(),4);
                            activity.setActivityState(4);
                            System.out.println(activity.getActivityId()+"活动已经结束");
                        }
                    }
                }
            }catch (Exception e){

            }
            activityList.add(activity);
        }
        Collections.reverse(activityList);
        Page pageList=new Page(page,size,activityList);

        model.addAttribute("pageList",pageList);
        return "club/clubManagerActivityState";
    }

    @RequestMapping("/showActivityDetail")
    public String showActivityDetail(int activityId,Model model){
        Activity activity=activityService.findActivityActivityById(activityId);
        model.addAttribute("activity",activity);
        return "base/Activity";
    }
    @RequestMapping("/showUserApplyActivity")
    public String showUserApplyActivity(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,Model model,HttpServletRequest request){
        String account =(String)request.getSession().getAttribute("account");
        ClubManager clubManager=clubManagerService.findClubManagerById(account);

        List<ClubHold> clubHoldList=clubManager.getClub().getClubHoldList();
        List<UserApplyActivityUtil> userApplyActivityUtilList=new ArrayList<>();
        for(ClubHold clubHold:clubHoldList){
            Activity activity=activityService.findActivityActivityById(clubHold.getActivityId());
            List<JoinActivity> joinActivityList = activity.getJoinActivityList();
            for(JoinActivity joinActivity:joinActivityList){
                if(joinActivity.getJoinActivityIsSuccess()==0){
                    UserApplyActivityUtil userApplyActivityUtil=new UserApplyActivityUtil();
                    userApplyActivityUtil.setUser(userService.findUserById(joinActivity.getUserId()));
                    userApplyActivityUtil.setActivityState(activity.getActivityState());
                    userApplyActivityUtil.setActivityCurrentCount(joinActivityList.size());
                    userApplyActivityUtil.setActivityPersonCount(activity.getActivityPersonCount());
                    userApplyActivityUtil.setActivityId(activity.getActivityId());
                    userApplyActivityUtil.setActivityName(activity.getActivityName());
                    userApplyActivityUtilList.add(userApplyActivityUtil);

                }
            }

        }
        Page pageList =new Page(page,size,userApplyActivityUtilList);
        model.addAttribute("pageList",pageList);
        return "club/clubManagerUserApplyActivity";
    }


    @RequestMapping("/setUserJoinActivityState")
    public ModelAndView setUserJoinActivityState(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,String userId,int activityId,int state,HttpServletRequest request) throws Exception{


        ModelAndView mv = new ModelAndView();
        int i=joinActivityService.updateJoinActivity(userId,activityId,state);
        if(i>0){
            mv.setViewName("redirect:showUserApplyActivity?page="+page+"&size="+size);
        }
        else{
            mv.setViewName("base/tips");
            mv.addObject("tips","服务器出错，请重试");
        }
        return mv;
    }

    @RequestMapping("/setUserJoinActivityStateNew")
    @ResponseBody
    public String setUserJoinActivityStateNew(String userId,int activityId,int state,HttpServletRequest request) throws Exception{
        String returnNum="0";

        int i=joinActivityService.updateJoinActivity(userId,activityId,state);
        if(i>0){
            returnNum="1";
        }
        System.out.println("setUserJoinActivityStateNew:returnNum"+returnNum);
        return returnNum;
    }


    @RequestMapping("/deleteUserJoinActivity")
    public ModelAndView deleteUserJoinActivity(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,String userId,int activityId) throws Exception{
        ModelAndView mv = new ModelAndView();
        int i=joinActivityService.deleteJoinActivity(userId,activityId);
        if(i>0){
            mv.setViewName("redirect:showUserApplyActivity?page="+page+"&size="+size);
        }
        else{
            mv.setViewName("base/tips");
            mv.addObject("tips","服务器出错，请重试");
        }
        return mv;
    }

    @RequestMapping("/deleteUserJoinActivityNew")
    @ResponseBody
    public String deleteUserJoinActivityNew(String userId,int activityId,HttpServletRequest request) throws Exception{
        String returnNum="0";

        int i=joinActivityService.deleteJoinActivity(userId,activityId);
        if(i>0){
            returnNum="1";
        }
        System.out.println("deleteUserJoinActivityNew:returnNum"+returnNum);
        return returnNum;
    }

    @RequestMapping("/showActivityManage")
    public ModelAndView showActivityManage(int activityId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("base/ActivityInfo");
        Activity activity=activityService.findActivityActivityById(activityId);
        List<UserApplyActivityUtil> userApplyActivityUtilList=new ArrayList<>();
        List<JoinActivity> joinActivityList=activity.getJoinActivityList();
        for(JoinActivity joinActivity:joinActivityList){
            UserApplyActivityUtil userApplyActivityUtil=new UserApplyActivityUtil();
            userApplyActivityUtil.setUser(userService.findUserById(joinActivity.getUserId()));
            userApplyActivityUtil.setJoinState(joinActivity.getJoinActivityIsSuccess());
            userApplyActivityUtilList.add(userApplyActivityUtil);
        }
        ActivityUserList activityUserList=new ActivityUserList();
        activityUserList.setActivity(activity);
        activityUserList.setUserApplyActivityUtilList(userApplyActivityUtilList);
        mv.addObject("activityUserList",activityUserList);

        return mv;
    }

    @RequestMapping("/cancelActivity")
    public ModelAndView cancelActivity(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,int activityId,HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        //取消活动
        Activity activity=activityService.findActivityActivityById(activityId);

        //取消学生报名
        List<JoinActivity> joinActivityList=activity.getJoinActivityList();
        if(joinActivityList!=null){
            for(JoinActivity joinActivity:joinActivityList){
                joinActivityService.deleteJoinActivity(joinActivity.getUserId(),joinActivity.getActivityId());
            }
        }
        //清除社团持有
        String account =(String)request.getSession().getAttribute("account");
        int clubId=clubManagerService.findClubManagerById(account).getClubId();
        ClubHold clubHold=new ClubHold();
        clubHold.setClubId(clubId);
        clubHold.setActivityId(activityId);
        clubHoldService.deleteClubHold(clubHold);
        int i=activityService.deleteActivity(activity);
        if(i>0){
            mv.setViewName("redirect:showActivityState?page="+page+"&size="+size);
        }
        else{
            mv.setViewName("base/tips");
            mv.addObject("tips","服务器出错，请重试");
        }
        return mv;
    }


}
