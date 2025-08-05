package c360.model;

public class Behaviour {
    public String cif;
    public String c360_behaviour;
    public String ha_behaviour;

    public Behaviour(){
        super();
    };

    public Behaviour(String cif, String c360_behaviour, String ha_behaviour){
        this.cif = cif;
        this.c360_behaviour = c360_behaviour;
        this.ha_behaviour = ha_behaviour;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getC360_behaviour() {
        return c360_behaviour;
    }

    public void setC360_behaviour(String c360_behaviour) {
        this.c360_behaviour = c360_behaviour;
    }

    public String getHa_behaviour() {
        return ha_behaviour;
    }

    public void setHa_behaviour(String ha_behaviour) {
        this.ha_behaviour = ha_behaviour;
    }

    @Override
    public String toString() {
        return "Behaviour{" +
                "cif='" + cif + '\'' +
                ", c360_behaviour='" + c360_behaviour + '\'' +
                ", ha_behaviour='" + ha_behaviour + '\'' +
                '}';
    }
}