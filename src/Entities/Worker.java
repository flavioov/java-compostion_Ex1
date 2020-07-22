package Entities;

import Entities.Enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    //Object composition --> uml
    /*
     * basic atributes
     * */
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    /*
     * Associations
     *
     * - A worker has a 'department'
     *
     * - A worker has multiple 'contracts'
     * */
    private Department department;

    //a lista deve ser instanciada - será instanciada por padrão
    //the compositon - has many - is instantiated as a list and
    //do not integrates the constructor
    private final List<HourContratct> contracts = new ArrayList<HourContratct>();


    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
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

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContratct> getContracts() {
        return contracts;
    }

    public void addContract(HourContratct contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContratct contract) {
        contracts.remove(contract);
    }

    public double income(int year, int month) {
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();

        for (HourContratct contract : contracts) {
            cal.setTime(contract.getDate());
            int contract_year = cal.get(Calendar.YEAR);
            int contract_month = 1 + cal.get(Calendar.MONTH) ;

            if (year == contract_year && month == contract_month) {
                sum += contract.totalValue();
            }
        }
        return sum;
    }
}
