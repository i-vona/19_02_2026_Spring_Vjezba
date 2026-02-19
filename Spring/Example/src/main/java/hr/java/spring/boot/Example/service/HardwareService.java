package hr.java.spring.boot.Example.service;

import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.dto.SearchHardwareDTO;

import java.util.List;

public interface HardwareService {
    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareByName(String hardwareName);
    void saveNewHardware(HardwareDTO hardware);
    List<HardwareDTO> filterByParameters(SearchHardwareDTO searchHardwareDTO);
}
