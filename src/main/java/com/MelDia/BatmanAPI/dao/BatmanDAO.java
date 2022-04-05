package com.MelDia.BatmanAPI.dao;

import com.MelDia.BatmanAPI.model.Batman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatmanDAO extends JpaRepository<Batman, Integer>{
    
}
