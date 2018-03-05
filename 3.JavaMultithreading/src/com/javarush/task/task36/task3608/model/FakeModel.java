package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Владимир on 10.09.2017.
 */
public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
       return modelData;
    }

    @Override
    public void loadUsers() {
       modelData.getUsers().add(new User("A",1,1));
       modelData.getUsers().add(new User("B",2,1));
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
