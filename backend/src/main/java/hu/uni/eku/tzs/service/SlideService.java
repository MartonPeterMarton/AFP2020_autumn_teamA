package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.service.exceptions.SlideAlreadyExistsException;

import java.util.Collection;

public interface SlideService {

    void record(Slide slide) throws SlideAlreadyExistsException;

    Collection<Slide> readAll();
}
