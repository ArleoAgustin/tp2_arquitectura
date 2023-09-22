package percistence.connection;

import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;

public class RepositoryFactory {

    public RepositoryFactory() {}

    public CarreraRepository getInstanceCarreraRepository(){
        return  CarreraRepository.getInstance();
    }

    public EstudianteRepository getInstanceEstudianteRepository(){
        return  EstudianteRepository.getInstance();
    }
}
