package com.example.bankapp.repository;

import com.example.bankapp.entity.CompteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<CompteEntity,Integer> {
}
