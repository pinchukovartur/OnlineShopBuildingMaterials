package ru.pinch;

import ru.pinch.service.ApplicationMailer;

public class TClass {

    private static ApplicationMailer tlsSender = new ApplicationMailer();

    public static void main(String[] args){
        tlsSender.send("This is Subject", "TLS: This is text!", "pinchukovartur@gmail.com", "pinchukovartur@gmail.com");
    }
}
