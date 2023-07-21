package com.app.ecommerce.order.repository;

import com.app.ecommerce.order.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {


}
