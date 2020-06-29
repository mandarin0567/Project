package com.example.lifemedicalinfo.domain.repository;

import java.io.Serializable;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class AED extends RealmObject implements Serializable {
    @PrimaryKey
    int id = 0;
    String buildAddress; //
    String buildPlace; //
    String clerkTel; //
    String distance;
    String manager;
    String managerTel;
    String mfg;
    String rnum;
    String wgs84Lat;
    String wgs84Lon;
    String zipcode1;
    String zipcode2;
    String model;

    public AED() {}

    public AED(AED other) {
        this.buildAddress = other.buildAddress;
        this.buildPlace = other.buildPlace;
        this.clerkTel = other.clerkTel;
        this.distance = other.distance;
        this.manager = other.manager;
        this.managerTel = other.managerTel;
        this.mfg = other.mfg;
        this.rnum = other.rnum;
        this.wgs84Lat = other.wgs84Lat;
        this.wgs84Lon = other.wgs84Lon;
        this.zipcode1 = other.zipcode1;
        this.zipcode2 = other.zipcode2;
        this.model = other.model;
        this.id = hashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildAddress() {
        return buildAddress;
    }

    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }

    public String getBuildPlace() {
        return buildPlace;
    }

    public void setBuildPlace(String buildPlace) {
        this.buildPlace = buildPlace;
    }

    public String getClerkTel() {
        return clerkTel;
    }

    public void setClerkTel(String clerkTel) {
        this.clerkTel = clerkTel;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerTel() {
        return managerTel;
    }

    public void setManagerTel(String managerTel) {
        this.managerTel = managerTel;
    }

    public String getMfg() {
        return mfg;
    }

    public void setMfg(String mfg) {
        this.mfg = mfg;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getWgs84Lat() {
        return wgs84Lat;
    }

    public void setWgs84Lat(String wgs84Lat) {
        this.wgs84Lat = wgs84Lat;
    }

    public String getWgs84Lon() {
        return wgs84Lon;
    }

    public void setWgs84Lon(String wgs84Lon) {
        this.wgs84Lon = wgs84Lon;
    }

    public String getZipcode1() {
        return zipcode1;
    }

    public void setZipcode1(String zipcode1) {
        this.zipcode1 = zipcode1;
    }

    public String getZipcode2() {
        return zipcode2;
    }

    public void setZipcode2(String zipcode2) {
        this.zipcode2 = zipcode2;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "AED{" +
            "buildAddress='" + buildAddress + '\'' +
            ", buildPlace='" + buildPlace + '\'' +
            ", clerkTel='" + clerkTel + '\'' +
            ", distance='" + distance + '\'' +
            ", manager='" + manager + '\'' +
            ", managerTel='" + managerTel + '\'' +
            ", mfg='" + mfg + '\'' +
            ", rnum='" + rnum + '\'' +
            ", wgs84Lat='" + wgs84Lat + '\'' +
            ", wgs84Lon='" + wgs84Lon + '\'' +
            ", zipcode1='" + zipcode1 + '\'' +
            ", zipcode2='" + zipcode2 + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AED aed = (AED) o;

        if (buildAddress != null ? !buildAddress.equals(aed.buildAddress) : aed.buildAddress != null)
            return false;
        if (buildPlace != null ? !buildPlace.equals(aed.buildPlace) : aed.buildPlace != null)
            return false;
        if (clerkTel != null ? !clerkTel.equals(aed.clerkTel) : aed.clerkTel != null) return false;
        if (distance != null ? !distance.equals(aed.distance) : aed.distance != null) return false;
        if (manager != null ? !manager.equals(aed.manager) : aed.manager != null) return false;
        if (managerTel != null ? !managerTel.equals(aed.managerTel) : aed.managerTel != null)
            return false;
        if (mfg != null ? !mfg.equals(aed.mfg) : aed.mfg != null) return false;
        if (rnum != null ? !rnum.equals(aed.rnum) : aed.rnum != null) return false;
        if (wgs84Lat != null ? !wgs84Lat.equals(aed.wgs84Lat) : aed.wgs84Lat != null) return false;
        if (wgs84Lon != null ? !wgs84Lon.equals(aed.wgs84Lon) : aed.wgs84Lon != null) return false;
        if (zipcode1 != null ? !zipcode1.equals(aed.zipcode1) : aed.zipcode1 != null) return false;
        if (zipcode2 != null ? !zipcode2.equals(aed.zipcode2) : aed.zipcode2 != null) return false;
        return model != null ? model.equals(aed.model) : aed.model == null;
    }

    @Override
    public int hashCode() {
        int result = buildAddress != null ? buildAddress.hashCode() : 0;
        result = 31 * result + (buildPlace != null ? buildPlace.hashCode() : 0);
        result = 31 * result + (clerkTel != null ? clerkTel.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (managerTel != null ? managerTel.hashCode() : 0);
        result = 31 * result + (mfg != null ? mfg.hashCode() : 0);
        result = 31 * result + (rnum != null ? rnum.hashCode() : 0);
        result = 31 * result + (wgs84Lat != null ? wgs84Lat.hashCode() : 0);
        result = 31 * result + (wgs84Lon != null ? wgs84Lon.hashCode() : 0);
        result = 31 * result + (zipcode1 != null ? zipcode1.hashCode() : 0);
        result = 31 * result + (zipcode2 != null ? zipcode2.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
