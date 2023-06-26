package Entities;

import Hash.MyHash;
import Hash.MyHashImpl;
import java.util.Objects;

import static java.awt.SystemColor.text;

public class HashTag {
    private Long id;
    private MyHash<String, Integer> listaDeHashtag;

    public HashTag(Long id, String text) {
        this.id = id;
        this.listaDeHashtag = new MyHashImpl<>(100000);
        this.listaDeHashtag.insert(text, 1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTag hashTag = (HashTag) o;
        return id == hashTag.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public MyHash<String, Integer> getListaDeHashtag() {
        return listaDeHashtag;
    }

    public void agregarHashtagAlista (String text){
        listaDeHashtag.insert(text, 1);
    }

    public void sumarCantidadHashtag (String text){
        Integer cantidadVeces= listaDeHashtag.get(text);
        cantidadVeces++;
    }
}
