package ru.unclediga.message;

import javax.validation.constraints.Size;

public class Address {
    @CountryId
    String countryCode;
    String post_index;
    @RegionId
    String regionCode;
    @Size(min = 2, max = 30)
    String rayon;
    @Size(min = 3, max = 30, message = "town length => 3..30")
    String town;
    @Size(min = 3, max = 30, message = "{javax.validation.constraints.Size.message}")
    String point;
    String street;
    String house;
    String corp;
    int flat;

    public Address(String countryCode, String post_index, String regionCode, String rayon,
                   String town, String point, String street, String house, String corp, int flat) {
        this.countryCode = countryCode;
        this.post_index = post_index;
        this.regionCode = regionCode;
        this.rayon = rayon;
        this.town = town;
        this.point = point;
        this.street = street;
        this.house = house;
        this.corp = corp;
        this.flat = flat;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPost_index() {
        return post_index;
    }

    public void setPost_index(String post_index) {
        this.post_index = post_index;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country_id=" + countryCode +
                ", post_index='" + post_index + '\'' +
                ", region_code=" + regionCode +
                ", rayon='" + rayon + '\'' +
                ", town='" + town + '\'' +
                ", point='" + point + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", corp='" + corp + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}
