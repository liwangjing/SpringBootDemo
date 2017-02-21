package com.example.Controller;

import com.example.Model.Contact;
import com.example.Repository.ContactDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by jing on 2017/2/20.
 */
@Controller
@RequestMapping("/")
public class ContactController {
    private ContactDao contactRepository;

    public ContactController (ContactDao contactRepository) {
        this.contactRepository = contactRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping
    public String home(Map<String, Object> model) {
        List<Contact> contacts = contactRepository.getAll();
        model.put("contacts", contacts);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
//    @PostMapping
    public String submit(Contact contact) {
        contactRepository.save(contact);
        return "redirect:/";
    }
}
