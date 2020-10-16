package org.wecancodeit.gpureviewjpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.gpureviewjpa.models.Brand;
import org.wecancodeit.gpureviewjpa.repository.BrandRepository;

import javax.annotation.Resource;

@Controller
public class BrandController {
    @Resource
    private BrandRepository brandRepo;

    @RequestMapping("/brands")
    public String displayBrands(Model model) {
        model.addAttribute("brands",brandRepo.findAll());
        return "brandsView";
    }

    @GetMapping("/brands/{name}")
    public String displaySingleBrand(@PathVariable String name, Model model) {
        Brand retrievedBrand = brandRepo.findBrandByBrand(name);
        model.addAttribute("brand",retrievedBrand);
        return "brandView";
    }
}
