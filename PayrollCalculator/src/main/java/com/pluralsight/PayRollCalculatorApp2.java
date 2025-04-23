package com.pluralsight;

import java.io.*;

public class PayRollCalculatorApp2 {

    public static void main(String[] args) {




        try {


            //time to create a file reader to get the files
            // call the new files in under the file reader from the csv folder
            FileReader fileInfo = new FileReader("src/main/resources/employees.csv");
            // create a BufferedReader to manage/buff the input
            BufferedReader buffStuff = new BufferedReader(fileInfo);

            String input;
            //creating input to buff on next line
            while ((input = buffStuff.readLine()) != null) {

                //enter the parts then split at the pike for cleaner look
                String[] inputParts = input.split("\\|");
                if (inputParts[0].equalsIgnoreCase("ID")) {
                    continue;
                }

                int ID = Integer.parseInt(inputParts[0]);
                String name = inputParts[1];
                double hoursWorked = Double.parseDouble(inputParts[2]);
                double payRate = Double.parseDouble(inputParts[3]);

                //employee object line
                //will include everything all categories
                Employee wrk = new Employee(ID, name, hoursWorked, payRate);

                //write out the final pay line
                System.out.printf("Employee: %s (ID: %d) - Gross Pay: $%.2f%n",
                        wrk.getName(), wrk.getEmployeeId(), wrk.getGrossPay());



            }
        } catch ( Exception e){
            System.out.println(e.getMessage());
        }
    }
}


