package com.codegym.city.service.city;

import com.codegym.city.model.City;
import com.codegym.city.model.Province;

import java.util.Optional;

public interface CityService  {
    Iterable<City> findAll();

    Iterable<City> findAllByProvince(Province province);

    Optional<City> findById(Long id);

    void save(City city);

    void remote(Long id);
}
