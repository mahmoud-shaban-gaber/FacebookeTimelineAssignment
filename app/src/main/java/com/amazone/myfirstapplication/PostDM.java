package com.amazone.myfirstapplication;

public class PostDM {

    int profileIconImageResourse;
    int shareIcon;
     String acountName;
     String date;
    int audience;
     String caption;
     int postImageRes;
     String likesNumber;
     String sharesNumber;

    public PostDM(int profileIconImageResourse, String acountName, String date, int audience, String caption, int postImageRes, String likesNumber, String sharesNumber) {

        this.profileIconImageResourse=profileIconImageResourse;
        shareIcon=profileIconImageResourse;
        this.acountName = acountName;
        this.date = date;
        this.audience=audience;
        this.caption = caption;
        this.postImageRes = postImageRes;
        this.likesNumber = likesNumber;
        this.sharesNumber = sharesNumber;
    }
}
