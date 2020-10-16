package org.wecancodeit.gpureviewjpa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.gpureviewjpa.models.GPU;
import org.wecancodeit.gpureviewjpa.repository.GpuRepository;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class GPUController {
    @Resource
    private GpuRepository gpuRepo;

    @RequestMapping("/gpus")
    public String displayGpus(Model model){
        model.addAttribute("gpus",gpuRepo.findAll());
        return "gpusView";
    }

    @GetMapping("/gpus/{id}")
    public String displaySingleGpu(@PathVariable long id, Model model) {
        Optional<GPU> retrievedGpu = gpuRepo.findById(id);
        GPU gpu = retrievedGpu.get();
        model.addAttribute("gpu",gpu);
        return "gpuView";
    }


}
