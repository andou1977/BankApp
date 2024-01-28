package com.example.bankapp.repository;

import com.example.bankapp.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {

    void deleteById(int id);


    List<ClientEntity> findByNomClientStartsWith(String nomclient);
}
