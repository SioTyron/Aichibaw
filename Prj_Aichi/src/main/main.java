package main;

import views.FConnexionView;
import controller.ConnexionController;

public class main {
    public static void main(String[] args) {
        FConnexionView frame = new FConnexionView();
        new ConnexionController(frame);
        frame.setVisible(true);
    }
}