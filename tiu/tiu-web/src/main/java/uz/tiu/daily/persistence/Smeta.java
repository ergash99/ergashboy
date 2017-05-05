package uz.tiu.daily.persistence;

import org.hibernate.annotations.ManyToAny;
import uz.tiu.daily.common.TableName;
import uz.tiu.daily.persistence.share.DataBaseObject;

import javax.persistence.*;

/**
 * Created by ERGASHBOY_JAVA on 22.04.17.
 */
@Entity
@Table(name= TableName.SMETA)
public class Smeta extends DataBaseObject {

    @ManyToOne
    @JoinColumn(name = "dm_aat")
    private DM_AAT dm_aat;

    @Column(name="buyurtma_raqami")
    private Long buyurtma_raqami;

    @Column(name="buyurtma_sanasi")
    private String buyurtma_sanasi;

    @Column(name="smeta_sanasi")
    private  String smeta_sanasi;

    @ManyToOne
    @JoinColumn(name = "smeta_holati")
    private Smeta_holati smeta_holati;


    @Column(name="ishni_boshlash_sanasi")
    private String ishni_boshlash_sanasi;

    @Column(name="smeta_raqami")
    private String smeta_raqami;

    public String getSmeta_raqami() {
        return smeta_raqami;
    }

    public void setSmeta_raqami(String smeta_raqami) {
        this.smeta_raqami = smeta_raqami;
    }

    @Column(name="avans_sanasi")
    private String avans_sanasi;

    @Column(name="ish_summasi")
    private  String ish_summasi;


    public DM_AAT getDm_aat() {
        return dm_aat;
    }

    public void setDm_aat(DM_AAT dm_aat) {
        this.dm_aat = dm_aat;
    }

    public Long getBuyurtma_raqami() {
        return buyurtma_raqami;
    }

    public void setBuyurtma_raqami(Long buyurtma_raqami) {
        this.buyurtma_raqami = buyurtma_raqami;
    }

    public String getBuyurtma_sanasi() {
        return buyurtma_sanasi;
    }

    public void setBuyurtma_sanasi(String buyurtma_sanasi) {
        this.buyurtma_sanasi = buyurtma_sanasi;
    }

    public String getSmeta_sanasi() {
        return smeta_sanasi;
    }

    public void setSmeta_sanasi(String smeta_sanasi) {
        this.smeta_sanasi = smeta_sanasi;
    }

    public Smeta_holati getSmeta_holati() {
        return smeta_holati;
    }

    public void setSmeta_holati(Smeta_holati smeta_holati) {
        this.smeta_holati = smeta_holati;
    }

    public String getIshni_boshlash_sanasi() {
        return ishni_boshlash_sanasi;
    }

    public void setIshni_boshlash_sanasi(String ishni_boshlash_sanasi) {
        this.ishni_boshlash_sanasi = ishni_boshlash_sanasi;
    }

    public String getAvans_sanasi() {
        return avans_sanasi;
    }

    public void setAvans_sanasi(String avans_sanasi) {
        this.avans_sanasi = avans_sanasi;
    }

    public String getIsh_summasi() {
        return ish_summasi;
    }

    public void setIsh_summasi(String ish_summasi) {
        this.ish_summasi = ish_summasi;
    }
}
