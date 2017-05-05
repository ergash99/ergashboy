package uz.tiu.daily.controllers.admin.smeta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import uz.tiu.daily.common.Constants;
import uz.tiu.daily.common.FileStorageService;
import uz.tiu.daily.common.pagination.Pagination;
import uz.tiu.daily.persistence.*;
import uz.tiu.daily.services.menuServices.SmetaService;
import uz.tiu.daily.services.UsersService;
import uz.tiu.daily.services.menuServices.TopshiriqService;
import uz.tiu.daily.services.smetaMenuServices.Buyurtma_raqamiServices;
import uz.tiu.daily.services.smetaMenuServices.Smeta_holatiServices;
import uz.tiu.daily.services.topshiriqMenuServices.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Controller
public class SmetaController {

    public static final String URL_SMETA = "/smeta.htm";
    public static final String VIEW_SMETA = "admin/smeta/smeta";
    public static final String URL_SMETA_EDIT = "/smeta-edit.htm";
    public static final String VIEW_SMETA_EDIT = "admin/smeta/smeta-edit";

    public static final String URL_SMETA_SAVE = "/smeta-save.htm";
    private static final String URL_SMETA_DELETE = "/admin/smeta-delete.htm";
    @Autowired
    SmetaService smetaService;
    @Autowired
    TopshiriqService topshiriqService;



    @Autowired
    DM_AATServices dm_aatServices;


    @Autowired
    Buyurtma_raqamiServices buyurtma_raqamiServices;

    @Autowired
    Smeta_holatiServices smeta_holatiServices;



    private FileStorageService storageService;

    @RequestMapping(value = URL_SMETA)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView(VIEW_SMETA);
        getList(modelAndView,0);
        return modelAndView;
    }

    public void getList(ModelAndView modelAndView, int pageId) {
        List<Smeta> smetas = smetaService.getSmetaList(pageId);

        modelAndView.addObject("smeta", smetas);

        Integer count = smetaService.getCount();
        Pagination pagination = new Pagination();
        pagination.getPaginations(modelAndView, pageId, count);
    }

    @RequestMapping(value = URL_SMETA_EDIT)
    public ModelAndView edit(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_SMETA_EDIT);
        List<Smeta_holati> smeta_holati = smeta_holatiServices.getSmeta_holatiList();
        modelAndView.addObject("smeta_holati",smeta_holati);
        List<DM_AAT> dm_aat = dm_aatServices.getDM_AATList();
        modelAndView.addObject("dm_aat",dm_aat);

        if (id != null) {
            Smeta smeta = smetaService.getSmetaById(id);
            modelAndView.addObject("smeta", smeta);
        }

        return modelAndView;
    }


    @RequestMapping(value = URL_SMETA_SAVE)
    public ModelAndView save(@RequestParam(value = "id", required = false) Long id,
                             @RequestParam(value = "dm_aat", required = false) Long dm_aat,
                             @RequestParam(value = "buyurtma_raqami", required = false) Long buyurtma_raqami,
                             @RequestParam(value = "buyurtma_sanasi", required = false) String buyurtma_sanasi,
                             @RequestParam(value = "smeta_sanasi", required = false) String smeta_sanasi,

                             @RequestParam(value = "smeta_holati", required = false) Long smeta_holati,
                             @RequestParam(value = "ishni_boshlash_sanasi", required = false) String ishni_boshlash_sanasi,
                             @RequestParam(value = "smeta_raqami", required = false) String smeta_raqami,
                             @RequestParam(value = "avans_sanasi", required = false) String avans_sanasi,
                             @RequestParam(value = "ish_summasi", required = false) String ish_summasi

    )throws ServletException, IOException {
        Smeta smeta = new Smeta();
        smeta.setId(id);
//        Topshiriq topshiriqt=topshiriqService.getTopshiriqById(buyurtma_raqami);
//        smeta.setBuyurtma_raqami(buyurtma_raqami);
        DM_AAT dm_aat1 = dm_aatServices.getDM_AATById(dm_aat);
        smeta.setDm_aat(dm_aat1);
       smeta.setBuyurtma_sanasi(buyurtma_sanasi);
        smeta.setSmeta_sanasi(smeta_sanasi);
        Smeta_holati smeta_holati1=smeta_holatiServices.getSmeta_holatiById(smeta_holati);
        smeta.setSmeta_holati(smeta_holati1);

       smeta.setIshni_boshlash_sanasi(ishni_boshlash_sanasi);
       smeta.setSmeta_raqami(smeta_raqami);
        smeta.setAvans_sanasi(avans_sanasi);
        smeta.setIsh_summasi(ish_summasi);



        smeta.setStatus("A");
        smetaService.save(smeta);
        return new ModelAndView("redirect:" + URL_SMETA);
    }
    @RequestMapping(value = URL_SMETA_DELETE)
    public ModelAndView delete(@RequestParam(value = "id", required = false) Long id){
        if (id != null){
            Smeta smeta = smetaService.getSmetaById(id);
            smeta.setStatus(Constants.STATUS_DELETE);
            smeta.setExpiredDate(new Timestamp(System.currentTimeMillis()));
            smetaService.save(smeta);
        }
        return new ModelAndView("redirect:"+ URL_SMETA);

    }

}
