package com.uas.tugas_kuliah.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tugas_kuliah")
public class ModelTugas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description is required")
    private String tugas;

    @Getter
    @Setter
    private boolean status;



    public ModelTugas() {}

    public ModelTugas(String description) {
        this.tugas = description;
        this.status = false;

    }

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, tugas='%s', status='%s'}",
                id, tugas, status);
    }


}
