package cn.system.controller;

import cn.system.domain.*;
import cn.system.service.*;

import cn.system.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 用户
 */
@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BelongService belongService;
    @Autowired
    private ClubService clubService;
    @Autowired
    private JoinDiscussService joinDiscussService;
    @Autowired
    private ClubDiscussService clubDiscussService;
    @Autowired
    private UserRelationShipService userRelationShipService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private JoinActivityService joinActivityService;
    @Autowired
    private SelectService selectService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private PersonHoldService personHoldService;
    @Autowired
    private ActivityPlaceService activityPlaceService;

    /**
     * 进入用户工作台
     * @return
     */
    @RequestMapping("/showUserStation")
    public String showUserStation(HttpServletRequest request) {
        String account=(String)request.getSession().getAttribute("account");
        User user=userService.findUserById(account);
        if(user.getUserHobby()==null){
            return "user/userCheckHobby";
        }
        return "user/userStation";
    }

    /**
     * 新注册用户添加兴趣爱好
     * @param IsSports
     * @param IsLiterature
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/addHobby", method = RequestMethod.POST)
    public Map<String, Object> addHobby(Boolean IsSports, Boolean IsLiterature, HttpServletRequest request, HttpServletResponse response)throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("method addHobby:"+"IsSports:"+IsSports+"IsLiterature:"+IsLiterature);
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        User user = userService.findUserById(account);
        System.out.println("获得用户：" + user);

        try {
            if (user != null) {
                String hobby="";
                if(IsSports){
                    hobby=hobby+"体育健将";
                    if(IsLiterature){
                        hobby=hobby+",文艺新星";
                    }
                }else{
                    if (IsLiterature){
                        hobby=hobby+"文艺新星";
                    }
                }
                int i = userService.updateUserHobbyById(account, hobby);
                if (i > 0) {
                    map.put("msg", "1");
                } else {
                    System.out.println("表现层，修改失败");
                    map.put("msg", "数据库不能成功更新");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        System.out.println("表现层，返回map"+map);
        return map;
    }

    /**
     * 展示密码修改页
     * @return
     */
    @RequestMapping("/showPasswordPage")
    public String showPasswordPage() {
        return "user/userPasswordPage";
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
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public Map<String, Object> changePassword(String userPassword1, String userPassword2, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求更改密码" + "userPassword1:" + userPassword1 + " userPassword2:" + userPassword2 + new Date().getTime());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        User user = userService.findUserById(account);
        System.out.println("获得用户：" + user);

        try {
            if (user != null && user.getUserPassword().equals(userPassword1)) {
                System.out.println("表现层，更改密码");
                int i = userService.updateUserPasswordById(account, userPassword2);
                if (i > 0) {
                    System.out.println("表现层，修改成功");
                    map.put("msg", "1");
                    return map;
                } else {
                    System.out.println("表现层，修改失败");
                    map.put("msg", "数据库不能成功更新");
                    return map;
                }
            } else if (!user.getUserPassword().equals(userPassword1)) {
                map.put("msg", "旧密码错误");
                return map;
            } else {
                map.put("msg", "新密码不符合规则");
                return map;
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }


    /**
     * 用户可更改的信息列表
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showUserInfoPage")
    public String showUserInfoPage(Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");
        User user = userService.findUserById(account);
        model.addAttribute("user", user);
        return "user/userInfoPage";
    }

    /**
     * 修改名字
     * @param userName
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeName", method = RequestMethod.POST)
    public Map<String, Object> changeName(String userName, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求更改名字" + "userName:" + userName + new Date().getTime());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        User user = userService.findUserById(account);
        System.out.println("获得用户：" + user);

        try {
            if (user != null) {
                System.out.println("表现层，更改名字");
                int i = userService.updateUserNameById(account, userName);
                if (i > 0) {
                    System.out.println("表现层，修改成功");
                    map.put("msg", "1");
                    return map;
                } else {
                    System.out.println("表现层，修改失败");
                    map.put("msg", "数据库不能成功更新");
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;

    }

    /**
     * 修改简介
     * @param userIntroduction
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeIntroduction", method = RequestMethod.POST)
    public Map<String, Object> changeIntroduction(String userIntroduction, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求更改简介" + "userIntroduction:" + userIntroduction + new Date().getTime());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        User user = userService.findUserById(account);
        System.out.println("获得用户：" + user);

        try {
            if (user != null) {
                System.out.println("表现层，更改简介");
                int i = userService.updateUserIntroductionById(account, userIntroduction);
                if (i > 0) {
                    System.out.println("表现层，修改成功");
                    map.put("msg", "1");
                    return map;
                } else {
                    System.out.println("表现层，修改失败");
                    map.put("msg", "数据库不能成功更新");
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     * 修改联系方式
     * @param userTel
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeTel", method = RequestMethod.POST)
    public Map<String, Object> changeTel(String userTel, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求更改手机" + "userTel:" + userTel + new Date().getTime());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        User user = userService.findUserById(account);
        System.out.println("获得用户：" + user);

        try {
            if (user != null) {
                System.out.println("表现层，更改手机");
                int i = userService.updateUserTelById(account, userTel);
                if (i > 0) {
                    System.out.println("表现层，修改成功");
                    map.put("msg", "1");
                    return map;
                } else {
                    System.out.println("表现层，修改失败");
                    map.put("msg", "数据库不能成功更新");
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     * 修改邮件地址
     * @param userEmail
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeEmail", method = RequestMethod.POST)
    public Map<String, Object> changeEmail(String userEmail, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求更改邮箱" + "userEmail:" + userEmail + new Date().getTime());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        User user = userService.findUserById(account);
        System.out.println("获得用户：" + user);

        try {
            if (user != null) {
                System.out.println("表现层，更改邮箱");
                int i = userService.updateUserEmailById(account, userEmail);
                if (i > 0) {
                    System.out.println("表现层，修改成功");
                    map.put("msg", "1");
                    return map;
                } else {
                    System.out.println("表现层，修改失败");
                    map.put("msg", "数据库不能成功更新");
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }


    /**
     * 修改兴趣爱好，目前从前端不可修改兴趣爱好
     * @param userHobby
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeHobby", method = RequestMethod.POST)
    public Map<String, Object> changeHobby(String userHobby, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端请求改变用户兴趣爱好" + "userHobby:" + userHobby + new Date().getTime());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        User user = userService.findUserById(account);
        System.out.println("获得用户：" + user);

        try {
            if (user != null) {
                System.out.println("表现层，更改用户兴趣爱好");
                int i = userService.updateUserHobbyById(account, userHobby);
                if (i > 0) {
                    System.out.println("表现层，修改成功");
                    map.put("msg", "1");
                    return map;
                } else {
                    System.out.println("表现层，修改失败");
                    map.put("msg", "数据库不能成功更新");
                    return map;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }


    /**
     * 用户申请加入社团
     * @param clubId
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/userApplyClub")
    public String userApplyClub(int clubId, Model model, HttpServletRequest request) throws Exception {

        String account = (String) request.getSession().getAttribute("account");
        Belong oldBelong=belongService.findUBelongByUserId(account,clubId);

        if(oldBelong!=null){
            model.addAttribute("tips", "你已经申请过了，请不要重复申请");
        }
        else{
            Belong belong = new Belong();
            belong.setClubId(clubId);
            belong.setUserId(account);
            belong.setBelongIsEnable(0);

            int i = belongService.saveBelong(belong);
            if (i > 0) {
                model.addAttribute("tips", "申请成功，请等待管理员审核");
            } else {
                model.addAttribute("tips", "申请失败，请重新申请");
            }
        }

        return "base/tips";
    }

    /**
     * 热门的社团列表
     * @param model
     * @return
     */
    @RequestMapping("/hotClub")
    public String findHotClub(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size,Model model) {
        //查找所有有效社团
        List<Club> clubAll = clubService.findClubValidAll();

        //根据社团评分进行排序
        Collections.sort(clubAll,new ClubValueCompare());
        Page pageList=new Page(page,size,clubAll);
        model.addAttribute("pageList", pageList);
        return "user/userHotClubInfo";
    }

    /**
     * 用户加入的社团列表
     * @param model
     * @return
     */
    @RequestMapping("/findMyClub")
    public String findMyClub(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");
        User user = userService.findUserById(account);
        List<Belong> belongList = user.getBelongList();
        List<Club> myclub = new ArrayList<Club>();
        for (Belong belong : belongList) {
            if (belong.getBelongIsEnable() == 1) {
                myclub.add(clubService.findClubById(belong.getClubId()));
            }
        }
        Page pageList = new Page();
        //设置当前界面为第一页
        pageList.setCurrentPage(page);
        //设置每页数据
        pageList.setPageSize(size);
        //每页的开始数
        pageList.setStar((pageList.getCurrentPage() - 1) * pageList.getPageSize());
        //list的大小
        int count = myclub.size();
        //设置总页数
        pageList.setTotalPage(count % size == 0 ? count / size : count / size + 1);
        //对list进行截取
        pageList.setDataList(myclub.subList(pageList.getStar(), count - pageList.getStar() > pageList.getPageSize() ? pageList.getStar() + pageList.getPageSize() : count));

        model.addAttribute("pageList", pageList);
        return "user/userMyJoinedClub";
    }

    /**
     * 退出社团
     * @param clubId
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/quitMyClub")
    public String quitMyClub(int clubId, Model model, HttpServletRequest request) throws Exception {
        String account = (String) request.getSession().getAttribute("account");
        int i = belongService.deleteBelong(account, clubId);
        if (i > 0) {
            /*//调用其他方法,逻辑错误，要重定向
            return this.findMyClub(model,request);*/
            model.addAttribute("tips", "退出成功");
        } else {
            model.addAttribute("tips", "服务器出错，请重新操作");
        }
        return "base/tips";
    }

    /**
     * 用户查看社团详情页
     * @param clubId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findClubDetail")
    public String findClubDetail(int clubId, Model model) throws Exception {
        Club club = clubService.findClubById(clubId);
        System.out.println("get club:" + club);
        model.addAttribute("club", club);
        return "base/club";
    }

    /**
     * 社团讨论展示
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showClubDiscussInfo")
    public String showClubDiscussInfo(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        System.out.println("method:showClubDiscussInfo");
        String account = (String) request.getSession().getAttribute("account");
        User user = userService.findUserById(account);

        List<Belong> belongList = user.getBelongList();
        System.out.println("belonglist:" + belongList);
        List<ClubDiscuss> clubDiscussList = new ArrayList<ClubDiscuss>();

        //将加入的社团的讨论全部展示
        for (Belong belong : belongList) {
            int i = belong.getClubId();
            List<ClubDiscuss> clubDiscusses = clubDiscussService.findClubDiscussByClubIdAll(i);
            for (ClubDiscuss clubDiscuss : clubDiscusses) {
                clubDiscussList.add(clubDiscuss);
            }
        }
        System.out.println("showClubDiscussInfo:" + clubDiscussList);
        Page pageList = new Page();
        //设置当前界面为第一页
        pageList.setCurrentPage(page);
        //设置每页数据
        pageList.setPageSize(size);
        //每页的开始数
        pageList.setStar((pageList.getCurrentPage() - 1) * pageList.getPageSize());
        //list的大小
        int count = clubDiscussList.size();
        //设置总页数
        pageList.setTotalPage(count % size == 0 ? count / size : count / size + 1);
        //对list进行截取
        pageList.setDataList(clubDiscussList.subList(pageList.getStar(), count - pageList.getStar() > pageList.getPageSize() ? pageList.getStar() + pageList.getPageSize() : count));
        System.out.println("pagelist" + pageList.getDataList());
        model.addAttribute("pageList", pageList);
        return "user/userClubDiscussInfo";
    }


    /**
     * 个人参与社团讨论管理
     *
     * @param model
     * @return
     */
    @RequestMapping("/showMyClubDiscussInfo")
    public String showMyClubDiscussInfo(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        System.out.println("method:showMyClubDiscussInfo");
        String account = (String) request.getSession().getAttribute("account");
        User user = userService.findUserById(account);

        //参与的社团讨论展示
        List<JoinDiscuss> joinDiscussList = user.getJoinDiscussList();
        System.out.println("JoinDiscuss:" + joinDiscussList);
        List<ClubDiscuss> clubDiscussList = new ArrayList<ClubDiscuss>();

        for (JoinDiscuss joinDiscuss : joinDiscussList) {
            clubDiscussList.add(clubDiscussService.findClubDiscussByClubDiscussId(joinDiscuss.getClubDiscussId()));
        }
        System.out.println("showMyClubDiscussInfo:" + clubDiscussList);
        Page pageList = new Page();
        //设置当前界面为第一页
        pageList.setCurrentPage(page);
        //设置每页数据
        pageList.setPageSize(size);
        //每页的开始数
        pageList.setStar((pageList.getCurrentPage() - 1) * pageList.getPageSize());
        //list的大小
        int count = clubDiscussList.size();
        //设置总页数
        pageList.setTotalPage(count % size == 0 ? count / size : count / size + 1);
        //对list进行截取
        pageList.setDataList(clubDiscussList.subList(pageList.getStar(), count - pageList.getStar() > pageList.getPageSize() ? pageList.getStar() + pageList.getPageSize() : count));

        model.addAttribute("pageList", pageList);

        return "user/userMyClubDiscussInfo";
    }

    /**
     * 展示社团讨论详情页
     *
     * @param clubDiscussId
     * @param model
     * @return
     */
    @RequestMapping("/showClubDiscussDetail")
    public String showClubDiscussDetail(int clubDiscussId, Model model) {
        ClubDiscuss clubDiscuss = clubDiscussService.findClubDiscussByClubDiscussId(clubDiscussId);
        try {
            int i = clubDiscussService.updateClubDiscussClick(clubDiscussId, clubDiscuss.getClubDiscussClickNumber() + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("clubDiscuss", clubDiscuss);
        return "base/clubDiscuss";
    }

    /**
     * 参与并评论
     *
     * @param clubDiscussId
     * @param clubDiscussComment
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addNewClubDiscussComment", method = RequestMethod.POST)
    public Map<String, Object> addNewClubDiscussComment(int clubDiscussId, String clubDiscussComment, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        String account = (String) request.getSession().getAttribute("account");

        //只保留最新评论
        try {

            if (joinDiscussService.findJoinDiscussById(account, clubDiscussId) != null) {
                map.put("msg", "不要重复评论");
            } else {
                int i = clubDiscussService.updateClubDiscussComment(clubDiscussId, "用户"+account+"评论:"+clubDiscussComment);
                JoinDiscuss joinDiscuss = new JoinDiscuss();
                joinDiscuss.setUserId(account);
                joinDiscuss.setClubDiscussId(clubDiscussId);
                //不能重复评论
                int j = joinDiscussService.saveJoinDiscuss(joinDiscuss);
                if (i > 0 && j > 0) {
                    map.put("msg", "1");

                } else {
                    map.put("msg", "2");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }


    /**
     * 判断用户是否能成功登录
     *
     * @param account
     * @param userPassword
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/judgeLogIn", method = RequestMethod.POST)
    public Map<String, Object> judgeLogIn(String account, String userPassword, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("表现层，前端输入 user " + "account:" + account + " password:" + userPassword + new Date().getTime());

        //
        System.out.println("表现层，用户登录校验" + new Date().getTime());
        User user = userService.findUserById(account);
        System.out.println("get user:" + user + "IsUser" + user.getUserIsEnable());

        try {
            if (user != null && user.getUserPassword().equals(userPassword) && user.getUserIsEnable() == 1) {
                //
                map.put("msg", "1");
                System.out.println("表现层，登录成功");
                HttpSession session = request.getSession();
                session.setAttribute("account", user.getUserId());
            } else if (user.getUserIsEnable() != 1) {
                map.put("msg", "2");
                System.out.println("表现层，登录失败");
            } else {
                map.put("msg", "用户名或密码错误，请重新登陆！");
                System.out.println("表现层，登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        System.out.println("表现层，返回map");
        return map;
    }


    /**
     * 返回错误提示
     * @param model
     * @return
     */
    @RequestMapping("/showErrorTips")
    public String showErrorTips(Model model) {
        model.addAttribute("tips", "服务器出错了");
        return "base/tips";
    }

    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/setUserEnable")
    public ModelAndView passUserApplySystem(String userId) throws Exception {
        System.out.println("get userId:" + userId);
        ModelAndView mv = new ModelAndView();
        int i = userService.updateIsEnableById(userId, 1);
        if (i > 0) {
            List<User> user = userService.findInvalidUserAll();
            mv.setViewName("systemManager/systemManagerUserApply");
            mv.addObject("user", user);
        } else {
            mv.setViewName("base/tips");
            mv.addObject("tips", "服务器出错，请重试");
        }
        return mv;
    }

    /**
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/deleteUser")
    public ModelAndView deleteUser(String userId) throws Exception {
        System.out.println("get userId:" + userId);
        ModelAndView mv = new ModelAndView();
        int i = userService.deleteUserById(userId);
        if (i > 0) {
            List<User> user = userService.findInvalidUserAll();
            mv.setViewName("systemManager/systemManagerUserApply");
            mv.addObject("user", user);
        } else {
            mv.setViewName("base/tips");
            mv.addObject("tips", "服务器出错，请重试");
        }

        return mv;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/showCreateActivity")
    public String showCreateActivity() {
        return "user/userCreateNormalActivityPage";
    }

    /**
     *
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showMyFriendList")
    public String showMyFriendList(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");

        List<UserRelationShip> userRelationShipList = userRelationShipService.findUserRelationShipAllByRelationshipUserId(account);
        List<User> myfriend = new ArrayList<User>();
        for (UserRelationShip relationShip : userRelationShipList) {
            myfriend.add(userService.findUserById(relationShip.getRelationshipFriendId()));
        }
        Page pageList = new Page(page, size, myfriend);

        model.addAttribute("pageList", pageList);
        return "user/userFriendList";
    }

    /**
     *
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showMyCourse")
    public String showMyCourse(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");
        User user=userService.findUserById(account);
        List<Select> selectList =user.getSelectList();
        List<Course> courseList=new ArrayList<>();
        for(Select select:selectList){
            courseList.add(courseService.findCourseById(select.getCourseId(),select.getCourseTeachId()));
        }
        Page pageList = new Page(page, size, courseList);

        model.addAttribute("pageList", pageList);
        return "user/userCourseTablePage";
    }


    /**
     *添加好友
     * @param friendId
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addNewFriend", method = RequestMethod.POST)
    public Map<String, Object> addNewFriend(String friendId, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        String account = (String) request.getSession().getAttribute("account");
        User friend = userService.findUserById(friendId);
        if (friend == null) {
            map.put("msg", "不存在用户" + friendId);
            return map;
        }
        if (account.equals(friendId)) {
            map.put("msg", "不要添加自己为好友");
            return map;
        }
        try {
            UserRelationShip newUserRelationShip = new UserRelationShip();
            newUserRelationShip.setRelationshipUserId(account);
            newUserRelationShip.setRelationshipFriendId(friendId);
            int i = userRelationShipService.saveUserRelationShip(newUserRelationShip);
            if (i > 0) {
                map.put("msg", "1");
            } else {
                map.put("msg", "2");
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     *
     * @param friendId
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteFriend")
    public ModelAndView deleteFriend(String friendId, HttpServletRequest request, HttpServletResponse response) {

        String account = (String) request.getSession().getAttribute("account");

        System.out.println("method:deleteFriend");
        ModelAndView mv = new ModelAndView();
        try {
            UserRelationShip newUserRelationShip = new UserRelationShip();
            newUserRelationShip.setRelationshipUserId(account);
            newUserRelationShip.setRelationshipFriendId(friendId);
            int i = userRelationShipService.deleteUserRelationShip(newUserRelationShip);
            if (i > 0) {
                mv.setViewName("redirect:showMyFriendList?page=1&size=3");
            } else {
                mv.setViewName("base/tips");
                mv.addObject("tips", "服务器出错，请重试");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return mv;
    }

    /**
     *
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showMessageList")
    public String showMessageList(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");

        List<Message> messageList = messageService.findSystemMessageByUserId(account);

        Page pageList = new Page(page, size, messageList);

        model.addAttribute("pageList", pageList);
        return "user/userMyMessageInfo";
    }

    /**
     *
     * @param userId
     * @param MessageContent
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addNewMessage", method = RequestMethod.POST)
    public Map<String, Object> addNewMessage(String userId, String MessageContent, HttpServletRequest request) {
        System.out.println("user id:" + userId + "message Content:" + MessageContent);
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Message message = new Message();
            Message lastMessage = messageService.findMessageBiggestId();
            if (lastMessage == null) {
                message.setMessageId(1);
            } else {
                message.setMessageId(lastMessage.getMessageId() + 1);
            }
            String account = (String) request.getSession().getAttribute("account");
            message.setMessageContent(MessageContent);
            //1表示来自好友
            message.setMessageType(1);
            message.setUserId(userId);
            message.setMessageFrom(account);
            System.out.println("message:" + message);
            int i = messageService.saveMessage(message);
            if (i > 0) {
                map.put("msg", "1");
            } else {
                map.put("msg", "2");
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     *删除消息
     * @param messageId
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteMessage")
    public ModelAndView deleteMessage(int messageId, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new ModelAndView();
        try {
            int i = messageService.deleteMessage(messageId);
            if (i > 0) {
                mv.setViewName("redirect:showMessageList?page=1&size=3");
            } else {
                mv.setViewName("base/tips");
                mv.addObject("tips", "服务器出错，请重试");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return mv;
    }

    /**
     *
     * @return
     */
    @RequestMapping("/showCreateNormalActivity")
    public String showCreateNormalActivity() {
        return "user/userCreateNormalActivityPage";
    }

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/showCreateMyActivity")
    public String showCreateMyActivity(HttpServletRequest request,Model model) {
        System.out.println("method:showCreateMyActivity");
        String account=(String) request.getSession().getAttribute("account");
        List<UserRelationShip> userRelationShipList=userRelationShipService.findUserRelationShipAllByRelationshipUserId(account);
        model.addAttribute("friendList",userRelationShipList);
        System.out.println(userRelationShipList);
        return "user/userCreateManageActivityPage";
    }

    /**
     * 报名活动
     * @param activityId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/signInActivity")
    @ResponseBody
    public Map<String, Object> signInActivity(int activityId, HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> map = new HashMap<String, Object>();
        String account = (String) request.getSession().getAttribute("account");

        JoinActivity joinActivity = new JoinActivity();
        Activity activity = activityService.findActivityActivityById(activityId);
        joinActivity.setActivityId(activityId);
        joinActivity.setUserId(account);
        //开放报名
        if (activity.getActivityJoinWay() == 1) {
            joinActivity.setJoinActivityIsSuccess(1);

        } else {//审核报名
            joinActivity.setJoinActivityIsSuccess(0);
        }
        int i = 0;//插入关系成功与否
        //报名人数
        int num = activity.getJoinActivityList().size();
        //先到先得
        if (activity.getActivityPersonMethod() == 1) {
            //直接插入
            if (num < activity.getActivityPersonCount()) {
                i = joinActivityService.saveJoinActivity(joinActivity);
                if (i > 0) {
                    map.put("msg", "1");
                } else {
                    map.put("msg", "系统报名失败");
                }
            } else {
                map.put("msg", "人数已满");
            }

        } else {//抽签报名
            RandomUtil randomUtil = new RandomUtil();
            if(num < activity.getActivityPersonCount()){
                if (randomUtil.returnBool()) {
                    map.put("msg", "抽签报名失败");
                } else {
                    i = joinActivityService.saveJoinActivity(joinActivity);
                    if (i > 0) {
                        map.put("msg", "1");
                    } else {
                        map.put("msg", "系统报名失败");
                    }

                }
            }

        }


        System.out.println("表现层，signInActivity 返回map");
        return map;
    }

    /**
     *
     * @param activityId
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/cancelSignInActivity")
    @ResponseBody
    public Map<String, Object> cancelSignInActivity(int activityId, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        String account = (String) request.getSession().getAttribute("account");

        try {
            int i = joinActivityService.deleteJoinActivity(account, activityId);
            if (i > 0) {
                map.put("msg", "1");
            } else {
                map.put("msg", "退出失败，请重新操作");
            }
        } catch (Exception e) {
            //不处理
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     *
     * @param activityId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showActivityDetail")
    public String showActivityDetail(int activityId, Model model, HttpServletRequest request) {
        Activity activity = activityService.findActivityActivityById(activityId);
        int isJoin = 0;
        String account = (String) request.getSession().getAttribute("account");
        JoinActivity joinActivity = joinActivityService.findUJoinActivityById(account, activityId);
        if (joinActivity != null) {
            isJoin = 1;
        }
        ActivityUtil activityUtil = new ActivityUtil();
        activityUtil.setIsUserJoin(isJoin);
        activityUtil.setActivity(activity);

        model.addAttribute("activity", activityUtil);
        return "base/Activity";
    }

    /**
     * 邀请成员
     * @param userId
     * @param activityId
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/inviteUser", method = RequestMethod.POST)
    public Map<String, Object> inviteUser(String userId,int activityId, HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<String, Object>();
        String account = (String) request.getSession().getAttribute("account");

        User friend = userService.findUserById(userId);
        if (friend == null) {
            map.put("msg", "不存在用户" + userId);
            return map;
        }
        if (account.equals(userId)) {
            map.put("msg", "不要邀请自己");
            return map;
        }
        try {
            JoinActivity joinActivity=new JoinActivity();
            //2表示受邀请
            joinActivity.setJoinActivityIsSuccess(2);
            joinActivity.setUserId(userId);
            joinActivity.setActivityId(activityId);
            int i = joinActivityService.saveJoinActivity(joinActivity);
            if (i > 0) {
                map.put("msg", "1");
            } else {
                map.put("msg", "2");
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }


    /**
     *展示创建的活动
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showMyJoinActivity")
    public String showMyJoinActivity(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");
        User user = userService.findUserById(account);
        List<JoinActivity> joinActivityList = user.getJoinActivityList();

        List<Activity> activityList = new ArrayList<Activity>();
        for (JoinActivity joinActivity : joinActivityList) {
            Activity activity = activityService.findActivityActivityById(joinActivity.getActivityId());
            Date date = new Date();
            try {
                //可以直接调用Date的compareTo()方法来比较大小，compareTo()方法的返回值，
                // date1小于date2返回-1，date1大于date2返回1
                //当前时间小于活动报名开始时间
                if ((date.compareTo(DateUtil.getStringDate(activity.getActivityJoinBeginTime()))) == -1) {
                    //1表示活动未开放报名
                    activityService.updateActivityStateById(activity.getActivityId(), 1);
                    activity.setActivityState(1);
                    System.out.println(activity.getActivityId() + "活动未开放报名");
                } else {
                    //当前时间小于活动报名截至时间
                    if ((date.compareTo(DateUtil.getStringDate(activity.getActivityJoinEndTime()))) == -1) {
                        //2表示活动正处于报名状态
                        activityService.updateActivityStateById(activity.getActivityId(), 2);
                        activity.setActivityState(2);
                        System.out.println(activity.getActivityId() + "正处于报名状态");
                    } else {

                        if ((date.compareTo(DateUtil.getStringDate(activity.getActivityBeginTime()))) == -1) {
                            //3表示活动正在进行中
                            activityService.updateActivityStateById(activity.getActivityId(), 3);
                            activity.setActivityState(3);
                            System.out.println(activity.getActivityId() + "活动正在进行中");
                        } else {
                            //4表示活动已经结束
                            activityService.updateActivityStateById(activity.getActivityId(), 4);
                            activity.setActivityState(4);
                            System.out.println(activity.getActivityId() + "活动已经结束");
                        }
                    }
                }
            } catch (Exception e) {

            }
            activityList.add(activity);
        }
        Page pageList = new Page(page, size, activityList);

        model.addAttribute("pageList", pageList);
        return "user/userMyJoinActivity";
    }

    /**
     *
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showMyCreateActivity")
    public String showMyCreateActivity(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");

        List<PersonHold> personHoldList = personHoldService.findPersonHoldAllByUserId(account);

        List<Activity> activityList = new ArrayList<Activity>();
        for (PersonHold personHold : personHoldList) {
            Activity activity = activityService.findActivityActivityById(personHold.getActivityId());
            Date date = new Date();
            try {
                //可以直接调用Date的compareTo()方法来比较大小，compareTo()方法的返回值，
                // date1小于date2返回-1，date1大于date2返回1
                //当前时间小于活动报名开始时间
                if ((date.compareTo(DateUtil.getStringDate(activity.getActivityJoinBeginTime()))) == -1) {
                    //1表示活动未开放报名
                    activityService.updateActivityStateById(activity.getActivityId(), 1);
                    activity.setActivityState(1);
                    System.out.println(activity.getActivityId() + "活动未开放报名");
                } else {
                    //当前时间小于活动报名截至时间
                    if ((date.compareTo(DateUtil.getStringDate(activity.getActivityJoinEndTime()))) == -1) {
                        //2表示活动正处于报名状态
                        activityService.updateActivityStateById(activity.getActivityId(), 2);
                        activity.setActivityState(2);
                        System.out.println(activity.getActivityId() + "正处于报名状态");
                    } else {

                        if ((date.compareTo(DateUtil.getStringDate(activity.getActivityBeginTime()))) == -1) {
                            //3表示活动正在进行中
                            activityService.updateActivityStateById(activity.getActivityId(), 3);
                            activity.setActivityState(3);
                            System.out.println(activity.getActivityId() + "活动正在进行中");
                        } else {
                            //4表示活动已经结束
                            activityService.updateActivityStateById(activity.getActivityId(), 4);
                            activity.setActivityState(4);
                            System.out.println(activity.getActivityId() + "活动已经结束");
                        }
                    }
                }
            } catch (Exception e) {

            }
            activityList.add(activity);
        }
        Page pageList = new Page(page, size, activityList);

        model.addAttribute("pageList", pageList);
        return "user/userMyCreatedActivityPage";
    }

    /**
     *
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showHotActivity")
    public String showHotActivity(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");
        User user = userService.findUserById(account);

        List<Activity> activityList = new ArrayList<Activity>();

        //获得兴趣爱好标签
        int item1=0;
        int item2=0;
        String[] hobby=user.getUserHobby().split(",");
        for(String s:hobby){
            if("体育健将".equals(s)){
                item1=1;
            }else if("文艺新星".equals(s)){
                item2=1;
            }
        }
        System.out.println(item1+","+item2);
        //取得所有社团活动
        List<Belong> belongList=user.getBelongList();
        System.out.println("get BelongList:"+belongList);
        for(Belong belong:belongList){
            if(belong.getBelongIsEnable()==1){
                Club club=clubService.findClubById(belong.getClubId());
                List<ClubHold> clubHoldList=club.getClubHoldList();
                for(ClubHold clubHold:clubHoldList){
                    Activity activity=activityService.findActivityActivityById(clubHold.getActivityId());
                    System.out.println("get activity:"+activity);
                    if(activity.getActivityState()==1||activity.getActivityState()==2){
                        activityList.add(activity);
                    }
                }
            }
        }
        System.out.println("社团活动:"+activityList);
        //待报名
        List<Activity> activities1=activityService.findActivityActivityByState(1);
        //报名中
        List<Activity> activities2=activityService.findActivityActivityByState(2);
        System.out.println("可报名的活动："+activities1+activities2);
        //根据兴趣标签推荐待报名的活动
        for(Activity activity:activities1){
            if(item1==1&&activity.getActivityType().equals("1")){
                System.out.println("体育："+activity);
                activityList.add(activity);
            }
            else if(item2==1&&activity.getActivityType().equals("2")){
                System.out.println("文艺："+activity);
                activityList.add(activity);
            }
        }
        //根据推荐算法推荐报名中的活动
        for(Activity activity:activities2){
            //报名人数低于1/3的不进行推荐,根据兴趣标签进行推荐
            if(activity.getJoinActivityList().size()<activity.getActivityPersonCount()){
                if(activity.getActivityType().equals("1")&&item1==1){
                    System.out.println("体育："+activity);
                    activityList.add(activity);
                }
                else if(activity.getActivityType().equals("2")&&item2==1){
                    System.out.println("文艺："+activity);
                    activityList.add(activity);
                }

            }
            //当报名人数超过三分之一时，计算推荐信息，超过推荐下限值就进行推荐
            else{
                List<User> userList=new ArrayList<>();
                List<JoinActivity> joinActivityList = activity.getJoinActivityList();
                for(JoinActivity joinActivity:joinActivityList){
                    userList.add(userService.findUserById(joinActivity.getUserId()));
                }

                if(RecommendUtil.recommendUtil(activity,user.getUserHobby(),userList)){
                    activityList.add(activity);
                }

            }

        }

        System.out.println("activity recommend:"+activityList);

        //通过HashSet剔除重复元素
        HashSet temp  =   new  HashSet(activityList);
        System.out.println(temp);
        activityList.clear();
        activityList.addAll(temp);
        System.out.println("activity final:"+activityList);
        Page pageList = new Page(page, size, activityList);

        model.addAttribute("pageList", pageList);
        return "user/userHotActivity";
    }

    /**
     *根据名字查询社团信息
     * @param page
     * @param size
     * @param clubName
     * @return
     * @throws Exception
     */
    @RequestMapping("/searchClubByName")
    public ModelAndView searchClubByName(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size,String clubName) throws Exception {
        System.out.println("method : searchClubByName");
        ModelAndView mv = new ModelAndView();
        try{
            List<Club> clubList =clubService.findClubByName(clubName);
            mv.setViewName("user/userSearchClub");
            Page pageList=new Page(page,size,clubList);
            mv.addObject("pageList",pageList);
            mv.addObject("search",clubName);
        }catch (Exception e){
            e.printStackTrace();
        }

        return mv;
    }


    /**
     *
     * @param ActivityName
     * @param ActivityIntroduction
     * @param ActivityContent
     * @param ActivityPlace
     * @param ActivityJoinBeginTime
     * @param ActivityJoinEndTime
     * @param ActivityJoinWay
     * @param ActivityPersonCount
     * @param ActivityPersonMethod
     * @param ActivityType
     * @param ActivityBeginTime
     * @param ActivityEndTime
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/createNormalActivity")
    @ResponseBody
    public Map<String,Object> createNormalActivity(String ActivityName,String ActivityIntroduction,
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

        /*User user=userService.findUserById(account);*/
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

        PersonHold personHold=new PersonHold();
        personHold.setActivityId(newActivity.getActivityId());
        personHold.setUserId(account);

        try{
            //先创建活动
            int j=activityService.saveActivity(newActivity);
            //引入外键
            int i=personHoldService.savePersonHold(personHold);
            JoinActivity joinActivity=new JoinActivity();
            joinActivity.setJoinActivityIsSuccess(1);
            joinActivity.setUserId(account);
            joinActivity.setActivityId(newActivity.getActivityId());
            //加入活动
            int k=joinActivityService.saveJoinActivity(joinActivity);
            if(i>0&&j>0&&k>0){
                map.put("msg","1");
            }
            else{
                activityService.deleteActivity(newActivity);
                personHoldService.deletePersonHold(personHold);
                joinActivityService.deleteJoinActivity(joinActivity.getUserId(),joinActivity.getActivityId());

                map.put("msg","活动创建失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
        return map;

    }

    /**
     *自定义创建活动
     * @param ActivityName
     * @param ActivityIntroduction
     * @param ActivityContent
     * @param ActivityJoinBeginTime
     * @param ActivityJoinEndTime
     * @param ActivityJoinWay
     * @param ActivityPersonCount
     * @param ActivityPersonMethod
     * @param ActivityType
     * @param ActivityJoinPerson
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/createManageActivity")
    @ResponseBody
    public Map<String,Object> createManageActivity(String ActivityName,String ActivityIntroduction,
                                                   String ActivityContent,
                                                   String ActivityJoinBeginTime,String ActivityJoinEndTime,
                                                   int ActivityJoinWay,int ActivityPersonCount,
                                                   int ActivityPersonMethod,String ActivityType,
                                                   String ActivityJoinPerson,
                                                   HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("method:createClubActivity"+"ActivityName:"+ActivityName+
                "ActivityIntroduction:"+ActivityIntroduction+"ActivityContent:"+ActivityContent
                +"ActivityJoinBeginTime:"+ActivityJoinBeginTime
                +"ActivityJoinEndTime:"+ActivityJoinEndTime+"ActivityJoinWay:"+ActivityJoinWay+
                "ActivityPersonCount:"+ActivityPersonCount+"ActivityPersonMethod:"+ActivityPersonMethod+
                "ActivityType:"+ActivityType+"ActivityJoinPerson"+ActivityJoinPerson);
        Map<String, Object> map = new HashMap<String, Object>();
        String account=(String)request.getSession().getAttribute("account");

        //获得邀请的成员id
        String [] userId=ActivityJoinPerson.split(",");
        int weekNum= DateUtil.returnWeekNum();

        //原则上时间要安排在报名结束之后
        int weekDayNum=DateUtil.returnWeekDayNum(ActivityJoinEndTime);

        if(weekDayNum>6){
            //报名时间大于周六，原则上活动安排到下一周进行
            weekNum+=1;
            weekDayNum=1;
        }
        System.out.println("要安排的当前周次："+weekNum);
        System.out.println("要安排的当前周日期："+weekDayNum);

        //获取当前周次成员的课表安排信息设置约束变量
        // 约束变量（cijk=1 表示第i个成员第j天第k课次有安排）软约束保证参与率
        int userLength=userId.length+1;
        //c[][0][0]不计算
        int [][][]c=new int[userLength][8][7];
        List<Select> accountSelectList=selectService.findSelectByUserId(account);
        //创建活动的用户的课表
        for(Select select:accountSelectList){
            Course course=courseService.findCourseById(select.getCourseId(),select.getCourseTeachId());
            //找到需要安排周的课表信息
            if(course.getCourseWeek()==weekNum){
                c[0][course.getCourseWeekDay()][course.getCourseTeach()]=1;
            }
        }
        //被邀请的用户的课表
        //
        for(int i=0;i<userId.length;i++){
            List<Select> userSelectList=selectService.findSelectByUserId(userId[i]);
            for(Select select:userSelectList){
                Course course=courseService.findCourseById(select.getCourseId(),select.getCourseTeachId());
                if(course.getCourseWeek()==weekNum){
                    c[i+1][course.getCourseWeekDay()][course.getCourseTeach()]=1;
                }
            }
        }

        //根据地点进行安排约束变量
        List<ActivityPlace> activityPlaceList=activityPlaceService.findActivityPlaceByWeekAndValue(weekNum,1);
        if(activityPlaceList.size()==0){
            map.put("msg","无可用地点，系统无法自动安排");
            return map;
        }
        Map<String,ActivityPlace> activityPlaceMap=new HashMap<>();
        int placeNum=1;
        Iterator<ActivityPlace> it = activityPlaceList.iterator();
        //约束变量 （pijk=1 表示第i个地点第j天第k课次 可安排）硬约束，必须遵守
        int[][][] p=new int[activityPlaceList.size()][8][7];
        while(it.hasNext()){
            ActivityPlace activityPlace=it.next();
            if(activityPlace.getActivityPlaceWeekDay()>=weekDayNum){
                System.out.println("placeNum:"+placeNum);
                activityPlaceMap.put(placeNum+"",activityPlace);
                p[placeNum-1][activityPlace.getActivityPlaceWeekDay()][activityPlace.getActivityPlaceTeach()]=1;
                placeNum++;
            }
        }
        /*User user=userService.findUserById(account);*/
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
        newActivity.setActivityPersonCount(ActivityPersonCount);
        newActivity.setActivityJoinWay(ActivityJoinWay);
        newActivity.setActivityPersonMethod(ActivityPersonMethod);
        newActivity.setActivityJoinBeginTime(ActivityJoinBeginTime);
        newActivity.setActivityJoinEndTime(ActivityJoinEndTime);
        newActivity.setActivityType(ActivityType);

        //0表示状态未知
        newActivity.setActivityState(0);

        System.out.println("new activity:"+newActivity);

        PersonHold personHold=new PersonHold();
        personHold.setActivityId(newActivity.getActivityId());
        personHold.setUserId(account);
        String answer=ActivityManageUtil.manageActivity(c,p,activityPlaceMap,weekDayNum);
        System.out.println("method :createManageActivity"+answer);

        //解析返回解
        char cWeekDayResult=answer.charAt(0);
        int weekDayResult=cWeekDayResult-'0';
        char cTeachResult=answer.charAt(1);
        int teachResult=cTeachResult-'0';
        String cPlaceId=answer.substring(2);

        ActivityPlace activityPlaceResult=activityPlaceMap.get(cPlaceId);
        System.out.println("ActivityJoinEndTime"+ActivityJoinEndTime+"weekday"+weekDayNum);
        String[] manageTime=DateUtil.returnManageTime(ActivityJoinEndTime,weekDayNum,weekDayResult,teachResult);
        newActivity.setActivityPlace(activityPlaceResult.getActivityPlaceName());
        System.out.println("manageTime"+manageTime);
        newActivity.setActivityBeginTime(manageTime[0]);
        newActivity.setActivityEndTime(manageTime[1]);

        try{
            //先创建活动
            int j=activityService.saveActivity(newActivity);
            //引入外键
            int i=personHoldService.savePersonHold(personHold);

            //将邀请的好友加入列表
            for(int m=0;m<userId.length;m++){
                JoinActivity userJoinActivity=new JoinActivity();
                userJoinActivity.setActivityId(newActivity.getActivityId());
                userJoinActivity.setUserId(userId[m]);
                userJoinActivity.setJoinActivityIsSuccess(1);
                joinActivityService.saveJoinActivity(userJoinActivity);
            }
            //自己加入活动
            JoinActivity joinActivity=new JoinActivity();
            joinActivity.setJoinActivityIsSuccess(1);
            joinActivity.setUserId(account);
            joinActivity.setActivityId(newActivity.getActivityId());
            int k=joinActivityService.saveJoinActivity(joinActivity);
            //锁定地点
            int n=activityPlaceService.updateActivityPlaceIsValid(activityPlaceResult.getActivityPlaceId(),0);
            if(i>0&&j>0&&k>0&&n>0){
                map.put("msg","1");
                //将生成的活动id反馈给前端
                map.put("activityId",newActivity.getActivityId());
            }
            else{
                //失败则清空操作
                activityService.deleteActivity(newActivity);
                personHoldService.deletePersonHold(personHold);
                joinActivityService.deleteJoinActivity(joinActivity.getUserId(),joinActivity.getActivityId());
                activityPlaceService.updateActivityPlaceIsValid(activityPlaceResult.getActivityPlaceId(),1);
                map.put("msg","活动创建失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;

    }

    /**
     * 显示学生申请活动列表
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showUserApplyActivity")
    public String showUserApplyActivity(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,Model model,HttpServletRequest request){
        String account =(String)request.getSession().getAttribute("account");
        User user=userService.findUserById(account);

        List<PersonHold> personHoldList=personHoldService.findPersonHoldAllByUserId(account);

        List<UserApplyActivityUtil> userApplyActivityUtilList=new ArrayList<>();
        for(PersonHold personHold:personHoldList){
            Activity activity=activityService.findActivityActivityById(personHold.getActivityId());
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
        return "user/userUserApplyActivity";
    }

    /**
     * 邀请展示页
     * @param page
     * @param size
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showUserInvite")
    public String showUserInvite(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "3")int size,Model model,HttpServletRequest request){
        String account =(String)request.getSession().getAttribute("account");
        List<JoinActivity> joinActivityList= joinActivityService.findJoinActivityAllByUserState(account, 2);
        System.out.println("showUserInvite"+joinActivityList);
        List<Activity> activityList=new ArrayList<>();
        for(JoinActivity joinActivity:joinActivityList){
            Activity activity=activityService.findActivityActivityById(joinActivity.getActivityId());
            if(activity.getActivityState()<3){
                activityList.add(activity);
                System.out.println(activity);
            }
        }
        Page pageList =new Page(page,size,activityList);
        model.addAttribute("pageList",pageList);
        return "user/userMyInvite";
    }


    /**
     * 更改活动报名状态
     * @param page
     * @param size
     * @param userId
     * @param activityId
     * @param state
     * @param request
     * @return
     * @throws Exception
     */
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

    /**
     * 通过邀约
     * @param activityId
     * @param stateValue
     * @return
     */
    @RequestMapping("/changeUserJoinActivityState")
    @ResponseBody
    public String changeUserJoinActivityState(int activityId,int stateValue,HttpServletRequest request){
        String answer="";
        String userId=(String)request.getSession().getAttribute("account");
        System.out.println("changeUserJoinActivityState"+activityId+"/"+stateValue);
        int i=joinActivityService.updateJoinActivity(userId,activityId,stateValue);
        if(i>0){
            answer="1";
        }else
        {
            answer="加入活动失败";
        }
        return answer;
    }


    @RequestMapping("/deleteUserJoinActivityState")
    @ResponseBody
    public String deleteUserJoinActivityState(int activityId,HttpServletRequest request){
        String answer="";
        String userId=(String)request.getSession().getAttribute("account");
        int i=joinActivityService.deleteJoinActivity(userId,activityId);
        if(i>0){
            answer="1";
        }else
        {
            answer="拒绝加入活动失败，请重试";
        }
        return answer;
    }

    /**
     * 退出活动报名
     * @param page
     * @param size
     * @param userId
     * @param activityId
     * @return
     * @throws Exception
     */
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

    /**
     * 取消活动
     * @param page
     * @param size
     * @param activityId
     * @param request
     * @return
     * @throws Exception
     */
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

        //清除用户持有
        String account =(String)request.getSession().getAttribute("account");
        PersonHold personHold=new PersonHold();
        personHold.setUserId(account);
        personHold.setActivityId(activityId);
        personHoldService.deletePersonHold(personHold);
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

    /**
     * 显示活动管理
     * @param activityId
     * @return
     */
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
        mv.addObject("IsUserCreate","1");
        return mv;
    }

}
