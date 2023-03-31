import java.util.HashMap;

public class Pole {


    private double Co2_concentration = 0.0;
    private double battery_level = 0.0;
    private double tilt = 0.0;
    private String pole_name = "";

    public Pole(double Co2_concentration, double battery_level, double tilt, String pole_name){
        this.Co2_concentration = Co2_concentration;
        this.battery_level = battery_level;
        this.tilt = tilt;
        this.pole_name = pole_name;
    }


    public double get_Co2(){
        return this.Co2_concentration;
    }

    public double getBattery_Level(){
        return this.battery_level;
    }

    public double get_Tilt(){
        return this.tilt;
    }

    public String get_Pole_Name(){
        return this.pole_name;
    }

    public HashMap<String, Object> formatForAPi(){
        HashMap<String, Object> updateMap = new HashMap<String, Object>();
        updateMap.put("Co2 concentration", this.Co2_concentration + "");
        updateMap.put("battery", this.battery_level + "");
        updateMap.put("tilt", this.tilt + "");
        return updateMap;
    }

}
