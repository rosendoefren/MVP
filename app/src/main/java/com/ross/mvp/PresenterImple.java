package com.ross.mvp;

import java.util.List;

public class PresenterImple implements  MainScreenContract.Presenter {
    MainScreenContract.View view;
    MainScreenContract.Model model;

    public PresenterImple(MainScreenContract.View view, MainScreenContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void listClientes() {
        List<String> clientes = model.geClientes();
        view.showClientes(clientes);
    }

    @Override
    public void  onHideTitleButtonPressed() {

        if(view.isTittleVisible()){
            view.hideTitle();
        }else{
            view.showTitle();
        }
    }

    @Override
    public void onViewCreate() {
        listClientes();
    }

    @Override
    public void onViewDestroy() {
        view = null;
    }
}
