package Entities;

public class User {
    long id;
    String name;
    // tengo que agregar los tweets de cada usuario
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
