package com.fabyosk.fsknotes;

import com.fabyosk.fsknotes.model.Note;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AppTest {
    @GetMapping(path = "/hello")
    public String sayHello() throws JsonProcessingException {
        Note u = new Note();


        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(u);
        System.out.println(jsonResult);

        return jsonResult;
    }

    @PostMapping(path = "/hello")
    public String submitNote(@ModelAttribute("note") Note note) {
        System.out.println(note);

        return "redirect:/{username}/notes/list";
    }

}
