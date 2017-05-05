package uz.tiu.daily.controllers.admin.Hisobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.tiu.daily.common.pagination.Pagination;
import uz.tiu.daily.persistence.Hisobot;
import uz.tiu.daily.persistence.User;
import uz.tiu.daily.services.menuServices.HisobotService;
import uz.tiu.daily.services.UsersService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Controller
public class HisobotController {
    public static final String URL_HISOBOT = "/admin/hisobot.htm";
    private static final String VIEW_HISOBOT = "admin/hisobot/hisobot";

    public static final String URL_HISOBOT_EDIT = "/admin/hisobot-edit.htm";
    public static final String VIEW_USERS_EDIT = "admin/hisobot/hisobot-edit";


    public static final String URL_SAVE = "/admin/users-save.htm";

    private static final String URL_USERS_TABLE = "/admin/users-table.htm";
    private static final String VIEW_USERS_TABLE = "admin/users/users-table";

    public static final String URL_USERS_LIST = "/admin/users-list.htm";
    private static final String VIEW_USERS_LIST = "admin/users/users-list";

    private static final String URL_USERS_DELETE = "/admin/users-delete.htm";



    @Autowired
    HisobotService hisobotService;

    @RequestMapping(value = URL_HISOBOT)
    public ModelAndView main(HttpSession session,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int pageId){
        ModelAndView modelAndView = new ModelAndView(VIEW_HISOBOT);
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
        List<Hisobot> userHisobot = hisobotService.getAllList(pageId);

        Pagination pagination = new Pagination();
        Long usersHisobot  =  hisobotService.countHisobot();
        Integer countHisobot = Integer.valueOf(usersHisobot.intValue());
        pagination.getPaginations(modelAndView, pageId, countHisobot);

        modelAndView.addObject("hisobot",userHisobot);


    }

}
