package leonid.weldingshop.repositories;

import leonid.weldingshop.entities.Gorelka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface GorelkaRepository extends JpaRepository<Gorelka, UUID> {
}