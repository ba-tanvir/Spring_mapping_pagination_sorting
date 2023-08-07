package com.example.carinsuranceapi3.repository;


import com.example.carinsuranceapi3.Entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <E extends BaseEntity> extends JpaRepository<E, String> {
}
