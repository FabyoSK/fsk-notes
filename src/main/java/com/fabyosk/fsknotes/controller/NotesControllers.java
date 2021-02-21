package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NotesControllers {

    private final NoteRepository noteRepository;

    @Autowired
    public NotesControllers(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping("/notes")
    public String getNotes(Model model){
        model.addAttribute("notes", noteRepository.findAll());
        return "notes/list";
   }
}
