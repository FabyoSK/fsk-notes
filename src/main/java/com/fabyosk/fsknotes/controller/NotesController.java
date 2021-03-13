package com.fabyosk.fsknotes.controller;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.services.note.NoteService;
import com.fabyosk.fsknotes.services.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NotesController {
    private UserServices userServices;
    private NoteService noteService;

    @GetMapping("/list")
    public String getNotes(Model model) {

        User user = userServices.findById(1);


        model.addAttribute("user", user);

        Note note = new Note();
        model.addAttribute("note", note);

        model.addAttribute("notes", user.getNotes());
        return "notes/list";
    }


    @PostMapping("/add/{id}")
    public String submitNote(@ModelAttribute("note") Note note, @PathVariable Integer id) {
        User user = userServices.findById(id);
        user.addNote(note);

        userServices.add(user);

        return "redirect:/notes/list";
    }

    @GetMapping("{userid}/delete/{id}")
    public String deleteNote(@PathVariable Integer userid,@PathVariable Integer id) {

        User user = userServices.findById(userid);
        user.removeNote(noteService.getById(id));
        userServices.add(user);
        return "redirect:/notes/list";
    }


    @Autowired
    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }
}
