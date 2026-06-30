import model.entities.Contract;
import model.entities.Installment;
import model.services.PaypalService;
import model.services.ContractService;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US);
        List<Installment> list = new ArrayList<>();

        System.out.println("Enter the contract data:");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();
        Contract contract = new Contract(number, date, totalValue);
        System.out.print("Enter the number of installments: ");
        int installments = sc.nextInt();
        sc.nextLine();
        double amount = totalValue / installments;
        for(int i = 1; i <= installments; i++) {
            LocalDate dueDate = date.plusMonths(i);
            list.add(new Installment(dueDate, amount, contract));
        }
        System.out.println("Installments:");
        for (Installment installment : list) {
            System.out.println(dtf.format(installment.getDueDate()) + " - " );
        }


        sc.close();
    }
}