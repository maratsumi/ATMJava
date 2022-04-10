/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maraa
 */
public class ATMJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        String userId = " ", userPass = " ", createId = " ", createPass = " ";
        boolean loginReq = false;

        PrintLn("Welcome to Vitug's ATM Machine !");
        PrintLn("NOTE: Based off my original C++ version"):;

        while(!loginReq){
            char verify = 'n';
            char loginOpt = ' ';
            boolean verifyReq = false;

            PrintLn("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            PrintLn("* Kindly use the corresponding character when selecting *");
            PrintLn("Select an option from the menu below: ");
            PrintLn("l > Login");
            PrintLn("c > Create Account");
            PrintLn("q > Quit");
            Print("Input: ");

            try {
                loginOpt = reader.readLine().charAt(0);
            } catch (IOException ex){
                Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
            }

            switch (loginOpt){
                case 'l' | 'L':
                PrintLn("~~~~~~~~~~~~~~~~~~~~~~~~~~ Login ~~~~~~~~~~~~~~~~~~~~~~~~~~");
                PrintLn("REMINDER !!! Username and password are case sensitive");
                Print("Please enter your username: ");
                try {
                    userId = reader.readLine();
                } catch (IOException ex){
                    Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
                }
                Print("Please enter your password: ");
                try {
                    userPass = reader.readLine();
                } catch (IOException ex){
                    Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (userId.equals(createId) && userPass.equals(createPass)){
                    PrintLn("You have successfully logged in !");
                    loginReq = true;
                    break;
                } else {
                    PrintLn("Login failed !");
                    continue;
                }
                case 'c' | 'C':
                PrintLn("~~~~~~~~~~~~~~~~~~~~~ Account Creation ~~~~~~~~~~~~~~~~~~~~~");
                PrintLn("REMINDER !!! Spaces are not allowed. Username and password are case sensitive.");
                while (verify == 'n'){
                    verifyReq = false;
                    Print("Please enter your username: ");
                    try {
                        createId = reader.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Print("Please enter your password: ");
                    try {
                        createPass = reader.readLine();
                    } catch (IOException ex) {
                        Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    PrintLn("-----------------------------------------------------------");
                    PrintLn("Please verify if the following information is correct.");
                    PrintLn("Enter 'y' to proceed or 'n' to repeat the process");
                    PrintLn("Username: " + createId);
                    PrintLn("Password: " + createPass);
                    while (!verifyReq){
                        Print("Input: ");
                        try {
                            verify = reader.readLine().charAt(0);
                        } catch (IOException ex){
                            Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (verify == 'y'){
                            verifyReq = true;
                            break;
                        } else if (verify == 'n'){
                            verifyReq = true;
                            break;
                        } else {
                            PrintLn("You input an invalid character");
                            continue;
                        }
                    }
                    if (verify == 'y'){
                        break;
                    } else if (verify == 'n'){
                        PrintLn("-----------------------------------------------------------");
                        PrintLn("User request to restart process.");
                        PrintLn("Restarting...");
                        continue;
                    }
                }
                if (verify == 'y'){
                    PrintLn("Account created successfully !");
                    continue;
                }
                case 'q' | 'Q':
                PrintLn("Thank you for using this ATM Machine! The app will now exit.");
                System.exit(0);
                default:
                PrintLn("You input an invalid option, please try agian.");
                continue;
            }
        }

        char atmOpt = ' ';
        float accBal = 0, accDep = 0, accWtdrw = 0;
        boolean atmReq = false;

        while (!atmReq){
            PrintLn("-----------------------------------------------------------");
            PrintLn("* Kindly use the corresponding character when selecting *");
            PrintLn("Select an option from the menu below: ");
            PrintLn("d > Deposit Money");
            PrintLn("w > Withdraw Money");
            PrintLn("b > Account Balance");
            PrintLn("q > Quit");
            Print("Input: ");

            try {
                atmOpt = reader.readLine().charAt(0);
            } catch (IOException ex){
                Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
            }

            switch (atmOpt){
                case 'd' | 'D':
                Print("Deposit amount: $");
                try {
                    accDep = Float.parseFloat(reader.readLine());
                } catch (NumberFormatException ex){
                    PrintLn("Your input was invalid. Please try again.");
                    continue;
                } catch (IOException ex) {
                    Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
                }
                PrintLn("Successfully deposited $" + accDep);
                accBal = accBal + accDep;
                continue;
                case 'w' | 'W':
                Print("Withdraw amount: $");
                try {
                    accWtdrw = Float.parseFloat(reader.readLine());
                } catch (NumberFormatException ex){
                    PrintLn("Your input was invalid. Please try again.");
                    continue;
                } catch (IOException ex) {
                    Logger.getLogger(ATMJava.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (accBal - accWtdrw < 0){
                    PrintLn("Sorry, but you cannot withdraw $" + accWtdrw + " as you do not have enough money in the account.");
                    continue;
                } else {
                    PrintLn("Successfully withdrew $" + accWtdrw);
                    accBal = accBal - accWtdrw;
                    continue;
                }
                case 'b' | 'B':
                PrintLn("Your balance is: $" + accBal);
                continue;
                case 'q' | 'Q':
                PrintLn("Thank you for using this ATM Machine ! The app will now exit.");
                atmReq = true;
                default:
                PrintLn("You input an invalid option, please try again.");
                continue;
            }
        }
    }
    
    public static void PrintLn(String message){
        System.out.println(message);
    }
    public static void Print(String message){
        System.out.print(message);
    }
}
