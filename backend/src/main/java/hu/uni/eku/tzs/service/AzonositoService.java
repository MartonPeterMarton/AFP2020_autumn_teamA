package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Azonosito;
import hu.uni.eku.tzs.service.exceptions.AzonositoAlreadyExistsException;

import java.util.Collection;

public interface AzonositoService {

    void record(Azonosito azonosito) throws AzonositoAlreadyExistsException;

    Collection<Azonosito> readAll();
}
