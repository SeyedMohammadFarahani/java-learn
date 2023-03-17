package D_Softwae_Quality;

import java.util.List;

public class Database {

    private List<String> storage;

    public void setStorage(List<String> storage) {
        this.storage = storage;
    }

    public void open() {

    }

    public void close() {

    }

    public void insert(String name) {
        storage.add(name);
    }

    public void delete(String name) {
        storage.remove(name);
    }
}
