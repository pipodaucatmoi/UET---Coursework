package bai66;

import java.util.ArrayList;
import java.util.List;

abstract class FileSystemItem {
    protected String name;
    protected Folder parent;

    public FileSystemItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public String getPath() {
        if (parent == null) {
            return "/" + name;
        }
        return parent.getPath() + "/" + name;
    }

    public abstract void print(String indent);
}

class FileItem extends FileSystemItem {
    private int size;

    public FileItem(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + "KB)");
    }
}

class Shortcut extends FileSystemItem {
    private FileSystemItem target;

    public Shortcut(String name, FileSystemItem target) {
        super(name);
        this.target = target;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Shortcut: " + name + " -> " + target.getPath());
    }
}

class Folder extends FileSystemItem {
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public void add(FileSystemItem item) {
        item.setParent(this);
        children.add(item);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);

        for (FileSystemItem child : children) {
            child.print(indent + "  ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");

        Folder docs = new Folder("docs");
        root.add(docs);

        FileItem fileA = new FileItem("a.txt", 12);
        FileItem fileB = new FileItem("b.txt", 8);
        docs.add(fileA);
        docs.add(fileB);

        Shortcut shortcutA = new Shortcut("a-shortcut", fileA);
        docs.add(shortcutA);

        FileItem readme = new FileItem("readme.md", 4);
        root.add(readme);

        System.out.println("=== KẾT QUẢ IN CÂY THƯ MỤC ===");
        root.print("");
    }
}
