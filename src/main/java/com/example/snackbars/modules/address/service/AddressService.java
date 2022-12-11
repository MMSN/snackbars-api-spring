package com.example.snackbars.modules.address.service;

import com.example.snackbars.modules.address.entity.Address;
import com.example.snackbars.modules.address.repository.AddressRepository;
import com.example.snackbars.modules.snackbars.entity.Snackbar;
import com.example.snackbars.modules.snackbars.repository.SnackbarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SnackbarRepository snackbarRepository;

    public AddressService() {
    }

    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<Address> findAddressById(long id) {
        return addressRepository.findById(id);
    }

    public List<Address> findAllAddressesBySnackBarId (long id) {
        Optional<Snackbar> snackbar = snackbarRepository.findById(id);
        if (snackbar.isPresent()) {
            return addressRepository.findAddressesBySnackbarId(id);
        }
        return null;
    }

    public Optional<Address> saveAddress(long id, Address address) {
        Optional<Snackbar> snackbar = snackbarRepository.findById(id);
        if (snackbar.isPresent()) {
            address.setSnackbar(snackbar.get());
            addressRepository.save(address);
            return Optional.of(address);
        }
        return null;
    }

    public boolean updateAddressById(long snack_id, long address_id, Address address) {
        Optional<Snackbar> snackbar = snackbarRepository.findById(snack_id);
        Optional<Address> oldAddress = addressRepository.findById(address_id);
        if (snackbar.isPresent() && oldAddress.isPresent() && oldAddress.get().getSnackbar().getId() == snack_id) {
            address.setId(address_id);
            address.setSnackbar(snackbar.get());
            addressRepository.save(address);
            return true;
        }
        return false;
    }

    public boolean deleteAddressById(long id) {
        Optional<Address> oldAddress = this.findAddressById(id);
        if (oldAddress.isPresent()) {
            addressRepository.delete(oldAddress.get());
            return true;
        }
        return false;
    }
}
