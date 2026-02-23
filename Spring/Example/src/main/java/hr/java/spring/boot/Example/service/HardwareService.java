package hr.java.spring.boot.Example.service;

import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.dto.SearchHardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareByName(String hardwareName);
    void saveNewHardware(HardwareDTO hardware);
    List<HardwareDTO> filterByParameters(SearchHardwareDTO searchHardwareDTO);
    Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTO, Integer id);
    boolean hardwareByIdExists(Integer id);
    boolean deleteHardwareById(Integer id);
}
