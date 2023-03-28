package com.coderound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;




@lombok
public class TaxCalculator {
this.salary=salary;
salaryNet=salary/30;
    public Double getsalary() {
        return salary;
    }

    public void setsalary(Double salary) {
        this.salary = salary;
    }

    public Double calculateTax() {
        if (salaryNet <= 250000) {
            return 0.0;
        } else if (salaryNet <= 500000) {
            return (salaryNet - 250000) * 0.05;
        } else if (salaryNet <= 1000000) {
            return (salaryNet - 500000) * 0.1 + 12500.0;
        } else {
            return (salaryNet - 1000000) * 0.2 + 112500.0;
        }
    }
}