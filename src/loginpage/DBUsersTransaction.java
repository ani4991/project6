/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

    public boolean compareToken(String email, String password) {
        Users user = userMap.get(email);
        if(user != null){
            return user.getHashedPassword().equals(password);
        } else {
            return false;
        }
        
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

    public void writeUser(Users user) {

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            writer.write(user.saveFormat());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
