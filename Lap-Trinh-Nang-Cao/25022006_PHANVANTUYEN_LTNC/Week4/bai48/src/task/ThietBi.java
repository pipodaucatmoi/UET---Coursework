package task;

import task.skills.UpDown;
import task.skills.Wifi;

public abstract class ThietBi {
    public String id;
    public String name;
    public boolean onOff;

    public ThietBi(String id, String name) {
        this.id = id;
        this.name = name;
        this.onOff = true;
    }
    abstract void turnOff();

}
class Light extends ThietBi implements UpDown {
    public int brightness;

    public Light(String id, String name) {
        super(id, name);
        this.onOff = true;
        this.brightness = 100;
    }
    @Override
    public void Up() {
        this.brightness = this.brightness + 10;
        if (this.brightness > 100){
            this.brightness = 100;
        }
    }
    @Override
    public void Down() {
        this.brightness = this.brightness - 10;
        if (this.brightness < 0){
            this.brightness = 0;
        }
    }
    @Override
    void turnOff() {
        this.onOff = false;
        System.out.println(this.name + " turned off");
    }
}
class Cool extends ThietBi implements UpDown, Wifi{
    public int cool;

    public Cool(String id, String name) {
        super(id, name);
        this.cool = 100;
    }
    @Override
    void turnOff() {
        this.onOff = false;
        System.out.println(this.name + " turned off");
    }
    @Override
    public void Up() {
        this.cool = this.cool + 10;
        if (this.cool > 100){
            this.cool = 100;
        }
    }
    @Override
    public void Down() {
        this.cool = this.cool - 10;
        if (this.cool < 0){
            this.cool = 0;
        }
    }
    @Override
    public void connectWifi() {
        System.out.println(this.name + " connected to wifi");

    }
}
class Rem extends ThietBi{
    public Rem(String id, String name) {
        super(id, name);
    }
    @Override
    void turnOff() {
        this.onOff = false;
        System.out.println(this.name + " turned off");
    }
}
class Sound extends ThietBi implements UpDown, Wifi {
    public int sound;
    public Sound(String id, String name) {
        super(id, name);
    }
    @Override
    void turnOff() {
        this.onOff = false;
        System.out.println(this.name + " turned off");
    }
    @Override
    public void Up() {
        this.sound = this.sound + 10;
        if (this.sound > 100){
            this.sound = 100;
        }
    }
    @Override
    public void Down() {
        this.sound = this.sound - 10;
        if (this.sound < 0){
            this.sound = 0;
        }
    }
    @Override
    public void connectWifi() {
        System.out.println(this.name + " connected to wifi");
    }
}
