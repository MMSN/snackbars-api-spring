package com.example.snackbars.modules.snackbars.controller;

import com.example.snackbars.modules.snackbars.entity.Snackbar;
import com.example.snackbars.modules.snackbars.service.SnackbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
@ResponseBody
public class SnackbarController {

    private final SnackbarService snackbarService;

    @Autowired
    public SnackbarController(SnackbarService snackbarService) {
        this.snackbarService = snackbarService;
    }

    @GetMapping("/snackbar")
    public ResponseEntity<List<Snackbar>> getAllSnackbars() {
        List<Snackbar> listSnackbar = snackbarService.findAllSnackbars();
        if (listSnackbar.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listSnackbar, HttpStatus.OK);
    }

    @GetMapping(path = "/snackbar/{id}")
    public ResponseEntity<Snackbar> getSnackbarById(@PathVariable("id") Long id) {
        Optional<Snackbar> snackbar = snackbarService.findSnackbarById(id);
        if (snackbar.isPresent()) return new ResponseEntity(snackbar, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize(value = "hasAuthority('ROLE_MODERATOR')")
    @PostMapping("/snackbar")
    public Snackbar addSnackbar(
            @NonNull @RequestBody Snackbar snackbar) {
        return snackbarService.saveSnackbar(snackbar);
    }

    @PutMapping(path = "/snackbar/{id}")
    public ResponseEntity updateSnackbarById(
            @PathVariable("id") Long id,
            @NonNull @RequestBody Snackbar snackbar) {
        Boolean resp = snackbarService.updateSnackbarById(id, snackbar);
        if (!resp) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/snackbar/{id}")
    public ResponseEntity deletePersonById(@PathVariable("id") Long id) {
        Boolean resp = snackbarService.deleteSnackbarById(id);
        if (!resp) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
