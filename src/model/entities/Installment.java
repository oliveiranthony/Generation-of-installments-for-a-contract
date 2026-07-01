package model.entities;
import java.time.LocalDate;

public class Installment {
    private LocalDate dueDate;
    private Double amount;

    private Contract contract;

    public Installment() {
    }
    public Installment(LocalDate dueDate, Double amount, Contract contract) {
        this.dueDate = dueDate;
        this.amount = amount;
        this.contract = contract;
    }

    public LocalDate getDueDate() {
        return dueDate;
    } public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public Double getAmount() {
        return amount;
    } public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Contract getContract() {
        return contract;
    } public void setContract(Contract contract) {
        this.contract = contract;
    }
}
