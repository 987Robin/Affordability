import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        Connection conn1 = null;
        Connection conn2 = null;
        Statement stmt1 = null;
        Statement stmt2 = null;
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;

        try {
            // Connect to first database
            String dbURL1 = "jdbc:mysql://localhost:3306/order";
            String username1 = "root";
            String password1 = "MySql@123";
            conn1 = DriverManager.getConnection(dbURL1, username1, password1);
            stmt1 = conn1.createStatement();

            System.out.println("Enter Your Email");
            String userEmail = sc.nextLine();
            String getUserId = "Select id from user where email = '"+userEmail +"'";
            resultSet1 = stmt1.executeQuery(getUserId);
            resultSet1.next();


            // Connect to remote database
            String dbURL2 = "jdbc:mysql://34.133.186.220:3306/inventory";
            String username2 = "root";
            String password2 = "";
            conn2 = DriverManager.getConnection(dbURL2, username2, password2);
            stmt2 = conn2.createStatement();

            // Get all items list from inventory
            String getItemList = "Select item_name, quantity from items";
            resultSet2 = stmt2.executeQuery(getItemList);

            while (resultSet2.next()) {
                System.out.println(resultSet2.getString(1) + " " + resultSet2.getInt(2));
           }

            System.out.println("Enter any one item");
            String userWantedItem = sc.nextLine();

            System.out.println("Enter item quantity");
            Integer userWantedQuantity = sc.nextInt();

            String updateOrderTable =
            "INSERT INTO orders (item_name, quantity, user_id) VALUES ('"+userWantedItem+"', '"+userWantedQuantity+"', '"+resultSet1.getInt(1)+"')";

            stmt1.executeUpdate(updateOrderTable);

            //Getting Quantity from inventory.item table

            String getInventoryQuantity = "select quantity from items where item_name = '"+userWantedItem+"'";

            resultSet2  = stmt2.executeQuery(getInventoryQuantity);
            resultSet2.next();

            Integer fianlAvailableQunatity = resultSet2.getInt(1) - userWantedQuantity;

            String updateInventory = "UPDATE items SET quantity = '"+fianlAvailableQunatity+"' WHERE item_name = '"+userWantedItem+"'";

            stmt2.executeUpdate(updateInventory);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            resultSet1.close();
            resultSet2.close();
            stmt1.close();
            stmt2.close();
            System.out.println("Succesfully placed order and Inventory got updated");
        }
    }
}