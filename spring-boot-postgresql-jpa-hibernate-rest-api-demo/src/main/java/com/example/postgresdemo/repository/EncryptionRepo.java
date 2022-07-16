package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.EncyptionEntity;
import com.example.postgresdemo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncryptionRepo extends JpaRepository<EncyptionEntity, Long> {

}
