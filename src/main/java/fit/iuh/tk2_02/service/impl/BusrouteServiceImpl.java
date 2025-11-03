package fit.iuh.tk2_02.service.impl;

import fit.iuh.tk2_02.model.Busroute;
import fit.iuh.tk2_02.repository.BusrouteRepository;
import fit.iuh.tk2_02.service.BusrouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusrouteServiceImpl implements BusrouteService {
    private final BusrouteRepository busrouteRepository;

    @Override
    public List<Busroute> findAll() {
        return busrouteRepository.findAll();
    }

    @Override
    public List<Busroute> searchByName(String name) {
        if (name == null || name.isBlank()) return findAll();
        return busrouteRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Busroute findById(Long id) {
        return busrouteRepository.findById(id).orElse(null);
    }

    @Override
    public Busroute save(Busroute busroute) {
        return busrouteRepository.save(busroute);
    }

    @Override
    public void deleteById(Long id) {
        busrouteRepository.deleteById(id);
    }
}

