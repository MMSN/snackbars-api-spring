package com.example.snackbars.modules.snackbars.controller;

import com.example.snackbars.modules.snackbars.entity.Snackbar;
import com.example.snackbars.modules.snackbars.service.SnackbarService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/snackbar")
@RestController
@ResponseBody
public class SnackbarController {

    private final SnackbarService snackbarService;

    @Autowired
    public SnackbarController(SnackbarService snackbarService) {
        this.snackbarService = snackbarService;
    }

    @GetMapping
    public ResponseEntity<List<Snackbar>> getAllPeople() {
        List<Snackbar> listSnackbar = snackbarService.findAll();
        if (listSnackbar.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listSnackbar, HttpStatus.OK);
    };

    @GetMapping(path = "{id}")
    public ResponseEntity<Snackbar> getSnackbarById(@PathVariable("id") Long id) {
        Optional<Snackbar> snackbar = snackbarService.findById(id);
        if (snackbar.isPresent()) return new ResponseEntity(snackbar, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public Snackbar addSnackbar(
            @NonNull @RequestBody Snackbar snackbar) {
        return snackbarService.saveSnackbar(snackbar);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity updateSnackbarById(
            @PathVariable("id") Long id,
            @NonNull @RequestBody Snackbar snackbar) {
        Boolean resp = snackbarService.updateSnackbarById(id, snackbar);
        if (!resp) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deletePersonById(@PathVariable("id") Long id) {
        Boolean resp = snackbarService.deleteSnackbarById(id);
        if (!resp) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
