package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.domain.SearchHardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {
    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByName(String hardwareName);
    void saveNewHardware(Hardware hardware);
    List<Hardware> filterByParameters(SearchHardware searchHardware);
    Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id);
    boolean hardwareByIdExists(Integer id);
    boolean deleteHardwareById(Integer id);
}
