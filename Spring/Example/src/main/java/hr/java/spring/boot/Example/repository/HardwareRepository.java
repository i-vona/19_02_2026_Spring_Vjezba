package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.domain.SearchHardware;

import java.util.List;

public interface HardwareRepository {
    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByName(String hardwareName);
    void saveNewHardware(Hardware hardware);
    List<Hardware> filterByParameters(SearchHardware searchHardware);
}
