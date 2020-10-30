package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Id;

import java.util.Collection;

public interface IdDao {

    void create(Id id);

    Collection<Id> readAll();

    void update(Id original, Id updated);

    void delete(Id id);
}
