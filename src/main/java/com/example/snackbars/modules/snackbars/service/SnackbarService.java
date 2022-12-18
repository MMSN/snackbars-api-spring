package com.example.snackbars.modules.snackbars.service;

import com.example.snackbars.modules.snackbars.entity.Snackbar;
import com.example.snackbars.modules.snackbars.repository.SnackbarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnackbarService {

    @Autowired
    private SnackbarRepository snackbarRepository;

    public List<Snackbar> findAllSnackbars() {
        return snackbarRepository.findAll();
    }

    public Optional<Snackbar> findSnackbarById(long id) {
        return snackbarRepository.findById(id);
    }

    public Snackbar saveSnackbar(Snackbar snackbar) {
        return snackbarRepository.save(snackbar);
    }

    public boolean updateSnackbarById(long id, Snackbar snackbar) {
        Optional<Snackbar> oldSnackbar = this.findSnackbarById(id);
        if (oldSnackbar.isPresent()) {
            oldSnackbar.get().setName_snackbar(snackbar.getName_snackbar());
            snackbarRepository.save(oldSnackbar.get());
            return true;
        }
        return false;
    }

    public boolean deleteSnackbarById(long id) {
        Optional<Snackbar> oldSnackbar = this.findSnackbarById(id);
        if (oldSnackbar.isPresent()) {
            snackbarRepository.delete(oldSnackbar.get());
            return true;
        }
        return false;
    }
}
