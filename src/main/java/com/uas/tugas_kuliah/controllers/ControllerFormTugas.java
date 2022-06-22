package com.uas.tugas_kuliah.controllers;

import com.uas.tugas_kuliah.models.ModelTugas;
import com.uas.tugas_kuliah.repositories.RepositoryTugas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerFormTugas {
    @Autowired
    private RepositoryTugas repositoryTugas;

    @GetMapping("/create-todo")
    public String showCreateForm(ModelTugas modelTugas){
        return "add-todo-item";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ModelTugas modelTugas = repositoryTugas
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        model.addAttribute("todo", modelTugas);
        return "update-todo-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        ModelTugas todoItem = repositoryTugas
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));

        repositoryTugas.delete(todoItem);
        return "redirect:/";
    }


}
