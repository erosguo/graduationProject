package cn.system.controller;

import cn.system.domain.*;
import cn.system.service.*;
import cn.system.utils.DateUtil;
import cn.system.utils.Page;
import cn.system.utils.RandomIdCode;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("SystemManager")
public class SystemManagerController {
    @Autowired
    private UserService userService;
    @Autowired
    private SystemManagerService systemManagerService;
    @Autowired
    private ClubService clubService;
    @Autowired
    private ClubManagerService clubManagerService;
    @Autowired
    private SystemNoticeService systemNoticeService;
    @Autowired
    private ActivityPlaceService activityPlaceService;
    @Autowired
    private MessageService messageService;

    /**
     * 判断系统管理员登录
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
        System.out.println("表现层，前端输入 systemManager " + "account:" + account + " password:" + userPassword + new DateUtil().returnFormatDate());

        //
        System.out.println("表现层，管理员登录校验");
        SystemManager systemManager = systemManagerService.findSystemManagerById(account);
        System.out.println("get SystemManager:" + systemManager);

        try {
            if (systemManager != null && systemManager.getSystemManagerPassword().equals(userPassword)) {
                //
                map.put("msg", "1");
                System.out.println("表现层，登录成功");
                HttpSession session = request.getSession();
                session.setAttribute("account", systemManager.getSystemManagerId());
                session.setAttribute("systemManager", systemManager);
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
     * 进入社团工作台
     *
     * @return
     */
    @RequestMapping("/showSystemManagerStation")
    public String showUserStation() {
        return "systemManager/systemManagerStation";
    }

