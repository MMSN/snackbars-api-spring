package com.example.snackbars.modules.addresses.repository;

import com.example.snackbars.modules.addresses.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(
            value = "SELECT p FROM Address p WHERE p.snackbar.id=:id"
    )
    List<Address> findAddressesBySnackbarId(@Param("id") long id);
}
