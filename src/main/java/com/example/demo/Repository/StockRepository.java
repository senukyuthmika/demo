package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Stock;

public interface StockRepository extends JpaRepository<Stock,Long>{

}
