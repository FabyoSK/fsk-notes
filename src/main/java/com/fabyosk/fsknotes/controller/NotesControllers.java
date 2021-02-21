package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.repositories.NoteRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotesControllers {

    private final NoteRepository noteRepository;

    public NotesControllers(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @RequestMapping("/notes")
    public String getNotes(Model model){
        model.addAttribute("notes", noteRepository.findAll());
        return "notes/list";
   }
}
