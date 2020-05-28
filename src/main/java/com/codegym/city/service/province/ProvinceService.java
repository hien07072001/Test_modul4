package com.codegym.city.service.province;

import com.codegym.city.model.Province;

import java.util.Optional;

public interface ProvinceService {

    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void delete(Long id);
}
