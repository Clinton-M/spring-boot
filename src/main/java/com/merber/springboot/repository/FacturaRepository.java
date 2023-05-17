package com.merber.springboot.repository;

import com.merber.springboot.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}