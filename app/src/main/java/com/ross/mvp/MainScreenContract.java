package com.ross.mvp;

import java.util.List;

public interface MainScreenContract {
    interface View{
        void showClientes(List<String> clientes);
        void showTitle();
        void hideTitle();
        boolean isTittleVisible();
    }

    interface Presenter{
        void listClientes();
        void onHideTitleButtonPressed();
        void onViewCreate();
        void onViewDestroy();
    }

    interface Model{
        List<String> geClientes();
    }
}
