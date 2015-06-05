package contacts.mvc.service;

import contacts.mvc.model.entity.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service("personService")
@Transactional
public class PersonService {

  @Resource(name = "sessionFactory")
  private SessionFactory sessionFactory;

  public List<Person> getAll() {
    Session session = sessionFactory.getCurrentSession();

    Query query = session.createQuery("FROM  Person");

    return query.list();
  }

  public Person get(Integer id) {
    Session session = sessionFactory.getCurrentSession();

    Person person = (Person)session.get(Person.class, id);

    return person;
  }

  public void add(Person person) {
    Session session = sessionFactory.getCurrentSession();

    session.save(person);
  }

  public void edit(Person person) {
    Session session = sessionFactory.getCurrentSession();

    Person existingPerson = (Person) session.get(Person.class, person.getId());

    existingPerson.setFirstName(person.getFirstName());
    existingPerson.setLastName(person.getLastName());
    existingPerson.setEmail(person.getEmail());
    existingPerson.setBirthDate(person.getBirthDate());
    existingPerson.setPhone(person.getPhone());

    session.save(existingPerson);
  }

  public void delete(Integer id) {
    Session session = sessionFactory.getCurrentSession();

    Person person = (Person) session.get(Person.class, id);

    session.delete(person);
  }
}
