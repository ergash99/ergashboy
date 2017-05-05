package uz.tiu.daily.controllers.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: gayratjon
 * Date: 4/24/14
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final static String URL_LOGIN_PANEL = "/login.htm";
    private final static String VIEW_LOGIN_PANEL = "security/login";

    public final static String URL_ACCESS_DENIED  = "/accessDenied.htm";
    private final static String VIEW_ACCESS_DENIED = "security/accessDenied";

    @RequestMapping(value = URL_LOGIN_PANEL, method = RequestMethod.GET)
    public ModelAndView processLoginPanel() throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView(VIEW_LOGIN_PANEL);

        return modelAndView;
    }

    @RequestMapping(value = URL_ACCESS_DENIED, method = RequestMethod.GET)
    public ModelAndView getAccessDenied() throws ServletException, IOException {

        return new ModelAndView(VIEW_ACCESS_DENIED);
    }
}
