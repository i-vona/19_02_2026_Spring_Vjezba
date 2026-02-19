package hr.java.spring.boot.Example.service;

import hr.java.spring.boot.Example.domain.Category;
import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.domain.SearchHardware;
import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.dto.SearchHardwareDTO;
import hr.java.spring.boot.Example.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware().stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    @Override
    public List<HardwareDTO> getHardwareByName(String hardwareName) {
        return hardwareRepository.getHardwareByName(hardwareName).stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    @Override
    public void saveNewHardware(HardwareDTO hardware) {
        hardwareRepository.saveNewHardware(convertHardwareDtoToHardware(hardware));
    }

    @Override
    public List<HardwareDTO> filterByParameters(SearchHardwareDTO searchHardwareDTO) {
        return hardwareRepository.filterByParameters(
                        convertSearchHardwareDtoToSearchHardware(searchHardwareDTO))
                .stream().map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(),
                hardware.getDescription(), hardware.getPrice(),
                hardware.getCategory().getName());
    }

    private Hardware convertHardwareDtoToHardware(HardwareDTO hardwareDTO) {
        Integer latestId =
                hardwareRepository.getAllHardware().stream()
                        .max((a1, a2) -> a1.getId().compareTo(a2.getId()))
                        .get().getId();

        return new Hardware(latestId + 1, hardwareDTO.getHardwareName(),
                hardwareDTO.getHardwareDescription(), hardwareDTO.getHardwarePrice(),
                Category.valueOf(hardwareDTO.getCategoryName()));
    }

    private SearchHardware convertSearchHardwareDtoToSearchHardware(SearchHardwareDTO searchHardwareDTO) {
        return new SearchHardware(
                searchHardwareDTO.getHardwareName(),
                searchHardwareDTO.getHardwareDescription(),
                searchHardwareDTO.getLowerPrice(),
                searchHardwareDTO.getUpperPrice(),
                Category.valueOf(searchHardwareDTO.getCategoryName()));
    }
    
}
