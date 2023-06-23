package Entities;

import java.util.Objects;

public class Piloto implements Comparable<Piloto> {
    private String nombre;
    private int cantidadMencion;

    public Piloto(String nombre, int cantidadMencion) {
        this.nombre = nombre;
        this.cantidadMencion = cantidadMencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMencion() {
        return cantidadMencion;
    }

    public void setCantidadMencion(int cantidadMencion) {
        this.cantidadMencion = cantidadMencion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return cantidadMencion == piloto.cantidadMencion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidadMencion);
    }

    @Override
    public int compareTo(Piloto o) {
        return 0;
    }
}
