package edu.codoacodo.application.adapters;

import edu.codoacodo.domain.models.Usuario;
import edu.codoacodo.infraestructure.database.MySQLRepositoryImplement;

import java.util.Optional;

public interface IRepository {

    void saveUser(Usuario user);
    Usuario findByUserName(String username);
}
