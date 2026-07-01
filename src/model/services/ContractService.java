package model.services;
import model.entities.Contract;
import model.entities.Installment;
import java.time.LocalDate;
import java.util.List;

public class ContractService {
    OnlinePaymentService onlinePaymentService;
    List<Installment> list;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double amount = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            amount += onlinePaymentService.interest(amount, i);
            amount += onlinePaymentService.paymentFee(amount);
            contract.addList(new Installment(dueDate,amount, contract));
        }
    }
}
