package fit.iuh.tk2_02.controller;

import fit.iuh.tk2_02.model.Busroute;
import fit.iuh.tk2_02.service.BusrouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/admin/busroutes")
@RequiredArgsConstructor
public class AdminBusrouteController {

    private final BusrouteService busrouteService;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("route", new Busroute(null, "", "", "", BigDecimal.ZERO, 0, 0));
        model.addAttribute("mode", "create");
        return "busroutes/form";
    }

    @PostMapping
    public String create(@ModelAttribute("route") Busroute route, BindingResult result) {
        if (result.hasErrors()) {
            return "busroutes/form";
        }
        busrouteService.save(route);
        return "redirect:/busroutes";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Busroute route = busrouteService.findById(id);
        if (route == null) return "redirect:/busroutes";
        model.addAttribute("route", route);
        model.addAttribute("mode", "edit");
        return "busroutes/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("route") Busroute route, BindingResult result) {
        if (result.hasErrors()) {
            return "busroutes/form";
        }
        route.setId(id);
        busrouteService.save(route);
        return "redirect:/busroutes";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        busrouteService.deleteById(id);
        return "redirect:/busroutes";
    }
}

