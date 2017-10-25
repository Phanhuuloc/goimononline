package vn.menugo.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.model.Bill;
import vn.menugo.server.repo.BillRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BillServices {
    private final BillRepository billRepository;
    private final AndroidPushNotificationsService notificationsService;

    @Autowired
    public BillServices(BillRepository billRepository, AndroidPushNotificationsService notificationsService) {
        this.billRepository = billRepository;
        this.notificationsService = notificationsService;
    }

    public Bill findByUuid(UUID uuid) {
        return billRepository.findByUuid(uuid);
    }

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill createBill(Bill data, UUID pid) {
        Bill bill = billRepository.save(data);
        notificationsService.pushNotificationToDevice(pid);
        return bill;
    }

    public List<Bill> findAll() {
        return billRepository.findAll();
    }
}
