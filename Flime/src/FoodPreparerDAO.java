

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodPreparerDAO {

    // Method to add a new food preparer
    public void addFoodPreparer(FoodPreparer foodPreparer) throws SQLException {
        String query = "INSERT INTO food_preparer (preparer_id, phone_number, first_name, last_name, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, foodPreparer.getPreparerId());
            stmt.setString(2, foodPreparer.getPhoneNumber());
            stmt.setString(3, foodPreparer.getFirstName());
            stmt.setString(4, foodPreparer.getLastName());
            stmt.setDouble(5, foodPreparer.getSalary());
            stmt.executeUpdate();
        }
    }

    // Method to retrieve all food preparers
    public List<FoodPreparer> getAllFoodPreparers() throws SQLException {
        List<FoodPreparer> foodPreparers = new ArrayList<>();
        String query = "SELECT * FROM food_preparer";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
             FoodPreparer foodPreparer = new FoodPreparer(
                 rs.getInt("preparer_id"), 
                 rs.getString("phone_number"), 
                 rs.getString("first_name"), 
                 rs.getString("last_name"), 
                 rs.getDouble("salary")
             );
                foodPreparer.setPreparerId(rs.getInt("preparer_id"));
                foodPreparer.setPhoneNumber(rs.getString("phone_number"));
                foodPreparer.setFirstName(rs.getString("first_name"));
                foodPreparer.setLastName(rs.getString("last_name"));
                foodPreparer.setSalary(rs.getDouble("salary"));
                foodPreparers.add(foodPreparer);
            }
        }
        return foodPreparers;
    }

    // Method to delete a food preparer by ID
    public void deleteFoodPreparer(int preparerId) throws SQLException {
        String query = "DELETE FROM food_preparer WHERE preparer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, preparerId);
            stmt.executeUpdate();
        }
    }
}
