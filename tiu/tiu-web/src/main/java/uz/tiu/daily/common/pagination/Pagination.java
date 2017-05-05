package uz.tiu.daily.common.pagination;

import org.springframework.web.servlet.ModelAndView;
import uz.tiu.daily.common.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Pagination  {

    public void getPaginations(ModelAndView modelAndView, Integer pageId, Integer objCount){

        int pagesCount = (objCount + Constants.LIST_PER_PAGE - 1) / Constants.LIST_PER_PAGE;
        List<Integer> pagination = getPages(pageId, pagesCount);
        modelAndView.addObject("pageId", pageId);
        modelAndView.addObject("pagesList", pagination);
        modelAndView.addObject("pages", pagesCount);
//        modelAndView.addObject("paginationUrl", url + "?page=");
    }

    private List<Integer> getPages(java.lang.Integer currentPage, java.lang.Integer maxPages) {
        List<java.lang.Integer> list = new ArrayList<>();
        if (currentPage != null && maxPages != null) {
            if (maxPages > 0) list.add(0); // 1 page
            if (maxPages > 1) list.add(1); // 2 page
            if (maxPages > 2) list.add(2); // 3 page

            if (currentPage > 1) {
                if (!list.contains(currentPage - 1) && (currentPage - 1 < maxPages))
                    list.add(currentPage - 1); // current - 1

                if (!list.contains(currentPage) && (currentPage < maxPages))
                    list.add(currentPage); // current

                if (!list.contains(currentPage + 1) && (currentPage + 1 < maxPages))
                    list.add(currentPage + 1); // current + 1
            }


            if (!list.contains(maxPages - 3) && (maxPages - 3 > 0)) list.add(maxPages - 3); // last-2 page
            if (!list.contains(maxPages - 2) && (maxPages - 3 > 0)) list.add(maxPages - 2); // last-1 page
            if (!list.contains(maxPages - 1) && (maxPages - 3 > 0)) list.add(maxPages - 1); // last page

            Collections.sort(list);

        }
        return list;
    }
}
