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
public class IdImpl implements IdDao {

    private final IdRepository repository;

    @Override
    public void create(Id id) {
        repository.save(IdEntityModelConverter.model2entity(id));
    }

    @Override
    public Collection<Id> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> IdEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Id original, Id updated) {

    }

    @Override
    public void delete(Id id) {

    }

    private static class IdEntityModelConverter{

        private static Id entity2model(hu.uni.eku.tzs.dao.entity.Id entity){
            return new Id(
                    entity.getId()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Id model2entity(Id model){
            return hu.uni.eku.tzs.dao.entity.Id.builder()
                    .id(model.getId())
                    .build();
        }

    }
}
