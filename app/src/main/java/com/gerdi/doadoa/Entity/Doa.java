package com.gerdi.doadoa.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Doa {

    @PrimaryKey(autoGenerate = true)
    public int doaid;

    @ColumnInfo(name = "namaDoa")
    public String namaDoa;

    @ColumnInfo(name = "bacaDoa")
    public String bacaDoa;

    @ColumnInfo(name = "latinDoa")
    public String latinDoa;

    @ColumnInfo(name = "artiDoa")
    public String artiDoa;

    @ColumnInfo(name = "keutamaanDoa")
    public String keutamaanDoa;

    @ColumnInfo(name = "carabacaDoa")
    public String carabacaDoa;

    @ColumnInfo(name = "sumberDoa")
    public String sumberDoa;

    @ColumnInfo(name = "jenisDoa")
    public String jenisDoa;

    public String getCarabacaDoa() {
        return carabacaDoa;
    }

    public void setCarabacaDoa(String carabacaDoa) {
        this.carabacaDoa = carabacaDoa;
    }

    public int getDoaid() {
        return doaid;
    }

    public void setDoaid(int doaid) {
        this.doaid = doaid;
    }

    public String getNamaDoa() {
        return namaDoa;
    }

    public void setNamaDoa(String namaDoa) {
        this.namaDoa = namaDoa;
    }

    public String getBacaDoa() {
        return bacaDoa;
    }

    public void setBacaDoa(String bacaDoa) {
        this.bacaDoa = bacaDoa;
    }

    public String getLatinDoa() {
        return latinDoa;
    }

    public void setLatinDoa(String latinDoa) {
        this.latinDoa = latinDoa;
    }

    public String getArtiDoa() {
        return artiDoa;
    }

    public void setArtiDoa(String artiDoa) {
        this.artiDoa = artiDoa;
    }

    public String getKeutamaanDoa() {
        return keutamaanDoa;
    }

    public void setKeutamaanDoa(String keutamaanDoa) {
        this.keutamaanDoa = keutamaanDoa;
    }

    public String getSumberDoa() {
        return sumberDoa;
    }

    public void setSumberDoa(String sumberDoa) {
        this.sumberDoa = sumberDoa;
    }

    public String getJenisDoa() {
        return jenisDoa;
    }

    public void setJenisDoa(String jenisDoa) {
        this.jenisDoa = jenisDoa;
    }
}
