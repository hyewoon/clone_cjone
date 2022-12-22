package com.example.clone_cjone.mypoint;

public class MypointDTO {
    String date, reward, point;

    public MypointDTO(String date, String reward, String point) {

        this.date = date;
        this.reward = reward;
        this.point = point;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
