package com.uas.tugas_kuliah.config;

import com.uas.tugas_kuliah.models.ModelTugas;
import com.uas.tugas_kuliah.repositories.RepositoryTugas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderModelTugas implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoaderModelTugas.class);

    @Autowired
    RepositoryTugas todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        logger.info("jumlah tugas yang tersedia : {}", todoItemRepository.count());
    }

}
