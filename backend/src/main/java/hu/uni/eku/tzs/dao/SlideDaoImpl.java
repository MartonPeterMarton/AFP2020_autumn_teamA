package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class SlideImpl implements SlideDao {

    private final SlideRepository repository;

    @Override
    public void create(Slide slide) {
        repository.save(SlideEntityModelConverter.model2entity(slide));
    }

    @Override
    public Collection<Slide> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> SlideEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Slide original, Slide updated) {

    }

    @Override
    public void delete(Slide slide) {

    }

    private static class SlideEntityModelConverter{

        private static Slide entity2model(hu.uni.eku.tzs.dao.entity.Slide entity){
            return new Slide(
                    entity.getSlide()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Slide model2entity(Slide model){
            return hu.uni.eku.tzs.dao.entity.Slide.builder()
                    .slide(model.getSlide())
                    .build();
        }

    }
}
