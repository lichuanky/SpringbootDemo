package cn.welk.service.demo.controller.login.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/security/")
public class SecurityAction {

    private Logger logger = LoggerFactory.getLogger(SecurityAction.class);
    private final static String PAGE_MANAGE_INDEX = "manage/manage_index";
    private final static String PAGE_LOGIN = "login";
    private final static String PAGE_TIP = "common/common_tip";
    private static final String LOGIN_IDENTITY = "login_identity";
    private static final String PASSWORD = "password";

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        boolean is_valid = false;
        String loginIdentity = request.getParameter(LOGIN_IDENTITY);
        logger.info("login, loginIdentity:" + loginIdentity);
        String password = request.getParameter(PASSWORD);
        logger.info("login, password:" + password);
        //logger.info("login, user:" + user);
        //if ((user != null && user.getPassword().equals(Md5Util.md5Encode(password)))) {
        is_valid = true;
        //}
        logger.info("login, is_valid:" + is_valid);
        if (is_valid) {
            /*UserSession userSession = new UserSession(user, new Date());
            session.setAttribute(UserSession.USER_SESSION, userSession);
			
			request.setAttribute("user", user);*/
            //request.setAttribute("managerId", managerId);
            return PAGE_MANAGE_INDEX;
        } else {
            String warn = "登录信息错误！";
            logger.warn(warn);
            request.setAttribute("msg", warn);
            return PAGE_TIP;
        }
    }

    @RequestMapping("loginManager")
    public String loginManager(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String loginIdentity = request.getParameter(LOGIN_IDENTITY);
        logger.info("loginManager, loginIdentity:" + loginIdentity);
        String password = request.getParameter(PASSWORD);
        logger.info("loginManager, password:" + password);
        boolean is_valid = true;
        logger.info("loginManager, is_valid:" + is_valid);
        if (is_valid) {
            //session.setAttribute(UserSession.USER_SESSION, loginIdentity);

            //request.setAttribute("manager", manager);
            //return PAGE_GARTEN_INDEX;
            //request.setAttribute("managerId", manager.getId());
            //return "redirect:/garten/manage/garten/listSome/" + manager.getId();

			/*HttpClient client = new HttpClient(response);
            client.setParameter("managerId", manager.getId());
			try {
				client.sendByPost("/garten/manage/garten/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";*/
        } else {
            String warn = "登录信息错误！";
            logger.warn(warn);
            request.setAttribute("msg", warn);
            return PAGE_TIP;
        }
        return PAGE_TIP;
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        logger.info("user logout");
        //session.removeAttribute(UserSession.USER_SESSION);
        return PAGE_LOGIN;
    }
}