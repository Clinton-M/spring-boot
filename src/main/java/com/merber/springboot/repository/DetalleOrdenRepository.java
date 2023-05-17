package com.merber.springboot.repository;

import com.merber.springboot.model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {

}