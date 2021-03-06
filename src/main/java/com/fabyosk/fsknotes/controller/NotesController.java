package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.services.note.NoteServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotesController {
    private NoteServiceInterface noteService;

    @GetMapping("/note/list")
    public String getNotes(Model model) {
        return "user/list_notes";
    }

    @GetMapping("/note/add")
    public String addNote(Model model) {
        Note note = new Note();
        model.addAttribute("note", note);
        return "user/add_note";
    }

    @PostMapping("/note/add")
    public String submitNote(@ModelAttribute("note") Note note) {
        System.out.println(note.getContent());
        noteService.add(note);
        return "user/list_notes";
    }

    public void setNoteService(NoteServiceInterface noteService) {
        this.noteService = noteService;
    }
}
