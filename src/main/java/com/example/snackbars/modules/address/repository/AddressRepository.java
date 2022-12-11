package com.example.snackbars.modules.address.repository;

import com.example.snackbars.modules.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT p FROM addresses p WHERE p.snackbar_id IN (:ids)")
    public List<Address> findAddressesBySnackbarId(@Param("ids") long id);
}
