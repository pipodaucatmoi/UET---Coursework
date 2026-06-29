class CentralHub{
    public void registerDevice(SmartLight light){
        System.out.println("[HUB] dang ket noi voi thiet bi " + light.getName());
    }
}
class SmartLight{
    private String id;
    private String name;
    private int brightness;
    public SmartLight(String id, String name, int brightness){
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }
    public SmartLight(String id, String name){
        this(id, name, 50);
    }
    public void setBrightness(int brightness){
        this.brightness = brightness;
    }
    public void setBrightness(String preset){
        if (preset.equals("MAX")){
            this.brightness = 100;
        } else if (preset.equals("ECO")){
            this.brightness = 30;
        }else {
            this.brightness = 10;
        }
    }

    public String getName() {
        return name;
    }
    public int getBrightness() {
        return brightness;
    }
    public void connectToHub(CentralHub hub){
        hub.registerDevice(this);
    }
}
public class Main {
    public static void main(String[] args) {
        CentralHub hub = new CentralHub();
        SmartLight den1 = new SmartLight("L01", "Phong khach", 80);
        SmartLight den2 = new SmartLight("L02", "Phong ngu");
        den2.setBrightness("ECO");
        den1.connectToHub(hub);
        den2.connectToHub(hub);
        System.out.println("do sang den1: "+den1.getBrightness());
        System.out.println("do sang den2: "+den2.getBrightness());
    }
}