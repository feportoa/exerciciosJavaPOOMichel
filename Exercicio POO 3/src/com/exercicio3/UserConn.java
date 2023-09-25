// https://www.youtube.com/watch?v=3OrEsC-QjUA
package com.exercicio3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exercicio3.DBConnection;

public class UserConn {

    public void CadastrarUser(User user) {

        String sql = "INSERT INTO users (nome, cpf, email, password, idade) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepState = DBConnection.getConn().prepareStatement(sql);
            prepState.setString(1, user.getNome());
            prepState.setString(2, user.getCpf());
            prepState.setString(3, user.getEmail());
            prepState.setString(4, user.getPasswd());
            prepState.setByte(5, user.getIdade());

            prepState.execute();
            prepState.close();

        } catch (SQLException err) {
            System.out.println("[ERROR]: " + err.getMessage());
        }
    }

    public ResultSet getUsers() {
        String sql = "SELECT * FROM users";

        try {
            PreparedStatement prepState = DBConnection.getConn().prepareStatement(sql);
            ResultSet res = prepState.executeQuery();
            while(res.next()) {
                System.out.println(res.getString(2));
            }
            prepState.close();
            return res;
        } catch(SQLException err){
            System.out.println(err.getMessage());
            return null;
        }
    }

}
