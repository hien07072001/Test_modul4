package com.codegym.city.service.province;

import com.codegym.city.model.Province;
import com.codegym.city.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class provinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepository.findById(id);
    }


    @Override
    public void save(Province province) {
        provinceRepository.save(province);

    }

    @Override
    public void delete(Long id) {
        provinceRepository.deleteById(id);

    }
}
