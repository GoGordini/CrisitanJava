package edu.codoacodo.application.services;

import edu.codoacodo.application.adapters.IRepository;
import edu.codoacodo.domain.models.Usuario;
import edu.codoacodo.infraestructure.database.MySQLRepositoryImplement;

public class UsuarioService implements IRepository {

    private final IRepository repository = new MySQLRepositoryImplement();

    @Override
    public void saveUser(Usuario user) {
    }

    @Override
    public Usuario findByUserName(String username){
        return repository.findByUserName(username);
    }
}
