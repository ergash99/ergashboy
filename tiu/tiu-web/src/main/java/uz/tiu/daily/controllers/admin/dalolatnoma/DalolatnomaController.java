package uz.tiu.daily.controllers.admin.dalolatnoma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.tiu.daily.common.pagination.Pagination;
import uz.tiu.daily.persistence.Dalolatnoma;
import uz.tiu.daily.persistence.User;
import uz.tiu.daily.services.menuServices.DalolatnomaService;
import uz.tiu.daily.services.UsersService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
* Created by ERGASHBOY_JAVA on 22.04.17.
*/
@Controller
public class DalolatnomaController {

    public static final String URL_DALOLATNOMA = "/admin/dalolatnoma.htm";
    private static final String VIEW_DALOLATNOMA = "admin/dalolatnoma/dalolatnoma";

    public static final String URL_DALOLATNOMA_EDIT = "/admin/dalolatnoma-edit.htm";
    public static final String VIEW_DALOLATNOMA_EDIT = "admin/dalolatnoma/dalolatnoma-edit";


    public static final String URL_DALOLATNOMA_SAVE = "/admin/dalolatnoma-save.htm";

    private static final String URL_DALOLATNOMA_TABLE = "/admin/dalolatnoma-table.htm";
    private static final String VIEW_DALOLATNOMA_TABLE = "admin/dalolatnoma/dalolatnoma-table";

    public static final String URL_DALOLATNOMA_LIST = "/admin/dalolatnoma-list.htm";
    private static final String VIEW_DALOLATNOMA_LIST = "admin/dalolatnoma/dalolatnoma-list";

    private static final String URL_DALOLATNOMA_DELETE = "/admin/dalolatnoma-delete.htm";
    @Autowired
    DalolatnomaService dalolatnomaService;
    @RequestMapping(value = URL_DALOLATNOMA)
    public ModelAndView main(HttpSession session,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int pageId){
        ModelAndView modelAndView = new ModelAndView(VIEW_DALOLATNOMA);
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
        List<Dalolatnoma> dalolatnomaList= dalolatnomaService.getAllList(pageId);

        Pagination pagination = new Pagination();
        Long dalolatnomaCount  =  dalolatnomaService.countDalolatnoma();
        Integer countUsers = Integer.valueOf(dalolatnomaCount.intValue());
        pagination.getPaginations(modelAndView, pageId, countUsers);

        modelAndView.addObject("users",dalolatnomaList);


    }

}
