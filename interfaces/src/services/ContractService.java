package services;

import entities.Contract;
import entities.Installment;

public class ContractService {
    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int months) {
        for (int i = 1; i <= months; i++) {
            double amount = contract.getTotalValue() / months;
            amount += paymentService.interest(amount, i);
            amount += paymentService.paymentFee(amount);

            Installment installment = new Installment(contract.getDate().plusMonths(i), amount);
            contract.getInstallments().add(installment);
        }
    }
}
