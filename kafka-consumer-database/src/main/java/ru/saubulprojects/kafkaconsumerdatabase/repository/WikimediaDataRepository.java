package ru.saubulprojects.kafkaconsumerdatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.saubulprojects.kafkaconsumerdatabase.entity.WikimediaDataEntity;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaDataEntity, Long>{

}
