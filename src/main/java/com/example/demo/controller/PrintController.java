package com.example.demo.controller;

import com.example.demo.model.Print;
import com.example.demo.repository.PrintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PrintController {
    @Autowired
    private PrintRepository printRepository;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("prints", printRepository.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String showSignUpForm(Print print) {
        return "add-print";
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        model.addAttribute("prints", printRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addPrint(@Valid Print print, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-print";
        }

        printRepository.save(print);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Print print = printRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid print Id:" + id));
        model.addAttribute("print", print);
        return "update-print";
    }

    @PostMapping("update/{id}")
    public String updatePrint(@PathVariable("id") long id, @Valid Print print, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            print.setId(id);
            return "update-print";
        }

        printRepository.save(print);
        model.addAttribute("prints", printRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Print print = printRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid print Id:" + id));
        printRepository.delete(print);
        model.addAttribute("prints", printRepository.findAll());
        return "index";
    }
}