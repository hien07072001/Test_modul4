package com.codegym.city.service.city;

import com.codegym.city.model.City;
import com.codegym.city.model.Province;
import com.codegym.city.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Iterable<City> findAllByProvince(Province province) {
        return cityRepository.findAllByProvince(province);
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);

    }

    @Override
    public void remote(Long id) {
        cityRepository.deleteById(id);
    }

}
