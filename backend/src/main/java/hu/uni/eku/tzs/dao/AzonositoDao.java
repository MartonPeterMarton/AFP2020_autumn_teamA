package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Azonosito;

import java.util.Collection;

public interface AzonositoDao {

    void create(Azonosito azonosito);

    Collection<Azonosito> readAll();

    void update(Azonosito original, Azonosito updated);

    void delete(Azonosito azonosito);
}
