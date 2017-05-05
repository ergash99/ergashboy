package uz.tiu.daily.controllers.admin.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.tiu.daily.common.pagination.Pagination;
import uz.tiu.daily.persistence.Admin;
import uz.tiu.daily.services.menuServices.AdminService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
* Created by ERGASHBOY_JAVA on 22.04.17.
*/
@Controller
public class AdminController {
    public static final String URL_ADMIN = "/admin/admin.htm";
    private static final String VIEW_ADMIN = "admin/admin/admin";

    public static final String URL_ADMIN_EDIT = "/admin/admin-edit.htm";
    public static final String VIEW_ADMIN_EDIT = "admin/admin/admin-edit";


    public static final String URL_SAVE = "/admin/admin-save.htm";

    private static final String URL_ADMIN_TABLE = "/admin/admin-table.htm";
    private static final String VIEW_ADMIN_TABLE = "admin/admin/admin-table";

    public static final String URL_ADMIN_LIST = "/admin/admin-list.htm";
    private static final String VIEW_ADMIN_LIST = "admin/admin/admin-list";

    private static final String URL_ADMIN_DELETE = "/admin/admin-delete.htm";



    @Autowired
    AdminService adminService;

    @RequestMapping(value = URL_ADMIN)
    public ModelAndView main(HttpSession session,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int pageId){
        ModelAndView modelAndView = new ModelAndView(VIEW_ADMIN);
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
        List<Admin> adminList = adminService.getAllList(pageId);

        Pagination pagination = new Pagination();
        Long adminCount  =  adminService.countAdmin();
        Integer countAdmin = Integer.valueOf(adminCount.intValue());
        pagination.getPaginations(modelAndView, pageId, countAdmin);

        modelAndView.addObject("admin",adminList);


    }

}
