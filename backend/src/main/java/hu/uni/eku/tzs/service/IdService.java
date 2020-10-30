package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Id;
import hu.uni.eku.tzs.service.exceptions.IdAlreadyExistsException;

import java.util.Collection;

public interface IdService {

    void record(Id id) throws IdAlreadyExistsException;

    Collection<Id> readAll();
}
