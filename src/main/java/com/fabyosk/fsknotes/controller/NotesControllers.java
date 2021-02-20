package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.repositories.NoteRepositorie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotesControllers {

    private final NoteRepositorie noteRepositorie;

    public NotesControllers(NoteRepositorie noteRepositorie) {
        this.noteRepositorie = noteRepositorie;
    }

    @RequestMapping("/notes")
    public String getNotes(Model model){
        model.addAttribute("notes", noteRepositorie.findAll());
        return "notes/list";
   }
}
