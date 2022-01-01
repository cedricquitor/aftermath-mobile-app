package com.cedric.aftermathproj;

public class CardModel {
    String firstTeam, secondTeam, firstTeamScore, secondTeamScore;
    int firstTeamImg, secondTeamImg;

    public CardModel(String firstTeam, String secondTeam, String firsTeamScore, String secondTeamScore, int firstTeamImg, int secondTeamImg) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamScore = firsTeamScore;
        this.secondTeamScore = secondTeamScore;
        this.firstTeamImg = firstTeamImg;
        this.secondTeamImg = secondTeamImg;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public String getFirsTeamScore() {
        return firstTeamScore;
    }

    public void setFirsTeamScore(String firsTeamScore) {
        this.firstTeamScore = firsTeamScore;
    }

    public String getSecondTeamScore() {
        return secondTeamScore;
    }

    public void setSecondTeamScore(String secondTeamScore) {
        this.secondTeamScore = secondTeamScore;
    }

    public int getFirstTeamImg() {
        return firstTeamImg;
    }

    public void setFirstTeamImg(int firstTeamImg) {
        this.firstTeamImg = firstTeamImg;
    }

    public int getSecondTeamImg() {
        return secondTeamImg;
    }

    public void setSecondTeamImg(int secondTeamImg) {
        this.secondTeamImg = secondTeamImg;
    }
}
