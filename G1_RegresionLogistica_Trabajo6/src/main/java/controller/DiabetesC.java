package controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import lombok.Data;
import model.Diabetes;
import org.primefaces.json.JSONObject;
import services.Services;

@Named(value = "diabetesC")
@SessionScoped
@Data
public class DiabetesC implements Serializable {

    Diabetes diabetes;

    public DiabetesC() {
        diabetes = new Diabetes();
        diabetes.setEdad(33);
        diabetes.setGlucosa(110);
        diabetes.setPresion(75);
        diabetes.setInsulina(81);
        diabetes.setImc(32.16743);
        diabetes.setPedigri(0.47253);
        diabetes.setPliegue(21);
        diabetes.setEmbarazos(3);
    }

    public  void obtenerDatos() throws IOException, InterruptedException {
        try {            
            JSONObject cadenaJson = Services.obtenerJSon(diabetes);  
            diabetes.setCategory(cadenaJson.getString("Scored Labels"));
            diabetes.setProbability(cadenaJson.getDouble("Scored Probabilities"));
            if (diabetes.getCategory().equals("No")) {
                diabetes.setResult("Que bien, no tienes diabetes");
            } else {
                diabetes.setResult("Lo sentimos, de acuerdo a nuestro modelo tienes diabetes");
            }
        } catch (Exception e) {
            System.out.println("Error en obtenerDatosC: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
