package com.magang_ITS.magang_ITS_new_java.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.magang_ITS.magang_ITS_new_java.model.MasterData;


@Repository
public interface NotifRepository extends CrudRepository<MasterData, String> {
	List<MasterData> findByUserId(String userId);
}
