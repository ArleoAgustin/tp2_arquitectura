package dao.Interface;

import entities.Persona;

import java.util.List;

public interface DaoPersona {

    public void addPersona(Persona p) throws Exception;
    public void updatePersona(Persona p, Persona pNew) throws Exception;
    public void deletePersona(Long id) throws Exception;
    public List<Persona> getPersonas() throws Exception;
}
