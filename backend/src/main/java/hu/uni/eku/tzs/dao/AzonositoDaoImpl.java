package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.model.Azonosito;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class AzonositoDaoImpl implements AzonositoDao {

    private final AzonositoRepository repository;

    @Override
    public void create(Azonosito azonosito) {
        repository.save(AzonositoEntityModelConverter.model2entity(azonosito));
    }

    @Override
    public Collection<Azonosito> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> AzonositoEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Azonosito original, Azonosito updated) {

    }

    @Override
    public void delete(Azonosito azonosito) {

    }

    private static class AzonositoEntityModelConverter{

        private static Azonosito entity2model(hu.uni.eku.tzs.dao.entity.Azonosito entity){
            return new Azonosito(
                    entity.getAzonosito()
            );
        }

        private static hu.uni.eku.tzs.dao.entity.Azonosito model2entity(Azonosito model){
            return hu.uni.eku.tzs.dao.entity.Azonosito.builder()
                    .azonosito(model.getAzonosito())
                    .build();
        }

    }
}
