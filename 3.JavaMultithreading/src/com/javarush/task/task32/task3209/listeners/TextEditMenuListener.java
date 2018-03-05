package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.util.List;

/**
 * Created by Владимир on 07.10.2017.
 */
public class TextEditMenuListener implements MenuListener {

    private View view;


    @Override
    public void menuSelected(MenuEvent e) {
        JMenu jMenu = (JMenu) e.getSource();
        Component[] list=jMenu.getMenuComponents();
        for (Component aList : list) {
            aList.setEnabled(view.isHtmlTabSelected());
        }

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

    public TextEditMenuListener(View view) {
        this.view=view;
    }
}