    /**
     * 进入密码修改页
     *
     * @return
     */
    @RequestMapping("/showPasswordPage")
    public String showPasswordPage() {
        return "systemManager/systemManagerPasswordPage";
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
        System.out.println("表现层，前端请求更改密码" + "userPassword1:" + userPassword1 + " userPassword2:" + userPassword2 + new DateUtil().returnFormatDate());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        SystemManager systemManager = systemManagerService.findSystemManagerById(account);
        System.out.println("获得管理员：" + systemManager);

        try {
            if (systemManager != null && systemManager.getSystemManagerPassword().equals(userPassword1)) {
                System.out.println("表现层，更改密码");
                int i = systemManagerService.updateSystemManagerPasswordById(account, userPassword2);
                if (i > 0) {
                    System.out.println("表现层，修改成功");
                    map.put("msg", "1");
                    return map;
                } else {
                    System.out.println("表现层，修改失败");
                    map.put("msg", "数据库不能成功更新");
                    return map;
                }
            } else if (!systemManager.getSystemManagerPassword().equals(userPassword1)) {
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
     * 进入信息修改页
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/showInfoPage")
    public String showInfoPage(Model model, HttpServletRequest request) {
        String account = (String) request.getSession().getAttribute("account");
        SystemManager systemManager = systemManagerService.findSystemManagerById("account");
        model.addAttribute("systemManager", systemManager);
        return "systemManager/systemManagerInfoPage";
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
        System.out.println("表现层，前端请求改变教师姓名" + "userHobby:" + userName + new DateUtil().returnFormatDate());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        SystemManager systemManager = systemManagerService.findSystemManagerById(account);


        try {
            if (systemManager != null) {
                System.out.println("表现层，更改教师姓名");
                int i = systemManagerService.updateSystemManagerNameById(account, userName);
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
     * 修改邮箱
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
        System.out.println("表现层，前端请求改变教师邮箱" + "userEmail:" + userEmail + new DateUtil().returnFormatDate());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        SystemManager systemManager = systemManagerService.findSystemManagerById(account);


        try {
            if (systemManager != null) {
                System.out.println("表现层，更改教师邮箱");
                int i = systemManagerService.updateSystemManagerEmailById(account, userEmail);
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
     * 修改手机
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
        System.out.println("表现层，前端请求改变教师联系方式" + "userTel:" + userTel + new DateUtil().returnFormatDate());

        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        SystemManager systemManager = systemManagerService.findSystemManagerById((String) session.getAttribute("account"));


        try {
            if (systemManager != null) {
                System.out.println("表现层，更改教师联系手机");
                int i = systemManagerService.updateSystemManagerTelById(account, userTel);
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
     * 展示审核学生界面
     * @param model
     * @return
     */
    @RequestMapping("/showUserApply")
    public String showUserApply(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model) throws Exception {
        List<User> userAll = userService.findInvalidUserAll();
        Page pageList = new Page(page, size, userAll);
        model.addAttribute("pageList", pageList);
        return "systemManager/systemManagerUserApply";
    }

    @RequestMapping("/passUserApply")
    public ModelAndView passUserApply(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, String userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //1表示通过社团申请
        int i = userService.updateIsEnableById(userId,1);
        if (i > 0) {
            mv.setViewName("redirect:showUserApply?page=" + page + "&size=" + size);
        } else {
            mv.setViewName("base/tips");
            mv.addObject("tips", "服务器出错，请重试");
        }
        return mv;
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
            //3表示来自系统管理员
            message.setMessageType(3);
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
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/resetUserPassWord")
    @ResponseBody
    public Map<String, Object> resetUserPassWord(String userId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        int i=userService.updateUserPasswordById(userId,"11111111");
        if(i>0){
            map.put("msg","1");
        }else{
            map.put("msg","修改失败");
        }
        return map;
    }


    @RequestMapping("/refuseUserApply")
    public ModelAndView refuseUserApply(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, String userId) throws Exception {

        ModelAndView mv = new ModelAndView();
        //3表示拒绝申请
        int i = userService.deleteUserById(userId);
        if (i > 0) {
            mv.setViewName("redirect:showUserApply?page=" + page + "&size=" + size);
        } else {
            mv.setViewName("base/tips");
            mv.addObject("tips", "服务器出错，请重试");
        }
        return mv;
    }


    /**
     * 展示所有已经审核的社团
     * @param model
     * @return
     */
    @RequestMapping("/showValidClubAll")
    public String showValidClubAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model) {
        List<Club> clubAll = clubService.findClubValidAll();
        Page pageList = new Page();
        //设置当前界面为第一页
        pageList.setCurrentPage(page);
        //设置每页数据
        pageList.setPageSize(size);
        //每页的开始数
        pageList.setStar((pageList.getCurrentPage() - 1) * pageList.getPageSize());
        //list的大小
        int count = clubAll.size();
        //设置总页数
        pageList.setTotalPage(count % size == 0 ? count / size : count / size + 1);
        //对list进行截取
        pageList.setDataList(clubAll.subList(pageList.getStar(), count - pageList.getStar() > pageList.getPageSize() ? pageList.getStar() + pageList.getPageSize() : count));
        System.out.println("pagelist" + pageList.getDataList());
        model.addAttribute("pageList", pageList);
        return "systemManager/systemManagerValidClubAll";
    }


    /**
     * 分页展示所有未审核社团
     *
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping("/showClubApply")
    public String showClubApply(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model) {
        List<Club> clubAll = clubService.findClubInvalidAll();

        Page pageList = new Page();
        //设置当前界面为第一页
        pageList.setCurrentPage(page);
        //设置每页数据
        pageList.setPageSize(size);
        //每页的开始数
        pageList.setStar((pageList.getCurrentPage() - 1) * pageList.getPageSize());
        //list的大小
        int count = clubAll.size();
        //设置总页数
        pageList.setTotalPage(count % size == 0 ? count / size : count / size + 1);
        //对list进行截取
        pageList.setDataList(clubAll.subList(pageList.getStar(), count - pageList.getStar() > pageList.getPageSize() ? pageList.getStar() + pageList.getPageSize() : count));
        System.out.println("pagelist" + pageList.getDataList());
        model.addAttribute("pageList", pageList);
        return "systemManager/systemManagerClubApply";
    }


    /**
     * 重启社团
     * @param page
     * @param size
     * @param clubId
     * @return
     * @throws Exception
     */
    @RequestMapping("/reStartClub")
    public ModelAndView reStartClub(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, int clubId) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("method:reStartClub");
        int i = clubService.updateClubIsEnable(clubId, 1);
        if (i > 0) {
            int num = 80000000 + clubId;
            //
            int j = clubManagerService.updateClubManagerPasswordById(""+num,"11111111");
            System.out.println("i:"+i+"j:"+j);

            if (j > 0) {
                mv.setViewName("redirect:showClubAll?page=" + page + "&size=" + size);
            } else {
                mv.setViewName("base/tips");
                mv.addObject("tips", "服务器出错，请重试");
            }
        } else {
            mv.setViewName("base/tips");
            mv.addObject("tips", "服务器出错，请重试");
        }
        return mv;
    }

    /**
     * 暂停社团
     * @param page
     * @param size
     * @param clubId
     * @return
     * @throws Exception
     */
    @RequestMapping("/stopClub")
    public ModelAndView stopClub(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, int clubId) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("method:stopClub");
        //4表示停运社团
        int i = clubService.updateClubIsEnable(clubId, 4);
        if (i > 0) {
            //封锁关联的社团管理员
            String uuid=RandomIdCode.generateShortUUID();
            int num = 80000000 + clubId;
            //
            int j = clubManagerService.updateClubManagerPasswordById(""+num,uuid);
            System.out.println("i:"+i+"j:"+j);
            if (j > 0) {
                mv.setViewName("redirect:showClubAll?page=" + page + "&size=" + size);
            } else {
                mv.setViewName("base/tips");
                mv.addObject("tips", "停运社团管理员时服务器出错，请重试");
            }
        } else {
            mv.setViewName("base/tips");
            mv.addObject("tips", "停运社团时服务器出错，请重试");
        }
        return mv;
    }

    /**
     * 通过社团申请
     * @param page
     * @param size
     * @param clubId
     * @return
     * @throws Exception
     */
    @RequestMapping("/passClubApply")
    public ModelAndView passClubApply(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, int clubId) throws Exception {
        ModelAndView mv = new ModelAndView();
        System.out.println("method:passClubApply");
        //1表示通过社团申请
        int i = clubService.updateClubIsEnable(clubId, 1);
        if (i > 0) {
            //创建关联的社团管理员
            ClubManager clubManager = new ClubManager();
            clubManager.setClubId(clubId);
            int num = 80000000 + clubId;
            clubManager.setClubManagerId("" + num);
            clubManager.setClubManagerPassword("11111111");
            int j = clubManagerService.saveClubManager(clubManager);
            if (j > 0) {
                mv.setViewName("redirect:showClubApply?page=" + page + "&size=" + size);
            } else {
                mv.setViewName("base/tips");
                mv.addObject("tips", "服务器出错，请重试");
            }
        } else {
            mv.setViewName("base/tips");
            mv.addObject("tips", "服务器出错，请重试");
        }
        return mv;
    }

    /**
     * 拒绝社团申请
     * @param page
     * @param size
     * @param clubId
     * @return
     * @throws Exception
     */
    @RequestMapping("/refuseClubApply")
    public ModelAndView refuseClubApply(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, int clubId) throws Exception {
        System.out.println("method:refuseClubApply");
        ModelAndView mv = new ModelAndView();
        //3表示拒绝申请
        int i = clubService.updateClubIsEnable(clubId, 3);
        if (i > 0) {
            mv.setViewName("redirect:showClubApply?page=" + page + "&size=" + size);
        } else {
            mv.setViewName("base/tips");
            mv.addObject("tips", "服务器出错，请重试");
        }
        return mv;
    }


    /**
     * 下载社团申请文件
     * @param request
     * @param response
     * @param filename
     * @throws IOException
     */
    @RequestMapping("/downLoadFile")
    public void downLoadFile(HttpServletRequest request, HttpServletResponse response, @Param("filename") String filename, String clubName) throws IOException {
        //设置响应流中文件进行下载
        response.setHeader("Content-Disposition", "attachment;filename" + filename);
        System.out.println("fileName:"+filename+"clubName:"+clubName);
        //把二进制流放入到响应体中
        ServletOutputStream os = response.getOutputStream();
        //获取需要下载的文件路径
        String path = request.getSession().getServletContext().getRealPath("/upload") + "/" + clubName;
        System.out.println("下载路径为:" + path);
        File file = new File(path, filename);
        System.out.println("filePath"+file.toString());
        byte[] bytes = FileUtils.readFileToByteArray(file);
        os.write(bytes);
        os.flush();
        os.close();
    }


    /**
     * 展示创建系统公告页
     * @return
     */
    @RequestMapping("/showCreateSystemNoticePage")
    public String showSystemNoticeOperator() {
        return "systemManager/systemManagerCreateSystemNoticePage";
    }

    /**
     * 展示修改系统公告页
     * @param model
     * @return
     */
    @RequestMapping("/showSystemNoticeInfo")
    public String showSystemNoticeInfo(Model model) {
        SystemNotice systemNotice = systemNoticeService.findNewestSystemNotice();
        System.out.println("表现层，输出公告" + systemNotice);
        model.addAttribute("systemNotice", systemNotice);
        return "systemManager/systemManagerSystemNoticeInfo";
    }

    /**
     * 删除社团公告
     * @param noticeId
     * @return
     */
    @RequestMapping("/deleteSystemNotice")
    @ResponseBody
    public Map<String, Object> deleteSystemNotice(int noticeId) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int i = systemNoticeService.deleteSystemNotice(noticeId);
            if (i > 0) {
                map.put("msg", "1");
                System.out.println("表现层：删除成功");
                return map;
            }
            map.put("msg", "2");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        return map;
    }

    /**
     * 创建系统公告
     * @param noticeName
     * @param noticeContent
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/saveSystemNotice", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveSystemNotice(String noticeName, String noticeContent, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        SystemNotice systemNotice = new SystemNotice();
        SystemNotice oldSystemNotice = systemNoticeService.findNewestSystemNotice();
        if (oldSystemNotice != null) {
            systemNotice.setSystemNoticeId(oldSystemNotice.getSystemNoticeId() + 1);
        } else {
            systemNotice.setSystemNoticeId(1);
        }
        String managerId = (String) request.getSession().getAttribute("account");
        systemNotice.setSystemManagerId(managerId);
        systemNotice.setSystemNoticeName(noticeName);
        systemNotice.setSystemNoticeContent(noticeContent);
        systemNotice.setSystemNoticeTime(new DateUtil().returnFormatDate());
        System.out.println("要插入的公告" + systemNotice);
        try {
            int i = systemNoticeService.saveSystemNotice(systemNotice);
            if (i > 0) {
                map.put("msg", "1");
                System.out.println("表现层：添加成功");
                return map;
            }
            map.put("msg", "2");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        return map;
    }

    /**
     * 修改系统公告
     * @param noticeId
     * @param noticeName
     * @param noticeContent
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateSystemNotice", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateSystemNotice(int noticeId, String noticeName, String noticeContent, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (noticeName == null || noticeName == "notice content" || noticeName == "") {
                int i = systemNoticeService.updateSystemNoticeContentById(noticeId, noticeContent);
                if (i > 0) {
                    map.put("msg", "1");
                    return map;
                }
                map.put("msg", "2");
            } else {
                int i = systemNoticeService.updateSystemNotice(noticeId, noticeName, noticeContent);
                if (i > 0) {
                    map.put("msg", "1");
                    return map;
                }
                map.put("msg", 2);
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @RequestMapping("/showUserAll")
    public String showUserAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {

        List<User> userList = userService.findUserAll();
        Collections.reverse(userList);

        Page pageList = new Page(page, size, userList);

        model.addAttribute("pageList", pageList);
        return "systemManager/systemManagerUserAll";
    }

    @RequestMapping("/showClubAll")
    public String showClubAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {

        List<Club> clubList = clubService.findClubAll();
        Collections.reverse(clubList);

        Page pageList = new Page(page, size, clubList);

        model.addAttribute("pageList", pageList);
        return "systemManager/systemManagerClubAll";
    }

    @RequestMapping("/showActivityPlaceAll")
    public String showActivityPlaceAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size, Model model, HttpServletRequest request) {

        List<ActivityPlace> activityPlaceList = activityPlaceService.findActivityPlaceAll();
        Collections.reverse(activityPlaceList);

        Page pageList = new Page(page, size, activityPlaceList);

        model.addAttribute("pageList", pageList);
        return "systemManager/systemManagerActivityPlaceAll";
    }

    /**
     *
     * @param activityPlaceName
     * @param activityPlaceWeek
     * @param activityPlaceWeekDay
     * @param activityPlaceTeach
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createActivityPlace", method = RequestMethod.POST)
    public Map<String, Object> createActivityPlace(String activityPlaceName, int activityPlaceWeek, int activityPlaceWeekDay, int activityPlaceTeach, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("get attribute:" + "activityPlaceName:" + activityPlaceName + "activityPlaceWeek:" + activityPlaceTeach
                + "activityPlaceWeekDay:" + activityPlaceWeekDay + "activityPlaceTeach:" + activityPlaceTeach);
        //
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        ActivityPlace activityPlace = new ActivityPlace();
        //八位的uuid
        activityPlace.setActivityPlaceId(RandomIdCode.generateShortUUID());
        //
        activityPlace.setActivityPlaceName(activityPlaceName);
        activityPlace.setActivityPlaceWeek(activityPlaceWeek);
        activityPlace.setActivityPlaceWeekDay(activityPlaceWeekDay);
        activityPlace.setActivityPlaceTeach(activityPlaceTeach);
        //1表示地点可用
        activityPlace.setActivityPlaceIsEnable(1);

        try {
            int i = activityPlaceService.saveActivityPlace(activityPlace);
            if (i > 0) {
                map.put("msg", "1");
            } else {
                map.put("msg", "创建失败，请重试");
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    @RequestMapping("/cancelActivityPlace")
    public ModelAndView cancelActivityPlace(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "3") int size,String activityPlaceId,HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        int i=activityPlaceService.deleteActivityPlace(activityPlaceId);
        if(i>0){
            mv.setViewName("redirect:showActivityPlaceAll?page=" + page + "&size=" + size);
        }else{
            mv.setViewName("base/tips");
            mv.addObject("tips","取消失败");
        }
        return mv;
    }

}
