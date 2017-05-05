package uz.tiu.daily.persistence;

import uz.tiu.daily.common.TableName;
import uz.tiu.daily.persistence.share.DataBaseObject;

import javax.persistence.*;

/**
 * Created by ERGASHBOY_JAVA on 20.04.17.
 */
@Entity
@Table(name= TableName.TOPSHIRIQ)
public class Topshiriq extends DataBaseObject {
    @Override
    public String toString() {
        return "Topshiriq{" +
                "topshiriq_turi=" + topshiriq_turi +
                ", sana='" + sana + '\'' +
                ", dm_aat=" + dm_aat +
                ", tashabbuschi_tuzilma=" + tashabbuschi_tuzilma +
                ", kelishilgan_bulinmalar=" + kelishilgan_bulinmalar +
                ", asos='" + asos + '\'' +
                ", mazmuni='" + mazmuni + '\'' +
                ", topshiriq_holati=" + topshiriq_holati +
                ", buyurtma_raqami='" + buyurtma_raqami + '\'' +
                ", date='" + date + '\'' +
                ", buyurtma_holati=" + buyurtma_holati +
                ", buyurtma_file=" + buyurtma_file +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "topshiriq_turi")
    private Topshiriq_turi topshiriq_turi;

    @Column(name="sana")
    private String sana;

    @ManyToOne
    @JoinColumn(name = "dm_aat")
    private DM_AAT dm_aat;

    @ManyToOne
    @JoinColumn(name = "tashabbuschi_tuzilma")
    private Tashabbuschi_tuzilma tashabbuschi_tuzilma;

    @ManyToOne
    @JoinColumn(name = "kelishilgan_bulinmalar")
    private Kelishilgan_bulinmalar kelishilgan_bulinmalar;

    @Column(name="asos")
    private String asos;

    @Column(name="mazmuni")
    private String mazmuni;

    @ManyToOne
    @JoinColumn(name = "topshiriq_holati")
    private Topshiriq_holati topshiriq_holati;

    public void setBuyurtma_raqami(String buyurtma_raqami) {
        this.buyurtma_raqami = buyurtma_raqami;
    }

    @Column(name="buyurtma_raqami")
    private String buyurtma_raqami;

    @Column(name="date")
    private String date;

    public String getBuyurtma_raqami() {
        return buyurtma_raqami;
    }

    @ManyToOne
    @JoinColumn(name = "buyurtma_holati")
    private Buyurtma_holati buyurtma_holati;

    @OneToOne
    @JoinColumn(name = "buyurtma_file")
    private FileStorage buyurtma_file;

    public Topshiriq_turi getTopshiriq_turi() {
        return topshiriq_turi;
    }

    public void setTopshiriq_turi(Topshiriq_turi topshiriq_turi) {
        this.topshiriq_turi = topshiriq_turi;
    }

    public String getSana() {
        return sana;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

    public DM_AAT getDm_aat() {
        return dm_aat;
    }

    public void setDm_aat(DM_AAT dm_aat) {
        this.dm_aat = dm_aat;
    }

    public Tashabbuschi_tuzilma getTashabbuschi_tuzilma() {
        return tashabbuschi_tuzilma;
    }

    public void setTashabbuschi_tuzilma(Tashabbuschi_tuzilma tashabbuschi_tuzilma) {
        this.tashabbuschi_tuzilma = tashabbuschi_tuzilma;
    }

    public Kelishilgan_bulinmalar getKelishilgan_bulinmalar() {
        return kelishilgan_bulinmalar;
    }

    public void setKelishilgan_bulinmalar(Kelishilgan_bulinmalar kelishilgan_bulinmalar) {
        this.kelishilgan_bulinmalar = kelishilgan_bulinmalar;
    }

    public String getAsos() {
        return asos;
    }

    public void setAsos(String asos) {
        this.asos = asos;
    }

    public String getMazmuni() {
        return mazmuni;
    }

    public void setMazmuni(String mazmuni) {
        this.mazmuni = mazmuni;
    }

    public Topshiriq_holati getTopshiriq_holati() {
        return topshiriq_holati;
    }

    public void setTopshiriq_holati(Topshiriq_holati topshiriq_holati) {
        this.topshiriq_holati = topshiriq_holati;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Buyurtma_holati getBuyurtma_holati() {
        return buyurtma_holati;
    }

    public void setBuyurtma_holati(Buyurtma_holati buyurtma_holati) {
        this.buyurtma_holati = buyurtma_holati;
    }

    public FileStorage getBuyurtma_file() {
        return buyurtma_file;
    }

    public void setBuyurtma_file(FileStorage buyurtma_file) {
        this.buyurtma_file = buyurtma_file;
    }
}
