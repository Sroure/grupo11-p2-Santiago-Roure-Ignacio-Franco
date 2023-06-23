package Entities;

import java.util.Objects;

public class User implements Comparable<User> {
    private long id;
    private String name;
    private boolean verificado;
    private String fechaCreado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    // tengo que agregar los tweets de cada usuario

    public User(long id, String name, boolean verificado) {
        this.id = id;
        this.name = name;
        this.verificado = verificado;
    }

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

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public String getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(String fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    // Funcion compare to para comparar usuarios
    @Override
    public int compareTo(User o) {
        return 0;
    }

}
