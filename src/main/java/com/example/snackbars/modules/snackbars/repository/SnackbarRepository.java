package com.example.snackbars.modules.snackbars.repository;

import com.example.snackbars.modules.snackbars.entity.Snackbar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackbarRepository extends JpaRepository<Snackbar, Long> {
}
