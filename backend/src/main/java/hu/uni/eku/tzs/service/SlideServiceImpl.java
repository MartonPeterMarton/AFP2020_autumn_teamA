package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.SlideDao;
import hu.uni.eku.tzs.model.Slide;
import hu.uni.eku.tzs.service.exceptions.SlideAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class SlideServiceImpl implements SlideService {

    private final SlideDao dao;

    @Override
    public void record(Slide slide) throws SlideAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( cn ->
                                cn.getSlide() == slide.getSlide();
        if(isAlreadyRecorded){
            log.info("Slide {} already recorded!", slide);
            throw new SlideAlreadyExistsException(String.format("Slide (%s) already exists!", slide.toString()));

        }
        dao.create(slide);
    }

    @Override
    public Collection<Slide> readAll() {
        return dao.readAll();
    }
}
