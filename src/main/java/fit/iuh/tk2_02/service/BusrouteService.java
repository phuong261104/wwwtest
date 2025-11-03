package fit.iuh.tk2_02.service;

import fit.iuh.tk2_02.model.Busroute;

import java.util.List;

public interface BusrouteService {
    List<Busroute> findAll();

    List<Busroute> searchByName(String name);

    Busroute findById(Long id);

    Busroute save(Busroute busroute);

    void deleteById(Long id);
}

