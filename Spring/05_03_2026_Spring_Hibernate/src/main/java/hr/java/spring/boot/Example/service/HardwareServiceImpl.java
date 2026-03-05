package hr.java.spring.boot.Example.service;

import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.domain.SearchHardware;
import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.dto.SearchHardwareDTO;
import hr.java.spring.boot.Example.repository.SpringDataHardwareRepository;
import hr.java.spring.boot.Example.repository.SpringDataCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private SpringDataHardwareRepository hardwareRepository;
    private SpringDataCategoryRepository categoryRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.findAll().stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    @Override
    public List<HardwareDTO> getHardwareByName(String hardwareName) {
        return hardwareRepository.findByName(hardwareName).stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();
    }

    @Override
    public HardwareDTO saveNewHardware(HardwareDTO hardwareDTO) {
        return convertHardwareToHardwareDTO(hardwareRepository.save(convertHardwareDtoToHardware(hardwareDTO)));
    }

    @Override
    public Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTO, Long id) {

        Optional<Hardware> hardwareToUpdate = hardwareRepository.findById(id);

        if (hardwareToUpdate.isPresent()) {
            Hardware hardware = hardwareToUpdate.get();

            hardware.setCategory(categoryRepository.findByName(hardwareDTO.getCategoryName()));
            hardware.setPrice(hardwareDTO.getHardwarePrice());
            hardware.setDescription(hardwareDTO.getHardwareDescription());
            hardware.setName(hardwareDTO.getHardwareName());

            Hardware updatedHardware = hardwareRepository.save(hardware);
            return Optional.of(convertHardwareToHardwareDTO(updatedHardware));
        }

        return Optional.empty();
    }

    @Override
    public boolean hardwareByIdExists(Long id) {
        return hardwareRepository.findById(id).isPresent();
    }

    @Override
    public boolean deleteHardwareById(Long id) {
        if (hardwareByIdExists(id)) {
            hardwareRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(),
                hardware.getDescription(), hardware.getPrice(),
                hardware.getCategory().getName());
    }

    private Hardware convertHardwareDtoToHardware(HardwareDTO hardwareDTO) {

        return new Hardware(
                null,
                hardwareDTO.getHardwareName(),
                hardwareDTO.getHardwareDescription(),
                hardwareDTO.getHardwarePrice(),
                categoryRepository.findByName(hardwareDTO.getCategoryName()));
    }
    
}
