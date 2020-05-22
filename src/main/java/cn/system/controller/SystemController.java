package cn.system.controller;

import cn.system.domain.Club;
import cn.system.domain.SystemNotice;
import cn.system.domain.User;
import cn.system.service.ClubService;
import cn.system.service.SystemNoticeService;
import cn.system.service.UserService;
import cn.system.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 根路径
 */
@Controller
@RequestMapping("/")
public class SystemController {

    @Autowired
    private UserService userService;
    @Autowired
    private ClubService clubService;
    @Autowired
    private SystemNoticeService systemNoticeService;

    /**
     * 展示登录页
     * @return
     */
    @RequestMapping("/showLogIn")
    public String showLogIn() {
        System.out.println("表现层，展示登录页");
        return "base/logIn";
    }

    /**
     * 展示公告
     * @param model
     * @return
     */
    @RequestMapping("/showSystemNotice")
    public String showSystemNotice(Model model) {
        System.out.println("表现层，展示系统公告页");
        SystemNotice systemNotice =systemNoticeService.findNewestSystemNotice();
        System.out.println("表现层，输出公告"+systemNotice);
        model.addAttribute("systemNotice",systemNotice);
        return "base/systemNotice";
    }

    /**
     * 展示社团申请页
     * @return
     */
    @RequestMapping("/showCreateClub")
    public String showCreateClub() {
        System.out.println("表现层，展示创建社团页");
        return "base/createClub";
    }

    /**
     * 返回首页
     * @param session
     * @return
     */
    @RequestMapping(value = "/BackIndex")
    public String backIndex(HttpSession session) {
        System.out.println("表现层，返回首页");
        /*session.invalidate();
        System.out.println("表现层，清除session");*/
        return "redirect:/index.jsp";
        /*return "/index";*/
    }

    /**
     * 安全退出
     * @param session
     * @return
     */
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        System.out.println("表现层，安全退出");
        session.invalidate();
        System.out.println("表现层，清除session");
        return "redirect:/index.jsp";
    }

    /**
     * 展示注册页
     * @return
     */
    @RequestMapping("/showSignIn")
    public String showSignIn() {
        System.out.println("表现层，展示注册页");
        return "base/signIn";
    }

    /**
     * 用户申请注册
     * @param account
     * @param userPassword
     * @param userName
     * @param userEmail
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userApplyAccount",method = RequestMethod.POST)
    public Map<String,Object> askSignIn(String account, String userPassword, String userName, String userEmail, HttpServletRequest request, HttpServletResponse response)throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        //
        System.out.println("表现层，前端输入 user "+"account:"+account+" password:"+userPassword+" userName:"+userName+" userEmail:"+userEmail+ new DateUtil().returnFormatDate());

        //
        User user = new User();
        user.setUserId(account);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);
        user.setUserIsEnable(0);

        try{
            System.out.println("表现层，用户注册");
            System.out.println("用户信息:"+user);
            int i=userService.saveUser(user);
            System.out.println("mybatis改变了"+i+"条数据");
            if(i>0){
                map.put("msg","1");
                return map;
            }
            map.put("msg","不要重复注册");
        }catch(Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        System.out.println("表现层，返回map");
        return map;
    }

    /**
     * 申请社团创建
     * 上传文件
     * @param file
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/clubApplyAccount",method = RequestMethod.POST)
    public Map<String, Object> createClub(MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();

        String clubName = request.getParameter("clubName");
        String introduction =request.getParameter("introduction");
        String fileString =file.getOriginalFilename();
        System.out.println("获取到的paramString:"+fileString+"  clubName:"+clubName+"  introduction:"+introduction);
        Club oldClub=clubService.findClubByUName(clubName);
        if(oldClub!=null){
            map.put("msg","请不要创建重名社团");
            return map;
        }
        //("/upload")是表示文件上传后的目标文件
        String dirPath=request.getSession().getServletContext().getRealPath("/upload");
        //创建文件夹
        File uploadDirPath=new File(dirPath);
        if(!uploadDirPath.exists()){
            uploadDirPath.mkdir();
        }

        String path = dirPath+"/"+clubName;
        System.out.println("文件上传的路径为："+path);
        //
        Club club =new Club();
        int i=clubService.findClubBiggestId().getClubId();
        /*System.out.println("max clubId"+i);*/
        club.setClubId(i+1);
        /*System.out.println("wrong?");*/
        club.setClubName(clubName);
        club.setClubIsEnable(0);
        club.setClubIntroduction(introduction);
        club.setClubNotice(clubName+"的默认公告");
        //只用存储文件名
        club.setClubFile(fileString);
        //64位长度不够
        System.out.println(club.getClubFile());
        System.out.println("club info:"+club);
        //创建文件夹
        File uploadPath=new File(path);
        if(!uploadPath.exists()){
            uploadPath.mkdir();
        }
        try{
            System.out.println("表现层,创建申请");
            int answer=clubService.saveClub(club);
            if(answer>0){
                File dir = new File(path,fileString);
                if(!dir.exists()){  //如果dir代表的文件不存在，则创建
                    dir.mkdir();
                }
                System.out.println("表现层，文件上传路径"+dir.toString());
                //如果存在就执行下面操作
                file.transferTo(dir);//将上传的实体文件复制到制定目录upload下
                if(dir.exists()){
                    map.put("msg","1");
                }else{
                    map.put("msg","文件上传失败，请联系指导老师");
                }
            }else {
                map.put("msg","服务器出错，社团无法创建");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg", e.getMessage());
        }

        return map;
    }


}
