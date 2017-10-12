/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logingame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Lindsie Dinh
 */
public class DBUsersTransaction {

    private Scanner scanUser;
    private HashMap<String, Users> userMap = new HashMap();
    private String fileName = "db.txt";

    public DBUsersTransaction() {
        readFile();
    }

    public Users compareToken(String email, String password) {
        Users user = userMap.get(email);
        if (user != null) {
            if (user.getHashedPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private void readFile() {

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Users user = new Users(bufferedReader);
            userMap.put(user.getEmail(), user);
            System.out.println(user);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void readUser() {

    }

    public boolean writeUser(Users user) {

        try (Writer writer = new BufferedWriter(new FileWriter(fileName, true))) {
            if (userMap.get(user.getEmail()) == null) {
                userMap.put(user.getEmail(), user);
                writer.write(user.saveFormat());
                return true;
            }
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
