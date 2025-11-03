package fit.iuh.tk2_02.controller;

import fit.iuh.tk2_02.model.Busroute;
import fit.iuh.tk2_02.service.BusrouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/busroutes")
@RequiredArgsConstructor
public class BusrouteController {

    private final BusrouteService busrouteService;

    @GetMapping
    public String list(@RequestParam(value = "name", required = false) String name,
                       Model model,
                       Authentication authentication) {
        List<Busroute> routes = (name == null || name.isBlank())
                ? busrouteService.findAll()
                : busrouteService.searchByName(name);
        model.addAttribute("routes", routes);
        model.addAttribute("search", name == null ? "" : name);
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
            model.addAttribute("roles", authentication.getAuthorities().stream()
                    .map(a -> a.getAuthority()).collect(Collectors.joining(", ")));
        }
        return "busroutes/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Busroute route = busrouteService.findById(id);
        if (route == null) {
            return "redirect:/busroutes";
        }
        model.addAttribute("route", route);
        return "busroutes/detail";
    }
}

