package kafka.consumer.database.repository;

import kafka.consumer.database.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long> {
}
