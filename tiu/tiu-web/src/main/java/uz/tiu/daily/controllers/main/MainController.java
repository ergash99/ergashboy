package uz.tiu.daily.controllers.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import uz.tiu.daily.controllers.admin.admin.AdminController;
import uz.tiu.daily.controllers.admin.smeta.SmetaController;
import uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController;
import uz.tiu.daily.controllers.security.LoginController;
import uz.tiu.daily.controllers.security.SecurityLoggedUser;
import uz.tiu.daily.persistence.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;



@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final static String URL_MAIN = "/main.htm";
//
//    @RequestMapping("/")
//    public ModelAndView getList() {
//        return new ModelAndView("index");
//    }

    @RequestMapping(value = URL_MAIN)
    public ModelAndView processMain() throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityLoggedUser securityLoggedUser = (SecurityLoggedUser) authentication.getPrincipal();
        User user = securityLoggedUser.getUser();
        Collection<GrantedAuthority> grantedAuthorities = securityLoggedUser.getAuthorities();
        String role = null;

        Iterator<GrantedAuthority> iterator = grantedAuthorities.iterator();
        while (iterator.hasNext()) {
            SimpleGrantedAuthority simpleGrantedAuthority = (SimpleGrantedAuthority) iterator.next();
            role = simpleGrantedAuthority.getAuthority();
            break;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("Authenticated user login={}, role={}", user.getLogin(), role);
        }

        ModelAndView modelAndView;

        if (role.equalsIgnoreCase("ROLE_SYSADMIN") || role.equalsIgnoreCase("ROLE_ADMIN")) {
            modelAndView = new ModelAndView("redirect:" + SmetaController.URL_SMETA);
        } else if (role.equalsIgnoreCase("ROLE_SYSADMIN") || role.equalsIgnoreCase("ROLE_OPERATOR")) {
            modelAndView = new ModelAndView("redirect:" + AdminController.URL_ADMIN);
        } else {
            modelAndView = new ModelAndView("redirect:" + LoginController.URL_ACCESS_DENIED);
        }

        return modelAndView;
    }

    public static Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            SecurityLoggedUser securityLoggedUser = (SecurityLoggedUser) authentication.getPrincipal();
            User user = securityLoggedUser.getUser();
            return user.getId();
        }

        return null;
    }

    public static User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityLoggedUser securityLoggedUser = (SecurityLoggedUser) authentication.getPrincipal();
        User user = securityLoggedUser.getUser();

        return user;
    }


}
