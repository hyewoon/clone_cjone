package com.example.clone_cjone.cvg;

import java.io.Serializable;

public class CgvDTO implements Serializable {

    private int imgRes, rank;
    private String title, box_office;

    public CgvDTO(int imgRes, int rank, String title, String box_office) {
        this.imgRes = imgRes;
        this.rank = rank;
        this.title = title;
        this.box_office = box_office;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBox_office() {
        return box_office;
    }

    public void setBox_office(String box_office) {
        this.box_office = box_office;
    }
}