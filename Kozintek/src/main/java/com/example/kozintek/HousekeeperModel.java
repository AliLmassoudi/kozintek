package com.example.kozintek;

import java.sql.Blob;


public class HousekeeperModel {
    Integer id,age,ranking,reviews;
    String firstname,monday,tuesday,wednesday,thursday,friday,saturday,sunday,cleaning,cooking,baby,lastname,email,city;
    Float score,pricing;
    Blob image;

    public HousekeeperModel(Integer id, Integer age, Integer ranking, Integer reviews, String firstname, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday, String cleaning, String cooking, String baby, String lastname, String email, String city, Float score, Float pricing, Blob image) {
        this.id = id;
        this.age = age;
        this.ranking = ranking;
        this.reviews = reviews;
        this.firstname    = firstname;
        this.lastname    = lastname;
        this.monday       = monday;
        this.tuesday      = tuesday;
        this.wednesday    = wednesday;
        this.thursday     = thursday;
        this.friday       = friday;
        this.saturday     = saturday;
        this.sunday      = sunday;
        this.cleaning    = cleaning;
        this.cooking     = cooking;
        this.baby        = baby;
        this.email       = email;
        this.city       = city;
        this.score       = score;
        this.pricing     = pricing;
        this.image      = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getCleaning() {
        return cleaning;
    }

    public void setCleaning(String cleaning) {
        this.cleaning = cleaning;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }

    public String getBaby() {
        return baby;
    }

    public void setBaby(String baby) {
        this.baby = baby;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getPricing() {
        return pricing;
    }

    public void setPricing(Float pricing) {
        this.pricing = pricing;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }
}