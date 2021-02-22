package com.ross.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View{
    MainScreenContract.Presenter presenter;
    TextView txtClientList,txtTitle;
    Button btnShowTitle;
    Boolean ShowTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarDatos();
    }

    @Override
    public void showClientes(List<String> listClientes) {
        txtClientList.setText("");
        for(int i=0; i<listClientes.size(); i++){
            txtClientList.append(String.valueOf(listClientes.get(i))+"\n");
        }
    }

    @Override
    public void showTitle() {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! LA LOGICA LA DEBE TENER EL PRESENTADOR
        /*btnShowTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtTitle.isShowingLayoutBounds()){
                    txtTitle.setVisibility(View.INVISIBLE);
                }else{
                    txtTitle.setVisibility(View.VISIBLE);
                }
            }
        });*/
        txtTitle.setVisibility(View.VISIBLE);
        ShowTitle = true;
    }

    @Override
    public void hideTitle() {
        txtTitle.setVisibility(View.INVISIBLE);
        ShowTitle = false;
    }

    @Override
    public boolean isTittleVisible() {
        return ShowTitle;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onViewDestroy();
    }

    private void inicializarDatos(){
        txtClientList = findViewById(R.id.txtClientesList);
        txtTitle = findViewById(R.id.txtTitle);
        btnShowTitle = findViewById(R.id.btnTitle);
        ShowTitle = true;


        presenter = new PresenterImple(this,new ModelMockImple());
        presenter.onViewCreate();
        inicializarListener();
    }

    private void inicializarListener(){
        btnShowTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onHideTitleButtonPressed();
            }
        });
    }
}