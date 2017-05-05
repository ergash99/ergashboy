package uz.tiu.daily.controllers.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.tiu.daily.common.Constants;
import uz.tiu.daily.common.pagination.Pagination;
import uz.tiu.daily.controllers.security.MD5;
import uz.tiu.daily.persistence.Managers;
import uz.tiu.daily.persistence.Role;
import uz.tiu.daily.persistence.User;
import uz.tiu.daily.persistence.UserRole;
import uz.tiu.daily.services.UsersService;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;


@Controller
public class UsersController {

    public static final String URL_USERS = "/admin/users.htm";
    private static final String VIEW_USERS = "admin/users/users";

    public static final String URL_USERS_EDIT = "/admin/users-edit.htm";
    public static final String VIEW_USERS_EDIT = "admin/users/users-edit";


    public static final String URL_SAVE = "/admin/users-save.htm";

    private static final String URL_USERS_TABLE = "/admin/users-table.htm";
    private static final String VIEW_USERS_TABLE = "admin/users/users-table";

    public static final String URL_USERS_LIST = "/admin/users-list.htm";
    private static final String VIEW_USERS_LIST = "admin/users/users-list";

    private static final String URL_USERS_DELETE = "/admin/users-delete.htm";



    @Autowired
    UsersService usersService;

    @RequestMapping(value = URL_USERS)
    public ModelAndView main(HttpSession session,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int pageId){
        ModelAndView modelAndView = new ModelAndView(VIEW_USERS);
        if (pageId < 0) {
            Integer pageNumberSession = (Integer) session.getAttribute("page");
            if (pageNumberSession != null) pageId = pageNumberSession;
        }
        if (pageId < 0) {
            pageId = 0;
        }
        if (pageId == 0)
            getList(modelAndView, 0);
        else getList(modelAndView, pageId);
        return modelAndView;
    }

    public void getList(ModelAndView modelAndView, Integer pageId){
        List<User> userList = usersService.getAllList(pageId);

        Pagination pagination = new Pagination();
        Long usersCount  =  usersService.countUsers();
        Integer countUsers = Integer.valueOf(usersCount.intValue());
        pagination.getPaginations(modelAndView, pageId, countUsers);

        modelAndView.addObject("users",userList);


    }

    @RequestMapping(value = URL_USERS_EDIT)
    public ModelAndView edit(@RequestParam(value = "id", required = false) Long id){
        ModelAndView modelAndView = new ModelAndView(VIEW_USERS_EDIT);
        List<Managers> managersList = usersService.getAllManagersList();
        if (id != null){
            User user = usersService.getUserById(id);
            modelAndView.addObject("user", user);

        }
        modelAndView.addObject("list", managersList);

        return modelAndView;
    }

    @RequestMapping(value = URL_SAVE)
    public ModelAndView save(@RequestParam(value = "id", required = false) Long id,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "last-name", required = false) String lastName,
                             @RequestParam(value = "midle-name", required = false) String midleName,
                             @RequestParam(value = "login", required = false) String login,
                             @RequestParam(value = "pass", required = false) String pass,
                             @RequestParam(value = "managers-id", required = false) Long managersId){


        User user = new User();
        List<Managers> managersList = usersService.getAllManagersList();
        Managers managers = usersService.getManagersById(managersId);
        user.setId(id);
        user.setName(name);
        user.setMiddleName(midleName);
        user.setSurName(lastName);
        user.setLogin(login);
        MD5 md5 = new MD5();
        String password = md5.getMD5(pass.trim());
        user.setPassword(password);
        user.setManagers(managers);

        if (id == null)
            user.setRegDate(new Timestamp(System.currentTimeMillis()));
        else
            user.setModDate(new Timestamp(System.currentTimeMillis()));
        user.setStatus("A");
        user.setBlock("A");

        User userChekLogin = usersService.getUserByLogin(login);
        if (userChekLogin != null && userChekLogin.getId() != id){
            ModelAndView modelAndViewToEdit = new ModelAndView(VIEW_USERS_EDIT);

            modelAndViewToEdit.addObject("user", user);
            modelAndViewToEdit.addObject("error", "bunday login mavjud");
            modelAndViewToEdit.addObject("roleList", managersList);
            return modelAndViewToEdit;
        }
        usersService.saveUser(user);
        if (id == null) {
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            Integer roleInt = managers.getUserTypeId();
            userRole.setRoleId(roleInt);

            usersService.saveUseRole(userRole);
        }


        return new ModelAndView("redirect:"+ URL_USERS);
    }
    @RequestMapping(value = URL_USERS_LIST)
    public ModelAndView viewList() {
        ModelAndView modelAndView = new ModelAndView(VIEW_USERS_LIST);
        getList(modelAndView,0);
        return modelAndView;

    }
    @RequestMapping(value = URL_USERS_DELETE)
    public ModelAndView delete(@RequestParam(value = "id", required = false) Long id){
        if (id != null){
            User user = usersService.getUserById(id);
            user.setStatus(Constants.STATUS_DELETE);
            user.setExpDate(new Timestamp(System.currentTimeMillis()));
            user.setBlock(Constants.STATUS_BLOCK);
            usersService.saveUser(user);
        }
        return new ModelAndView("redirect:"+ URL_USERS);
    }


}
