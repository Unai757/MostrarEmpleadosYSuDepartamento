package org.example;

import java.sql.*;


public class Main {

    public static void main(String[] args) {
        String sql = "SELECT EMPLEADO.NOMBRE as empleado_nombre,DEPARTAMENTO.NOMBRE as departamento_nombre FROM EMPLEADO JOIN DEPARTAMENTO ON EMPLEADO.DEPARTAMENTO_ID=DEPARTAMENTO.ID";

        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword());
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            System.out.println("Conectado con suceso!");


            while (resultSet.next()) {
                String empleado = resultSet.getString("empleado_nombre");
                String departamento = resultSet.getString("departamento_nombre");
                //double Salario=resultSet.getDouble("salario");
                System.out.println("El empleado es " + empleado + " su departamento es " + departamento);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

