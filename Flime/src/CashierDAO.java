/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CashierDAO {

    // Method to add a new cashier
    public void addCashier(Cashier cashier) throws SQLException {
        String query = "INSERT INTO cashier (cashier_id, phone_number, first_name, last_name, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, cashier.getCashierId());
            stmt.setString(2, cashier.getPhoneNumber());
            stmt.setString(3, cashier.getFirstName());
            stmt.setString(4, cashier.getLastName());
            stmt.setDouble(5, cashier.getSalary());
            stmt.executeUpdate();
        }
    }

    // Method to retrieve all cashiers
    public List<Cashier> getAllCashiers() throws SQLException {
        List<Cashier> cashiers = new ArrayList<>();
        String query = "SELECT * FROM cashier";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cashier cashier = new Cashier(rs.getInt("cashier_id"), rs.getString("phone_number"),
                              rs.getString("first_name"), rs.getString("last_name"), 
                              rs.getDouble("salary"));

                cashier.setCashierId(rs.getInt("cashier_id"));
                cashier.setPhoneNumber(rs.getString("phone_number"));
                cashier.setFirstName(rs.getString("first_name"));
                cashier.setLastName(rs.getString("last_name"));
                cashier.setSalary(rs.getDouble("salary"));
                cashiers.add(cashier);
            }
        }
        return cashiers;
    }

    // Method to delete a cashier by ID
    public void deleteCashier(int cashierId) throws SQLException {
        String query = "DELETE FROM cashier WHERE cashier_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, cashierId);
            stmt.executeUpdate();
        }
    }
}
