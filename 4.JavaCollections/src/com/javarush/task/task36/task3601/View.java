package com.javarush.task.task36.task3601;

/**
 * Created by Владимир on 30.10.2017.
 */
public class View {
Model model = new Model();
    private Controller controller = new Controller();

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());

    }
}
