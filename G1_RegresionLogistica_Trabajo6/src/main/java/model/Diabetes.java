package model;

import lombok.Getter;
import lombok.Setter;

public class Diabetes {

    @Getter @Setter double confidence;
    @Getter @Setter String category;
    @Getter @Setter double credits;
    @Getter @Setter double probability;
    @Getter @Setter String result;

    // Etiqueta   
    @Getter @Setter int edad, insulina,presion,pliegue,embarazos, glucosa;
    @Getter @Setter double imc,pedigri;
    @Getter @Setter String diabetes;



}





