/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import entities.WorkerLevel;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author SHARK
 */
public class Worker {
    private String name;
    private WorkerLevel level;
    private Double base_salary;
    
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();
    
    Date date=new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    Calendar calendar = Calendar.getInstance();
    
    
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<HourContract> contracts) {
        this.contracts = contracts;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(Double base_salary) {
        this.base_salary = base_salary;
    }
    
    public void addContract(HourContract contract){
        contracts.add(contract);
        
    }
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }
    public Double income(int year,int month){
        double salary=base_salary;
        
        for(HourContract c:contracts){

            calendar.setTime(c.getDate());
           
            
            if (year==calendar.get(Calendar.YEAR) && month==calendar.get(Calendar.MONTH)){
                salary+=c.totalValue();    
                
            }
            
        }
        return salary;    
    }
}


