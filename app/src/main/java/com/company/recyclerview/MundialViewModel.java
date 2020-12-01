package com.company.recyclerview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MundialViewModel extends AndroidViewModel {

    ElementosRepositorio elementosRepositorio;

    MutableLiveData<List<Mundial>> listElementosMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Mundial> elementoSeleccionado = new MutableLiveData<>();

    public MundialViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio();

        listElementosMutableLiveData.setValue(elementosRepositorio.obtener());
    }


    MutableLiveData<List<Mundial>> obtener(){
        return listElementosMutableLiveData;
    }

    void insertar(Mundial elemento){
        elementosRepositorio.insertar(elemento, new ElementosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Mundial> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }

    void eliminar(Mundial elemento){
        elementosRepositorio.eliminar(elemento, new ElementosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Mundial> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        }); 
    }

    void actualizar(Mundial elemento, float valoracion){
        elementosRepositorio.actualizar(elemento, valoracion, new ElementosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Mundial> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }


    void seleccionar(Mundial elemento){
        elementoSeleccionado.setValue(elemento);
    }

    MutableLiveData<Mundial> seleccionado(){
        return elementoSeleccionado;
    }
}
