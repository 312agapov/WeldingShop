package com.example.Leonid.WeldingShop.Controllers;

import com.example.Leonid.WeldingShop.Entities.Gorelka;
import com.example.Leonid.WeldingShop.Entities.WeldingMachine;
import com.example.Leonid.WeldingShop.Repositories.GorelkaRepository;
import com.example.Leonid.WeldingShop.Repositories.WeldingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "weldings";
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
        return "weldings";
    }
}
