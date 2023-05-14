package com.example.app;

public class Question {
    int imageId;
    float percentLeft;
    float percentTop;
    int buttonId;
    String name;

    public Question(int imageId, float percentLeft, float percentTop, String name) {
        this.imageId = imageId;
        this.percentLeft = percentLeft;
        this.percentTop = percentTop;
        this.name=name;
    }
}




