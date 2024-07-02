package com.example.Leonid.WeldingShop.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WeldingMachineController {
    @GetMapping("/")
    public String weldings(){
        return "weldings";
    }
}
