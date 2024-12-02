import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TriageQueue {
    public static int add(Patient patient, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    
            String patientLine = patient.getName() + "," +
                                 patient.getPhoneNumber() + "," +
                                 patient.getEmailAddress() + "," +
                                 patient.getBirthDate() + "," +
                                 patient.getPersonalHealthNumber() + "," +
                                 patient.getSeverity();
            
            bufferedWriter.write(patientLine);
            bufferedWriter.newLine();
            
            bufferedWriter.close();
    
            int position = getLineCount(file);
    
            System.out.println("Patient added successfully.");
            
            return position;
    
        } catch (IOException e) {
            System.out.println("Error: Could not write to the CSV file.");
            e.printStackTrace();
            return -1;
        }
    }
    
    public static void printTriageQueue(File file) {
        try {
            Scanner var1 = new Scanner(file);
            if (var1.hasNextLine()) {
                var1.nextLine();
            }

            while(var1.hasNextLine()) {
                String var2 = var1.nextLine();
                String[] var3 = var2.split(",");
                if (var3.length == 6) {
                    String var4 = var3[0];
                    String var5 = var3[1];
                    String var6 = var3[2];
                    String var7 = var3[3];
                    String var8 = var3[4];
                    String var9 = var3[5];
                    System.out.println("Name: " + var4);
                    System.out.println("Phone: " + var5);
                    System.out.println("Email: " + var6);
                    System.out.println("Birth Date: " + var7);
                    System.out.println("Personal Health Number: " + var8);
                    System.out.println("Severity: " + var9);
                    System.out.println("-------------------------------");
                } else {
                    System.out.println("Invalid CSV format at line: " + var2);
                }
            }

            var1.close();
        } catch (FileNotFoundException var10) {
            System.out.println("Error: CSV file not found.");
            var10.printStackTrace();
        }

   }

    public static int getLineCount(File file) {
        int lineCount = 0;
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not read from the CSV file.");
            e.printStackTrace();
        }

        return lineCount;
    }

    public static void remove(File file, int rowToRemove) {
        try {
            List<String> lines = new ArrayList<>();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }
            }

            if (rowToRemove > 0 && rowToRemove < lines.size() + 1) {
                lines.remove(rowToRemove - 1);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String line : lines) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
                System.out.println("Row " + rowToRemove + " has been removed.");
            } else {
                System.out.println("Invalid row number. Row " + rowToRemove + " does not exist.");
            }
            
        } catch (IOException e) {
            System.out.println("Error: Could not process the CSV file.");
            e.printStackTrace();
        }
    }

    public static void swapRows(File file, int row1, int row2) {
        try {
            List<String> lines = new ArrayList<>();
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    lines.add(scanner.nextLine());
                }
            }

            String temp = lines.get(row1);
            lines.set(row1, lines.get(row2));
            lines.set(row2, temp);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Rows swapped successfully.");
        } catch (IOException e) {
            System.out.println("Error: Could not read/write to the CSV file.");
            e.printStackTrace();
        }
    }
}