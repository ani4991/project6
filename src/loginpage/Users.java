/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Lindsie Dinh
 */
public class Users {

    private String email;
    private String firstName;
    private String lastName;
    private String hashedPassword;
    private Date birthDate;
    private Date joinDate;

    public Users(BufferedReader bufferedReader) throws IOException{

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            email = line;
            line = bufferedReader.readLine();
            firstName = line;
            line = bufferedReader.readLine();
            lastName = line;
            line = bufferedReader.readLine();
            hashedPassword = line;
            line = bufferedReader.readLine();
            birthDate = new Date(line);
            line = bufferedReader.readLine();
            joinDate = new Date(line);
            
        }

    }

    public Users(String email) {
        this.email = email;
        this.firstName = "";
        this.lastName = "";
        this.hashedPassword = "";
        this.birthDate = new Date(0);
        this.joinDate = new Date();
    }

    public Users(String email, String hashedPassword) {
        this.email = email;
        this.firstName = "";
        this.lastName = "";
        this.hashedPassword = hashedPassword;
        this.birthDate = new Date(0);
        this.joinDate = new Date();
    }

    public Users(String email, String firstName, String lastName, String hashedPassword, Date birthDate, Date joinDate) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPassword = hashedPassword;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the hashedPassword
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /**
     * @param hashedPassword the hashedPassword to set
     */
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }

    public String saveFormat() {
        String result = "";
        result += email;
        result += firstName;
        result += lastName;
        result += hashedPassword;
        result += birthDate;
        result += joinDate;

        return result;
    }

}
