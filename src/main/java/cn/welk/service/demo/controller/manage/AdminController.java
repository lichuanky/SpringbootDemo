package cn.welk.service.demo.controller.manage;

import cn.welk.service.demo.entity.SysUser;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    Logger logger = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginPost(HttpServletRequest request, HttpSession session) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        logger.info("userName: " + userName + ", password: " + password);
        SysUser user = new SysUser();
        user.setUserName("Welk-admin");
        user.setLoginId("welk_admin");
        user.setDisabled(false);
        user.setEmail("admin@welk.cn");
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:dashboard";
        } else {
            request.setAttribute("error", "Password error!");
        }
        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        logger.info("Remove session attribute user.");
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String dashboard() {
        return "dashboard";
    }
}
