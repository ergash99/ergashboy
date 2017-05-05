package uz.tiu.daily.controllers.admin.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.tiu.daily.common.pagination.Pagination;
import uz.tiu.daily.persistence.Test;
import uz.tiu.daily.persistence.User;
import uz.tiu.daily.services.menuServices.TestService;
import uz.tiu.daily.services.UsersService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Controller
public class TestController {
    public static final String URL_TEST = "/admin/test.htm";
    private static final String VIEW_TEST = "admin/test/test";

    public static final String URL_TEST_EDIT = "/admin/test-edit.htm";
    public static final String VIEW_TEST_EDIT = "admin/test/test-edit";


    public static final String URL_TEST_SAVE = "/admin/test-save.htm";

    private static final String URL_TEST_TABLE = "/admin/test-table.htm";
    private static final String VIEW_TEST_TABLE = "admin/test/test-table";

    public static final String URL_TEST_LIST = "/admin/test-list.htm";
    private static final String VIEW_TEST_LIST = "admin/test/test-list";

    private static final String URL_TEST_DELETE = "/admin/test-delete.htm";

    @Autowired
    TestService testService;

    @RequestMapping(value = URL_TEST)
    public ModelAndView main(HttpSession session,
                             @RequestParam(value = "page", required = false, defaultValue = "0") int pageId){
        ModelAndView modelAndView = new ModelAndView(VIEW_TEST);
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
        List<Test> testCount = testService.getAllList(pageId);

        Pagination pagination = new Pagination();
        Long testCount1  =  testService.countTest();
        Integer countTest = Integer.valueOf(testCount1.intValue());
        pagination.getPaginations(modelAndView, pageId, countTest);

        modelAndView.addObject("list",testCount);


    }


}
