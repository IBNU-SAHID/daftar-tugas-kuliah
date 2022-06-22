package com.uas.tugas_kuliah.repositories;

import com.uas.tugas_kuliah.models.ModelTugas;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryTugas extends CrudRepository<ModelTugas, Long> {
}
