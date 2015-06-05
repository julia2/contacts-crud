package contacts.mvc.controller;

import contacts.mvc.model.entity.Person;
import contacts.mvc.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping({"/", "/persons"})
public class MainController {

  @Resource(name = "personService")
  private PersonService personService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String getPersons(Model model) {

    List<Person> persons = personService.getAll();

    model.addAttribute("persons", persons);

    return "persons";
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String getAdd(Model model) {
    model.addAttribute("person", new Person());

    return "addPerson";
  }

  @RequestMapping(value = "/added", method = RequestMethod.POST)
  public String add(@ModelAttribute("person") Person person) {
    personService.add(person);

    return "redirect:/persons";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public String getEdit(@RequestParam(value = "id", required = true) Integer id, Model model) {
    model.addAttribute("person", personService.get(id));

    return "editPerson";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  public String edit(@ModelAttribute("person") Person person,
                     @RequestParam(value = "id", required = true) Integer id,
                     Model model) {

    person.setId(id);

    personService.edit(person);

    model.addAttribute("id", id);

    return "redirect:/persons";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String delete(@RequestParam(value = "id", required = true) Integer id, Model model) {
    personService.delete(id);

    model.addAttribute("id", id);

    return "redirect:/persons";
  }

}
