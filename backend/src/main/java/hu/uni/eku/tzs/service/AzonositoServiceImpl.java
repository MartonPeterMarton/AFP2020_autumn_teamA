package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.AzonositoDao;
import hu.uni.eku.tzs.model.Azonosito;
import hu.uni.eku.tzs.service.exceptions.AzonositoAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class AzonositoServiceImpl implements AzonositoService {

    private final AzonositoDao dao;

    @Override
    public void record(Azonosito azonosito) throws AzonositoAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( cn ->
                                cn.getAzonosito() == azonosito.getAzonosito();
        if(isAlreadyRecorded){
            log.info("Azonosito {} already recorded!", azonosito);
            throw new AzonositoAlreadyExistsException(String.format("Azonosito (%s) already exists!", azonosito.toString()));

        }
        dao.create(azonosito);
    }

    @Override
    public Collection<Azonosito> readAll() {
        return dao.readAll();
    }
}
