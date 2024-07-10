package com.example.Leonid.WeldingShop.Controllers;

import com.example.Leonid.WeldingShop.Entities.Gorelka;
import com.example.Leonid.WeldingShop.Entities.WeldingMachine;
import com.example.Leonid.WeldingShop.Repositories.GorelkaRepository;
import com.example.Leonid.WeldingShop.Repositories.WeldingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class WeldingMachineController {

    @Autowired
    private GorelkaRepository gorelkaRepository;
    @Autowired
    private WeldingMachineRepository weldingMachineRepository;

    @GetMapping("/")
    public String weldings(){
        return "mainpage";
    }
    @ResponseBody
    @PostMapping("/blowtorch")
    public Gorelka createBlowTorch(@RequestBody Gorelka gorelka){
//        System.out.println(gorelka);
        gorelkaRepository.save(gorelka);
        return gorelka;
    }

//    @ResponseBody
//    @GetMapping("/allweldings")
//    public List<WeldingMachine> showAllWeldings(){
//        return weldingMachineRepository.findAll();
//    }

    @GetMapping("/allweldings")
    public String showWeldings(Model model){
        List<WeldingMachine> data = weldingMachineRepository.findAll();
        model.addAttribute("allweldings",data);
        return "allweldings";
    }

    @PostMapping("/addweldingmachine")
    public String addWeldingMachine(@ModelAttribute ("weldingmachine") WeldingMachine weldingMachine){
        System.out.println(weldingMachine);
        weldingMachineRepository.save(weldingMachine);
        return "addweldingmachine";
    }

    @GetMapping("/addweldingmachine")
    public String addWeldingMachineForm(Model model) {
        model.addAttribute("weldingmachine", new WeldingMachine());
        return "addweldingmachine";
    }
}
