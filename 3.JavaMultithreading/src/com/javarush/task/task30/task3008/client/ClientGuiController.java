package com.javarush.task.task30.task3008.client;

/**
 * Created by Владимир on 29.09.2017.
 */
public class ClientGuiController extends Client {

    private final ClientGuiModel model=new ClientGuiModel();

    private  final ClientGuiView view=new ClientGuiView(this);


    public  class GuiSocketThread extends SocketThread{

        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }


    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    protected void sendTextMessage(String text) {
        super.sendTextMessage(text);
    }

    @Override
    public void run() {
        getSocketThread().run();
    }

    public ClientGuiModel getModel(){
        return model;
    }

    public static void main(String[] args) {
        new ClientGuiController().run();
    }
}
