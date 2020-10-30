package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.IdDao;
import hu.uni.eku.tzs.model.Id;
import hu.uni.eku.tzs.service.exceptions.IdAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class IdServiceImpl implements IdService {

    private final IdDao dao;

    @Override
    public void record(Id id) throws IdAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( cn ->
                                cn.getId() == id.getId());
        if(isAlreadyRecorded){
            log.info("Id {} already recorded!", id);
            throw new IdAlreadyExistsException(String.format("Id (%s) already exists!", id.toString()));

        }
        dao.create(id);
    }

    @Override
    public Collection<Id> readAll() {
        return dao.readAll();
    }
}
