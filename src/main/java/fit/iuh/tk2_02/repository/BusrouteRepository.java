package fit.iuh.tk2_02.repository;

import fit.iuh.tk2_02.model.Busroute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusrouteRepository extends JpaRepository<Busroute, Long> {
    List<Busroute> findByNameContainingIgnoreCase(String name);
}

