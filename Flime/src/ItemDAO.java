

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    // Method to add a new item
    public void addItem(Item item) throws SQLException {
        String query = "INSERT INTO item (item_id, name, price, category) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, item.getItemId());
            stmt.setString(2, item.getName());
            stmt.setDouble(3, item.getPrice());
            stmt.setString(4, item.getCategory());
            stmt.executeUpdate();
        }
    }

    // Method to retrieve all items
    public List<Item> getAllItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM item";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                    Item item = new Item(
                  rs.getInt("item_id"), 
                  rs.getString("name"), 
                  rs.getDouble("price"), 
                  rs.getString("category")
              );
                item.setItemId(rs.getInt("item_id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setCategory(rs.getString("category"));
                items.add(item);
            }
        }
        return items;
    }

    // Method to delete an item by ID
    public void deleteItem(int itemId) throws SQLException {
        String query = "DELETE FROM item WHERE item_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, itemId);
            stmt.executeUpdate();
        }
    }
}
