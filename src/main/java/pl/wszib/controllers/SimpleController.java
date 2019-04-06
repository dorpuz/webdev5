package pl.wszib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wszib.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    private List<Person> listPerson;

    public SimpleController() {
        listPerson = generateList();
    }

    @GetMapping("basic")
    public String basic(Model model){

        String firstName ="Dorota";
        String lastName ="Puzio";
        model.addAttribute("fName",firstName);
        model.addAttribute("lName",lastName);

        Person person = new Person();
        person.setFirstName("Dominika");
        person.setLastName("Dudek");
        person.setSalary(25000000.);
        person.setPhoneNumber("789456123");
        person.setVisible(true);

        model.addAttribute("person", person);

        return "basicTemplate";
    }

    @GetMapping("iteration")
    public String iteration(Model model){

        model.addAttribute("list", listPerson);

        return "iterationTemplate";
    }

    @GetMapping("links")
    public String links(Model model){
        return "linksTemplate";
    }

    @GetMapping("inter")
    public String inter(Model model){
        return "interTemplate";
    }

    @GetMapping("forms")
    public String forms(Model model){

        model.addAttribute("person",new Person());

        return "formsTemplate";
    }

    @PostMapping("formsSave")
    public String formsSave(Person person, Model model){

        listPerson.add(person);
        return "successTemplate";
    }


    private List<Person> generateList(){
        List<Person> list = new ArrayList<>();

        Person person1 = new Person();
        person1.setFirstName("Dominik");
        person1.setLastName("Dudek");
        person1.setSalary(25000000.);
        person1.setPhoneNumber("789456123");
        person1.setVisible(false);
        list.add(person1);

        Person person2 = new Person();
        person2.setFirstName("Ala");
        person2.setLastName("Makota");
        person2.setSalary(2500000.);
        person2.setPhoneNumber("987654321");
        person2.setVisible(true);
        list.add(person2);

        Person person3 = new Person();
        person3.setFirstName("Ola");
        person3.setLastName("Mapsa");
        person3.setSalary(250000.);
        person3.setPhoneNumber("123456789");
        person3.setVisible(true);
        list.add(person3);

        return list;
    }


    @GetMapping("fragments")
    public String fragments(Model model){
        return "fragments/fragmentsTemplate";
    }

 @GetMapping("fragmentsTwo")
    public String fragments2(Model model){
        return "fragments/fragmentsTemplateTwo";
    }



}
