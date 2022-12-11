/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */



import modelo.Department;
import modelo.HourContract;
import modelo.Worker;
import entities.WorkerLevel;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author SHARK
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        String level;
        Date mesano=new Date();
        Calendar calendar = Calendar.getInstance();
        
        System.out.println("Enter department's name: ");
      
        Department dep = new Department();
        Worker worker=new Worker();
        
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");  
        SimpleDateFormat formatMes=new SimpleDateFormat("MM/yyyy"); 
        
             
        
        dep.setName(sc.next());
        
        System.out.println("Enter worker data:\nName:");
        worker.setName(sc.next());
        System.out.println("Level:");

        level=sc.next();
        
        WorkerLevel wlevel=WorkerLevel.valueOf(level);
        
        worker.setLevel(wlevel);
        
        System.out.println("Base salary: ");
        worker.setBase_salary(sc.nextDouble());
        
        System.out.println("How many contracts to this worker? ");
        int n=sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String dt;
            HourContract contrato=new HourContract();
            System.out.println(String.format("Enter contract #%d data:",i+1));
            System.out.println("Date (DD/MM/YYYY):");
            try {
                contrato.setDate(formatter.parse(sc.next()));
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Value per hour:");
            contrato.setValuePerHour(sc.nextDouble());
            System.out.println("Duration (hours):");
            contrato.setHours(sc.nextInt()); 
            
            worker.addContract(contrato);
        }
        System.out.println("Enter month and year to calculate income (MM/YYYY):");
        String mes=sc.next();
        

        mesano=formatMes.parse(mes);
        
        
        System.out.println("Name: "+worker.getName());
        
        System.out.println("Department: "+dep.getName());
               
        System.out.println(String.format("Income for %s:",mes));
        
        calendar.setTime(mesano);
        


        
        System.out.println(worker.income(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)));
        
        
        
        
        
        
     
        
        sc.close();
    }
}
