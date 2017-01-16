package ru.pinch;

import ru.pinch.service.ApplicationMailer;

import java.util.Locale;
import java.util.ResourceBundle;

public class TClass {

    public static void main(String [] arg)
    {
        ResourceBundle res = ResourceBundle.getBundle("messages");
        System.out.println(res.getString("label.color"));
    }
}
