package task44;

public class Main {
    interface IData {
        void show();
    }

    class DataManager implements IData{
        public void show() {
            System.out.println("Show Data");
        }
    }

    public void main(String[] args) {
        DataManager acc = new DataManager();
        acc.show();
    }

}