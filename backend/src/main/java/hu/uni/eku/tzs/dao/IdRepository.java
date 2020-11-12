package hu.uni.eku.tzs.dao;

import hu.uni.eku.tzs.dao.entity.Id;
import org.springframework.data.repository.CrudRepository;

public interface IdRepository extends CrudRepository<Id, Integer> {
}
