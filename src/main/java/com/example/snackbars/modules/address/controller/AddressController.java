package com.example.snackbars.modules.address.controller;

import com.example.snackbars.modules.address.entity.Address;
import com.example.snackbars.modules.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
@ResponseBody
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> listAddresses = addressService.findAllAddresses();
        if (listAddresses.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listAddresses, HttpStatus.OK);
    };

    @GetMapping(path = "/address/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long id) {
        Optional<Address> address = addressService.findAddressById(id);
        if (address.isPresent()) return new ResponseEntity(address, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/snackbar/{id}/address")
    public ResponseEntity<List<Address>> getAllAddressesBySnackBarId(@PathVariable("id") Long id) {
        Optional<List<Address>> listAddresses = Optional.ofNullable(addressService.findAllAddressesBySnackBarId(id));
        if (listAddresses.isPresent()) return new ResponseEntity(listAddresses, HttpStatus.OK);
        System.out.println("Mateus");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{id}/address")
    public Optional<Address> addAddress(
            @PathVariable("id") Long id,
            @NonNull @RequestBody Address address) {
        return addressService.saveAddress(id, address);
    }

    @PutMapping(path = "/snackbar/{snack_id}/address/{address_id}")
    public ResponseEntity updateAddressById(
            @PathVariable("snack_id") Long snack_id,
            @PathVariable("address_id") Long address_id,
            @NonNull @RequestBody Address address) {
        Boolean resp = addressService.updateAddressById(snack_id, address_id, address);
        if (!resp) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/address/{id}")
    public ResponseEntity deletePersonById(@PathVariable("id") Long id) {
        Boolean resp = addressService.deleteAddressById(id);
        if (!resp) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
