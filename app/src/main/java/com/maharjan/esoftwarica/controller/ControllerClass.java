package com.maharjan.esoftwarica.controller;

import com.maharjan.esoftwarica.model.UserData;

public class ControllerClass {
    public boolean CheckUser(UserData sd) {
        if ((sd.getName().equals("raja")) && (sd.getPassword().equals("1234"))) {
            return true;

        } else {
            return false;
        }
    }

}
