package com.codegym.city.controller;

import com.codegym.city.model.City;
import com.codegym.city.model.Province;
import com.codegym.city.service.city.CityService;
import com.codegym.city.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.nio.charset.StandardCharsets;
import java.util.Optional;


@Controller
@RequestMapping("/city")

public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private ProvinceService provinceService;
    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView listCity(){
        Iterable<City> citys = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("citys", citys);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateCity(){
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView saveCity(@ModelAttribute("city") City city, RedirectAttributes redirect) {
        cityService.save(city);
        redirect.addFlashAttribute("message", "Create city successfully !");
        return new RedirectView("/city");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView ShowEdit(@PathVariable Long id){
        Optional<City> city1=cityService.findById(id);
        if (city1.isPresent()){
            ModelAndView modelAndView = new ModelAndView("city/edit");
                        modelAndView.addObject("city", city1.get());
            return modelAndView;
        } else {
            return new ModelAndView("city/error");
        }
    }
    @PostMapping("/edit")
    public RedirectView editCity(@ModelAttribute("city") City city, RedirectAttributes redirect) {
        cityService.save(city);
        redirect.addFlashAttribute("message", "Edit city successfully !");
        return new RedirectView("/city");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showFormDeleteCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("city/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        }else {
            return new ModelAndView("city/error");
        }
    }

    @PostMapping("/delete")
    public RedirectView deleteProducer(@ModelAttribute("city") City city, RedirectAttributes redirect){
        cityService.remote(city.getId());
        redirect.addFlashAttribute("message", "Delete city successfully !" );
        return new RedirectView("/city");
    }

}
