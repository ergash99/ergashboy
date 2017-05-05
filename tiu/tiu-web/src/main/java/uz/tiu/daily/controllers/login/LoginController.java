package uz.tiu.daily.controllers.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Random;

/**
 * @author Sheroz Khaydarov
 * @since 31.03.13 21:45
 */
@Controller
@Transactional
public class LoginController {

    public final static String URL_LOGIN = "/login.htm";
    public final static String VIEW_LOGIN = "login/login";

    public final static String URL_ACCESS_DENIED = "/accessDenied.htm";
    public final static String VIEW_ACCESS_DENIED = "login/accessDenied";

    public final static String URL_TIMEOUT = "/timeout.htm";
    public final static String VIEW_TIMEOUT = "login/timeout";

    public final static String URL_PASSWORD = "/password.htm";
    public final static String VIEW_PASSWORD = "login/password";
    public final static String VIEW_PASSWORD_DONE = "login/password-done";
    public final static String URL_PASSWORD_RESET = "/password-reset.htm";
    public final static String VIEW_PASSWORD_RESET = "login/password-reset";

    public final static String URL_CAPTCHA = "/captcha/captcha.jpg";

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    EntityManager entityManager;


//    @RequestMapping(value = URL_LOGIN, method = RequestMethod.GET)
//    public ModelAndView getLogin(HttpServletRequest request, HttpServletResponse response,
//                                 @RequestParam(value = "login_error", required = false) Long loginError) {
//
//        HttpSession session = request.getSession(true);
//        session.setAttribute("userDetail", null);
//
//        Integer loginAttempt = 0;
//        try {
//            loginAttempt = (Integer) session.getAttribute("loginAttempts");
//            if (loginAttempt != null) {
//                // loginAttempt++;
//            } else {
//                loginAttempt = 0;
//            }
//            //   session.setAttribute("loginAttempts", loginAttempt);
//
//        } catch (Exception e) {
//            //   session.setAttribute("loginAttempts", loginAttempt);
//        }
//
//        // If Login error, then capthca must work too
//        if (loginError != null && loginError == 1) {
//            loginAttempt++;
//        }
//
//        try {
//            session.setAttribute("loginAttempts", loginAttempt);
//        } catch (Exception e) {
//        }
//
//
//        ModelAndView modelAndView;
//
//        modelAndView = new ModelAndView(VIEW_LOGIN);
//        modelAndView.addObject("loginAttempt", loginAttempt);
//        if (loginError != null)
//            modelAndView.addObject("loginError", loginError);
//
//        return modelAndView;
//    }


    @RequestMapping(value = URL_ACCESS_DENIED, method = RequestMethod.GET)
    public ModelAndView getAccessDenied()
            throws ServletException, IOException {

        return new ModelAndView(VIEW_ACCESS_DENIED);
    }

    @RequestMapping(value = URL_TIMEOUT, method = RequestMethod.GET)
    public ModelAndView getTimeout()
            throws ServletException, IOException {

        return new ModelAndView(VIEW_TIMEOUT);
    }

}
