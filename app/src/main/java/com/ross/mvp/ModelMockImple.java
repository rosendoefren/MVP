package com.ross.mvp;

import java.util.ArrayList;
import java.util.List;

public class ModelMockImple implements MainScreenContract.Model {
    List<String> clientes;

    public ModelMockImple(){
        clientes = new ArrayList<>();
        clientes.add("Arturo");
        clientes.add("Rosendo");
        clientes.add("Xiomara");
        clientes.add("Efren");
        clientes.add("EZI");

    }

    @Override
    public List<String> geClientes() {
        return clientes;
    }
}
