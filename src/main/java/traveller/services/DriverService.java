package traveller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import traveller.dtos.DriverDTO;
import traveller.model.Driver;
import traveller.model.DriverDetails;
import traveller.repositories.DriverDetailsRepository;
import traveller.repositories.DriverRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverService {

    @Autowired
    DriverDetailsRepository driverDetailsRepository;
    @Autowired
    DriverRepository driverRepository;

    public List<DriverDTO> findAllDrivers() {
        List<DriverDetails> loadedDrivers = driverDetailsRepository.findAll();
        List<DriverDTO> driversDTO = new ArrayList<>();
        for(DriverDetails d : loadedDrivers) {
            DriverDTO driverDTO = new DriverDTO();
            driverDTO.setId(d.getDriver().getId());
            driverDTO.setFirstName(d.getDriver().getFirstName());
            driverDTO.setLastName(d.getDriver().getLastName());
            driverDTO.setPhone(d.getPhone());
            driverDTO.setEmail(d.getEmail());
            driversDTO.add(driverDTO);
        }
        return driversDTO;
    }
    public boolean checkPhone(String phone) {

        Boolean check = driverDetailsRepository.isPhoneUsed(phone);
        return check != null ? check : false;
    }
    public boolean checkEmail(String email) {

        Boolean check = driverDetailsRepository.isEmailUsed(email);
        return check != null ? check : false;
    }
    public void addDriver(DriverDTO form) {

        Driver driver = new Driver();
        driver.setFirstName(form.getFirstName());
        driver.setLastName(form.getLastName());
        driverRepository.save(driver);
        DriverDetails driverDetails = new DriverDetails();
        driverDetails.setDriver(driver);
        driverDetails.setPhone(form.getPhone());
        driverDetails.setEmail(form.getEmail());
        driverDetailsRepository.save(driverDetails);
    }
}
