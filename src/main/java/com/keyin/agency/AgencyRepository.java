package com.keyin.agency;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AgencyRepository extends CrudRepository<Agency, Long> {
    Agency findByPk(long pk);
    Agency findByName(String name);
    Agency findByWebsite(String website);
    List<Agency> findAllByActive(boolean active);
}
