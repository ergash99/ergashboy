package uz.tiu.daily.controllers.admin.topshiriq;
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
import uz.tiu.daily.services.menuServices.TopshiriqService;
import uz.tiu.daily.services.UsersService;
import uz.tiu.daily.services.topshiriqMenuServices.*;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by ERGASHBOY_JAVA on 20.04.17.
 */
@Controller
public class TopshiriqController {
    public static final String URL_TOPSHIRIQ = "/topshiriq.htm";
    public static final String VIEW_TOPSHIRIQ = "admin/topshiriq/topshiriq";
    public static final String URL_TOPSHIRIQ_EDIT = "/topshiriq-edit.htm";
    public static final String VIEW_TOPSHIRIQ_EDIT = "admin/topshiriq/topshiriq-edit";
  //  public static final String URL_TOPSHIRIQ_DELETE = "admin/topshiriq/topshiriq-edit";
    public static final String URL_TOPSHIRIQ_SAVE = "/topshiriq-save.htm";
    private static final String URL_TOPSHIRIQ_DELETE = "/admin/topshiriq-delete.htm";
    @Autowired
    UsersService usersService;
    @Autowired
    TopshiriqService topshiriqService;

    @Autowired
    Topshiriq_turiServices topshiriq_turiServices;

    @Autowired
    DM_AATServices dm_aatServices;

    @Autowired
    Tashabbuschi_tuzilmaServices tashabbuschi_tuzilmaServices;

    @Autowired
    Kelishilgan_bulinmaServices kelishilgan_bulinmaServices;

    @Autowired
    Topshiriq_holatiServices topshiriq_holatiServices;

    @Autowired
    Buyurtma_holatiServices buyurtma_holatiServices;




    private FileStorageService storageService;

    @RequestMapping(value = URL_TOPSHIRIQ)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView(VIEW_TOPSHIRIQ);
        getList(modelAndView,0);
        return modelAndView;
    }

    public void getList(ModelAndView modelAndView, int pageId) {
        List<Topshiriq> topshiriqs = topshiriqService.getTopshiriqList(pageId);

        modelAndView.addObject("list", topshiriqs);

        Integer count = topshiriqService.getCount();
        Pagination pagination = new Pagination();
        pagination.getPaginations(modelAndView, pageId, count);
    }

    @RequestMapping(value = URL_TOPSHIRIQ_EDIT)
    public ModelAndView edit(@RequestParam(value = "id", required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView(VIEW_TOPSHIRIQ_EDIT);
        List<Topshiriq_turi> topshriq_turi = topshiriq_turiServices.getTopshiriq_turiList();
        List<DM_AAT> dm_aats = dm_aatServices.getDM_AATList();
        List<Tashabbuschi_tuzilma> tashabbuschi_tuzilmas = tashabbuschi_tuzilmaServices.getTashabbuschi_tuzilmaList();
        List<Kelishilgan_bulinmalar> kelishilgan_bulinmalars = kelishilgan_bulinmaServices.getKelishilgan_bulinmalarList();
        List<Topshiriq_holati> topshiriq_holatis = topshiriq_holatiServices.getTopshiriq_holatiList();
      List<Buyurtma_holati> buyurtma_holatis = buyurtma_holatiServices.getBuyurtma_holatiList();
        modelAndView.addObject("topshriq_turi",topshriq_turi);
        modelAndView.addObject("dm_aats",dm_aats);
        modelAndView.addObject("tashabbuschi_tuzilmas",tashabbuschi_tuzilmas);
        modelAndView.addObject("kelishilgan_bulinmalars", kelishilgan_bulinmalars);
        modelAndView.addObject("topshiriq_holatis", topshiriq_holatis);
        modelAndView.addObject("buyurtma_holatis", buyurtma_holatis);
        if (id != null) {
            Topshiriq topshiriq = topshiriqService.getTopshiriqById(id);
            modelAndView.addObject("topshiriq", topshiriq);
        }

        return modelAndView;
    }


    @RequestMapping(value = URL_TOPSHIRIQ_SAVE)
    public ModelAndView save(@RequestParam(value = "id", required = false) Long id,
                             @RequestParam(value = "topshiriq_turi", required = false) Long topshiriq_turi,
                             @RequestParam(value = "sana", required = false) String sana,
                             @RequestParam(value = "dm_aat", required = false) Long dm_aatId,
                             @RequestParam(value = "tashabbuschi_tuzilma", required = false) Long tashabbuschi_tuzilmaId,
                             @RequestParam(value = "kelishilgan_bulinmalar", required = false) Long kelishilgan_bulinmalarId,
                             @RequestParam(value = "asos", required = false) String asos,
                             @RequestParam(value = "mazmuni", required = false) String mazmuni,
                             @RequestParam(value = "topshiriq_holati", required = false) Long topshiriq_holatiId,
                             @RequestParam(value = "buyurtma_raqami", required = false) String buyurtma_raqami,
                             @RequestParam(value = "date", required = false) String date,
                             @RequestParam(value = "buyurtma_holati", required = false) Long buyurtma_holatiId,
                             @RequestParam(value = "file", required = false) MultipartFile file
                             )throws ServletException, IOException{
        Topshiriq topshiriq = new Topshiriq();
        topshiriq.setId(id);

        Topshiriq_turi topshiriqTuri = topshiriq_turiServices.getTopshiriq_turiById(topshiriq_turi);

        DM_AAT dm_aat = dm_aatServices.getDM_AATById(dm_aatId);
        Tashabbuschi_tuzilma tashabbuschi_tuzilma = tashabbuschi_tuzilmaServices.getTashabbuschi_tuzilmaId(tashabbuschi_tuzilmaId);
        Kelishilgan_bulinmalar kelishilgan_bulinmalar = kelishilgan_bulinmaServices.getKelishilgan_bulinmalarId(kelishilgan_bulinmalarId);
         topshiriq.setAsos(asos);
        topshiriq.setMazmuni(mazmuni);
        topshiriq.setSana(sana);

       Topshiriq_holati topshiriq_holati=topshiriq_holatiServices.getTopshiriq_holatiById(topshiriq_holatiId);
        topshiriq.setBuyurtma_raqami(buyurtma_raqami);

        Buyurtma_holati buyurtma_holati=buyurtma_holatiServices.getBuyurtma_holatiById(buyurtma_holatiId);

         topshiriq.setTopshiriq_turi(topshiriqTuri);
        topshiriq.setDm_aat(dm_aat);
        topshiriq.setTashabbuschi_tuzilma(tashabbuschi_tuzilma);
        topshiriq.setKelishilgan_bulinmalar(kelishilgan_bulinmalar);
       topshiriq.setTopshiriq_holati(topshiriq_holati);
        topshiriq.setBuyurtma_holati(buyurtma_holati);


        topshiriq.setStatus("A");
        topshiriqService.save(topshiriq);
        return new ModelAndView("redirect:" + URL_TOPSHIRIQ);
    }
    @RequestMapping(value = URL_TOPSHIRIQ_DELETE)
    public ModelAndView delete(@RequestParam(value = "id", required = false) Long id){
        if (id != null){
            Topshiriq topshiriq = topshiriqService.getTopshiriqById(id);
            topshiriq.setStatus(Constants.STATUS_DELETE);
            topshiriq.setExpiredDate(new Timestamp(System.currentTimeMillis()));
            topshiriqService.save(topshiriq);
        }
        return new ModelAndView("redirect:"+ URL_TOPSHIRIQ);

    }

}
