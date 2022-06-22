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
        if (todoItemRepository.count() == 0) {
            ModelTugas model1 = new ModelTugas("sistem basis data : buat video penjelasan");
            ModelTugas model2 = new ModelTugas("Metode Numerik   : Presentasi ulang");

            todoItemRepository.save(model1);
            todoItemRepository.save(model2);
        }
        logger.info("jumlah tugas yang tersedia : {}", todoItemRepository.count());
    }

}
