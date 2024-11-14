

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
    public static List<Item> getAllItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM item";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                    Item item = new Item(
                  rs.getInt("Item_ID"), 
                  rs.getString("Item_Name"), 
                  rs.getInt("Item_Price"), 
                  rs.getString("Category")
              );
                item.setItemId(rs.getInt("Item_ID"));
                item.setName(rs.getString("Item_Name"));
                item.setPrice( rs.getInt("Item_Price"));
                item.setCategory(rs.getString("Category"));
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
