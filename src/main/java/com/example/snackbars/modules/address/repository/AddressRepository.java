package com.example.snackbars.modules.address.repository;

import com.example.snackbars.modules.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
