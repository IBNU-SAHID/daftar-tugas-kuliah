package com.uas.tugas_kuliah.controllers;

import com.uas.tugas_kuliah.models.ModelTugas;
import com.uas.tugas_kuliah.repositories.RepositoryTugas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;
import java.time.ZoneId;

@Controller
public class ControllerModelTugas {
    private final Logger logger = LoggerFactory.getLogger(ControllerModelTugas.class);

    @Autowired
    private RepositoryTugas repositoryTugas;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request  GET ke index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("modelTugas", repositoryTugas.findAll());
        return modelAndView;
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid ModelTugas modelTugas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-todo-item";
        }


        repositoryTugas.save(modelTugas);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") long id, @Valid ModelTugas modelTugas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            modelTugas.setId(id);
            return "update-todo-item";
        }

        repositoryTugas.save(modelTugas);
        return "redirect:/";
    }

}
