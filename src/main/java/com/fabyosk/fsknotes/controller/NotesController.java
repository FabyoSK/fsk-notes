package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotesController {


    @GetMapping("/listnotes")
    public String getNotes(Model model) {
        return "user/list_notes";
    }

    @GetMapping("/addnote")
    public String addNote(Model model) {
        Note note = new Note();
        model.addAttribute("note", note);
        return "user/add_note";
    }

    @PostMapping("/addnote")
    public String submitNote(@ModelAttribute("note") Note note) {
        System.out.println(note.getContent());
        return "user/list_notes";
    }
}
