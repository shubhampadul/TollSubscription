package clover.infotech.repo;

import clover.infotech.entity.TollSubcriptions;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TollSubcriptionsRepo implements PanacheRepository<TollSubcriptions>{

}
