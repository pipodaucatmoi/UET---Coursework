package task410;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaItem {
    String id;
    String name;

    public MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getOut();
}

class Book extends MediaItem{
    String nameAuthor;
    int page;

    public Book(String id, String name, int page, String nameAuthor) {
        super(id, name);
        this.page = page;
        this.nameAuthor = nameAuthor;
    }
    @Override
    public String getOut() {
        return name + " - " + nameAuthor + " - " + page;
    }
}

class Dvd extends MediaItem{
    String nameDirector;
    int min;

    public Dvd(String id, String name, String nameDirector, int min) {
        super(id, name);
        this.nameDirector = nameDirector;
        this.min = min;
    }
    @Override
    public String getOut() {
        return name + " - " + nameDirector + " - " + min;
    }
}

class LibrarySection<T extends MediaItem>{
    List<T> list = new ArrayList<>();

    public void addLib(T value){
        list.add(value);
    }
    public void outLib(T value){
        if (list.remove(value)){
            System.out.println("Xoa tai lieu: " + value.getName());
        } else {
            System.out.println("Error");
        }
    }
    public void showLib(){
        for (T in : list ){
            System.out.println(in.getOut());
        }
    }
}



