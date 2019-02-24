package data.crawler.udemy.datacrawler.repository;

import data.crawler.udemy.datacrawler.entity.LinkUdemy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkUdemyRepository extends CrudRepository<LinkUdemy, Long> {
}
