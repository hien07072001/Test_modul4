package com.codegym.city.repository;

import com.codegym.city.model.City;
import com.codegym.city.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City,Long > {
    Iterable<City> findAllByProvince(Province province);


}
