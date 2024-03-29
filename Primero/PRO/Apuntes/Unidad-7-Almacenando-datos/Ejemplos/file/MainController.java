package sqliteDemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        String dbUrl = "jdbc:sqlite:/c:\\db\\tutorjoes.db";
        try {
            DbOperations dbOperations = new DbOperations(dbUrl);
            Scanner in = new Scanner(System.in);

            while (true) {
                System.out.println("SQLite Java CRUD Operation");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. Select");
                System.out.println("5. Exit");
                System.out.print("Enter a choice: ");
                int choice = in.nextInt();
                System.out.println("-----------------------------------------");

                switch (choice) {
                    case 1:
                        System.out.println("1. Insert New Data");
                        System.out.println("Enter Name : ");
                        String name = in.next();
                        System.out.println("Enter Age : ");
                        int age = in.nextInt();
                        System.out.println("Enter City : ");
                        String city = in.next();
                        dbOperations.insertData(name, age, city);
                        System.out.println("Data Inserted Successfully");
                        break;

                    case 2:
                        System.out.println("2. Update Data");
                        System.out.println("Enter ID : ");
                        int id = in.nextInt();
                        System.out.println("Enter Name : ");
                        String updName = in.next();
                        System.out.println("Enter Age : ");
                        int updAge = in.nextInt();
                        System.out.println("Enter City : ");
                        String updCity = in.next();
                        dbOperations.updateData(id, updName, updAge, updCity);
                        System.out.println("Data Updated Successfully");
                        break;

                    case 3:
                        System.out.println("3. Delete Data");
                        System.out.println("Enter ID : ");
                        int delId = in.nextInt();
                        dbOperations.deleteData(delId);
                        System.out.println("Data Deleted Successfully");
                        break;

                    case 4:
                        System.out.println("4. Print all Records");
                        ResultSet rs = dbOperations.getAllData();
                        while (rs.next()) {
                            int userId = rs.getInt("ID");
                            String userName = rs.getString("NAME");
                            int userAge = rs.getInt("AGE");
                            String userCity = rs.getString("CITY");
                            System.out.println(userId + " " + userName + " " + userAge + " " + userCity);
                        }
                        rs.close();
                        break;

                    case 5:
                        System.out.println("Thank You");
                        dbOperations.closeConnection();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Selection");
                        break;
                }
                System.out.println("-----------------------------------------");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

