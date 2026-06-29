package bai38;

public abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
        this.batteryLevel = 100;
    }

    public String getModelName() {
        return modelName;
    }

    public void chargeBattery(){this.batteryLevel = 100;}
    final void showIdentity(){
        System.out.println(id + " - " + modelName);
    }
    public abstract void performMainTask();
}
