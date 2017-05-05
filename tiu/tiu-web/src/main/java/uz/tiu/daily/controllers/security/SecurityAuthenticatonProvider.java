package uz.tiu.daily.controllers.security;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import uz.tiu.daily.common.configuration.AppConfiguration;
import uz.tiu.daily.common.configuration.RoleConfiguration;
import uz.tiu.daily.persistence.User;
import uz.tiu.daily.persistence.UserRole;

import uz.tiu.daily.common.RoleInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityAuthenticatonProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    private AppConfiguration appConfiguration;
    private SecurityService securityService;

    public void setAppConfiguration(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    public void setSecurityService(SecurityService securityService) {

        this.securityService = securityService;

    }



    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);

    }

    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String login = null;
        String password = null;

        String captcha = null;
        String captchaMd5 = null;
        Integer loginAttempts = null;
        boolean loginWithoutCaptchaOK = true;

        // Get captcha info
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            captcha = request.getParameter("j_captcha");
            if (captcha != null) {
                captcha = captcha.toUpperCase();
            }


            HttpSession session = request.getSession(true);
            captchaMd5 = (String) session.getAttribute("captcha");
            loginAttempts = (Integer) session.getAttribute("loginAttempts");

            System.out.println("ina loginAttempts:" + loginAttempts);

            if (loginAttempts != null && loginAttempts > 0) {

                // assume that, capcha must be entered
                loginWithoutCaptchaOK = false;

                // login attempt more than one, check captcha
                MD5 md5 = new MD5();
                String captchaHere = md5.getMD5(captcha);
                if (captchaHere.equals(captchaMd5)) {
                    loginWithoutCaptchaOK = true;
                    loginAttempts = 1;
                    session.setAttribute("loginAttempts", loginAttempts);
                } else {
                    loginWithoutCaptchaOK = false;
                    loginAttempts++;
                    session.setAttribute("loginAttempts", loginAttempts);
                }

            } else {
                // captcha no need to check
                loginWithoutCaptchaOK = true;
                loginAttempts = 1;
                session.setAttribute("loginAttempts", loginAttempts);
            }
        } catch (Exception e) {
            captcha = null;
        }

        SecurityLoggedUser securityLoggedUser;

//        System.out.println("ina captcha:" + captcha);
//        System.out.println("ina captchaMd5:" + captchaMd5);
//        System.out.println("ina loginAttempts:" + loginAttempts);

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        if (authentication.getPrincipal() != null)
            login = authentication.getPrincipal().toString();

        if (login == null)
            login = "";

        if (authentication.getCredentials() != null)
            password = authentication.getCredentials().toString();
        if (password == null)
            password = "";

/*
        String userlogin = "tester";
        String passphrase = "123";
        authenticated = login.equalsIgnoreCase(userlogin) && password.equals(passphrase);
*/

        boolean authenticated = false;
        login = login.toLowerCase();
        if (!login.isEmpty() && loginWithoutCaptchaOK) {
            User user = securityService.getUserByLogin(login);
            if (user != null) {
                MD5 md5 = new MD5();
                password = md5.getMD5(password);
                authenticated = user.getLogin().equalsIgnoreCase(login) && user.getPassword() != null && user.getPassword().equals(password);
                if (authenticated) {

                    logger.info("Authentication SUCCESS, login: {}", login);
//                    adminJournalSignIn.logSingIn(Constants.JOURNAL_ACT_LOGIN, Constants.JOURNAL_LOGIN_SUCCESS, user);// todo put userId

/*
                    // tester roles
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_OPERATOR"));
*/

                    RoleConfiguration roleConfiguration = appConfiguration.getRoleConfiguration();
                    List<UserRole> userRoles = securityService.getUserRoles(user.getId());
                    if (userRoles != null) {
                        for (UserRole userRole : userRoles) {
                            for (RoleInfo roleInfo : roleConfiguration.getRoleInfo()) {
                                if (roleInfo.getId() == userRole.getRoleId()) {
                                    String strAuthType = roleInfo.getType();
                                    grantedAuthorities.add(new SimpleGrantedAuthority(strAuthType));
                                    break;
                                }
                            }

                        }
                    }

                    // check is there at least one role
                    if (grantedAuthorities.size() == 0)
                        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));

                    securityLoggedUser = new SecurityLoggedUser(login, password, grantedAuthorities, user);
                    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(securityLoggedUser, authentication, grantedAuthorities);
                    result.setDetails((authentication.getDetails() != null) ? authentication.getDetails() : null);
                    return result;
                }
            }
        }


        logger.info("Authentication FAILED, login: {}", login);
//        adminJournalSignIn.logSingInError(Constants.JOURNAL_ACT_LOGIN, Constants.JOURNAL_LOGIN_FAIL, login);
        throw new BadCredentialsException("Bad credentials presented");

        // if (this.context != null)
        // {
        //  context.publishEvent(new AuthenticationSuccessEvent(authentication /*, (UserDetails) user*/));
        // }

        // Object principalToReturn = user;
    }
}
