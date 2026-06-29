public class SmartFan {
    // 3 trang thai
    private String brand = "Xiaomi";
    private boolean isPowerOn = false;
    private int speedLevel = 0;
//hanhvi
    public void turnOn() { //Behavior
        this.isPowerOn = true;
    }
//hanhvi
    public void turnOff() { //Behavior
        this.isPowerOn = false;
        this.speedLevel = 0;
    }
//hanhvi
    public void setSpeed(int newSpeed) { //Behavior
        // Chỉ đổi tốc độ nếu quạt đang bật
        if (this.isPowerOn == true) { 
            this.speedLevel = newSpeed;
        }
    }

    public static void main(String[] args) {
        SmartFan livingRoomFan = new SmartFan(); // dinh danh livingRoomFan
        livingRoomFan.turnOn();
        livingRoomFan.setSpeed(2);

        SmartFan bedroomFan = new SmartFan();
        bedroomFan.setSpeed(3); 
        bedroomFan.turnOn();
    }
}
