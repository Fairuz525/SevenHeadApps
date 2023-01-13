package com.sevenhead.barber.Domain;

import java.io.Serializable;

public class CutDomain implements Serializable {
    private String title;
    private String pic;
    private int numberInCard;

    public CutDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }

    public CutDomain(String title, String pic, int numberInCard) {
        this.title = title;
        this.pic = pic;
        this.numberInCard = numberInCard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }
}
