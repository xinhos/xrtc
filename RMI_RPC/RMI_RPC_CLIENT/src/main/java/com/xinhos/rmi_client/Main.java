package com.xinhos.rmi_client;

import com.xinhos.rmi_api.Action;
import java.rmi.Naming;

public class Main {
    public static void main(String[] args) {
        Action aAction = null;
        try {
            aAction = (Action) Naming.lookup("rmi://localhost:11111/action");
            String info = aAction.sayHello("xinhos");
            System.out.println(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
