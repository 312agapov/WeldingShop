package leonid.weldingshop.controllers;

import leonid.weldingshop.entities.Gorelka;
import leonid.weldingshop.entities.WeldingMachine;
import leonid.weldingshop.repositories.GorelkaRepository;
import leonid.weldingshop.repositories.WeldingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


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
        gorelkaRepository.save(weldingMachine.getGorelka());
        weldingMachineRepository.save(weldingMachine);
        return "addweldingmachine";
    }

    @GetMapping("/addweldingmachine")
    public String addWeldingMachineForm(Model model) {
        model.addAttribute("weldingmachine", new WeldingMachine());
        return "addweldingmachine";
    }


    @GetMapping("/changeweldingmachine")
    public String changeWeldingMachineForm(@RequestParam UUID id, Model model) {
        WeldingMachine selectedWeldingMachine = weldingMachineRepository.findById(id).orElse(new WeldingMachine());
        model.addAttribute("selectedWeldingMachine", selectedWeldingMachine);
        List<WeldingMachine> data = weldingMachineRepository.findAll();
        model.addAttribute("allweldings", data);
        return "changeweldingmachine";
    }

    @PostMapping("/changeweldingmachine")
    public String changeWeldingMachine(@ModelAttribute("selectedWeldingMachine") WeldingMachine weldingMachine){
        WeldingMachine existingWeldingMachine = weldingMachineRepository.findById(weldingMachine.getId()).orElseThrow(() -> new RuntimeException("WeldingMachine not found"));
        existingWeldingMachine.setName(weldingMachine.getName());
        existingWeldingMachine.setPrice(weldingMachine.getPrice());
        existingWeldingMachine.getGorelka().setLength(weldingMachine.getGorelka().getLength());
        weldingMachineRepository.save(existingWeldingMachine);
        return "redirect:/allweldings";
    }
}
