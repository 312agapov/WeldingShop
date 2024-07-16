package leonid.weldingshop.repositories;


import leonid.weldingshop.entities.WeldingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeldingMachineRepository extends JpaRepository<WeldingMachine, UUID> {



}
