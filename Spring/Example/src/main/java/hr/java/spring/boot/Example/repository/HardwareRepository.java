package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.domain.SearchHardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {
    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByName(String hardwareName);
    Optional<Hardware> getHardwareById(Long id);
    Hardware saveNewHardware(Hardware hardware);
    List<Hardware> filterByParameters(SearchHardware searchHardware);
    Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Long id);
    boolean hardwareByIdExists(Long id);
    boolean deleteHardwareById(Long id);
}
