package uz.tiu.daily.controllers.admin.reestr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.tiu.daily.common.pagination.Pagination;
import uz.tiu.daily.persistence.Dalolatnoma;
import uz.tiu.daily.persistence.Reestr;
import uz.tiu.daily.services.menuServices.DalolatnomaService;
import uz.tiu.daily.services.menuServices.ReestrService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Controller
public class ReestrController {
    public static final String URL_REESTR = "/admin/reestr.htm";
    private static final String VIEW_REESTR = "admin/reestr/reestr";

    public static final String URL_REESTR_EDIT = "/admin/reestr-edit.htm";
    public static final String VIEW_REEESTR_EDIT = "admin/reestr/reestr-edit";


    public static final String URL_REESTR_SAVE = "/admin/reestr-save.htm";

    private static final String URL_REESTR_TABLE = "/admin/reestr-table.htm";
    private static final String VIEW_REESTR_TABLE = "admin/reestr/reestr-table";

    public static final String URL_REESTR_LIST = "/admin/reestr-list.htm";
    private static final String VIEW_REESTR_LIST = "admin/reestr/reestr-list";

    private static final String URL_REESTR_DELETE = "/admin/reestr-delete.htm";



    @Autowired
    ReestrService reestrService;

    @RequestMapping(value = URL_REESTR)
    public ModelAndView main(HttpSession session,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int pageId){
        ModelAndView modelAndView = new ModelAndView(VIEW_REESTR);
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
        List<Reestr> reestrList= reestrService.getAllList(pageId);

        Pagination pagination = new Pagination();
        Long reestrCount  =  reestrService.countReestr();
        Integer count = Integer.valueOf(reestrCount.intValue());
        pagination.getPaginations(modelAndView, pageId, count);

        modelAndView.addObject("reestr",reestrList);


    }

}
