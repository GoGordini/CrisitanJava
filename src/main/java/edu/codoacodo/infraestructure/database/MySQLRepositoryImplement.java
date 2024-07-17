package edu.codoacodo.infraestructure.database;

import edu.codoacodo.application.adapters.IRepository;
import edu.codoacodo.domain.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLRepositoryImplement implements IRepository {
    private Connection conexion;

    public MySQLRepositoryImplement(){
        this.conexion=DataBaseConnection.getConnection();
    }

    @Override
    public void saveUser(Usuario user) {
        String sql = "INSERT INTO users (username, password, email) VALUES (?,?,?)";

        try {
            PreparedStatement preparador = this.conexion.prepareStatement(sql);
            preparador.setString(1,user.getUsername());
            preparador.setString(2,user.getPassword());
            preparador.setString(3,user.getEmail());
            preparador.executeUpdate();
            //preparador.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Usuario findByUserName(String username) {
        String sql ="SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement preparador = this.conexion.prepareStatement(sql);
            preparador.setString(1,username);

            ResultSet tablaVirtual = preparador.executeQuery();

            if(tablaVirtual.next()){
                Usuario usuario = new Usuario();
                usuario.setId(tablaVirtual.getInt("id"));
                usuario.setUsername(tablaVirtual.getString("username"));
                usuario.setPassword(tablaVirtual.getString("password"));
                usuario.setEmail(tablaVirtual.getString("email"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
