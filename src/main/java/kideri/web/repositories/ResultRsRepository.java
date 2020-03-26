package kideri.web.repositories;

import kideri.web.orm.ResultRs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository @Component
public interface ResultRsRepository extends JpaRepository<ResultRs, Long> {



}
