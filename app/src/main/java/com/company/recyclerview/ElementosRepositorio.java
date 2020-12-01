package com.company.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class ElementosRepositorio {

    List<Mundial> elementos = new ArrayList<>();

    interface Callback {
        //mundial
        void cuandoFinalice(List<Mundial> elementos);
    }

    ElementosRepositorio(){
        elementos.add(new Mundial("Copa Mundial de Fútbol de 2018", "Esta fue la undécima vez que la Copa del Mundo se disputó en el continente europeo, y la primera que se celebró en Europa Oriental. También por primera vez, el torneo tiene lugar en dos continentes: Europa y Asia, dada la ubicación de la ciudad de Ekaterimburgo, una de las sedes."));
        elementos.add(new Mundial("Copa Mundial de Fútbol de 2014", "Fue la vigésima edición de la Copa Mundial de Fútbol. Se realizó en Brasil entre el 12 de junio y el 13 de julio de 2014, por segunda vez en dicho país, tras el campeonato de 1950."));
        elementos.add(new Mundial("Copa Mundial de Fútbol de 2010", "Fue la XIX edición de la Copa Mundial de Fútbol. La competición se celebró en Sudáfrica, entre el 11 de junio y el 11 de julio de ese año, siendo la primera vez que el torneo se disputaba en África y la quinta que lo hacía en el hemisferio sur, superando el país anfitrión en la elección previa a Egipto y Marruecos."));
        elementos.add(new Mundial("Copa Mundial de Fútbol de 2002", "Fue la XVIII edición de la Copa Mundial de Fútbol. Esta edición del evento se realizó en Alemania, entre el 9 de junio y el 9 de julio de 2006, siendo la segunda ocasión en que dicho país organizaba este evento tras el campeonato realizado en 1974 en la entonces Alemania Federal."));
        elementos.add(new Mundial("Copa Mundial de Fútbol de 1998","Fue la decimosexta edición de la Copa Mundial de Fútbol, se desarrolló en Francia, entre el 10 de junio y el 12 de julio de 1998. Francia se convirtió en el tercer país en organizar dos campeonatos (tras México e Italia), 60 años después del mundial realizado en 1938."));
        elementos.add(new Mundial("Copa Mundial de Fútbol de 1994","Fue la decimoquinta edición de la Copa Mundial de Fútbol, y se desarrolló en los Estados Unidos, entre el 17 de junio y el 17 de julio de 1994. Estados Unidos fue elegido como sede del Mundial por primera vez en la historia, generando gran polémica por ser un país sin tradición futbolística, debido a la popularidad de otros deportes como el baloncesto, el béisbol y el fútbol americano."));
    }

    List<Mundial> obtener() {
        return elementos;
    }

    void insertar(Mundial elemento, Callback callback){
        elementos.add(elemento);
        callback.cuandoFinalice(elementos);
    }

    void eliminar(Mundial elemento, Callback callback) {
        elementos.remove(elemento);
        callback.cuandoFinalice(elementos);
    }

    void actualizar(Mundial elemento, float valoracion, Callback callback) {
        elemento.valoracion = valoracion;
        callback.cuandoFinalice(elementos);
    }
}
