package code.flatura.gramotagen.service;

import code.flatura.gramotagen.model.Dto.DiplomaDto;
import code.flatura.gramotagen.repository.DiplomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiplomaService {
    private DiplomaRepository diplomaRepository;

    public DiplomaService() {
    }

    @Autowired
    public DiplomaService(DiplomaRepository diplomaRepository) {
        this.diplomaRepository = diplomaRepository;
    }

    public List<DiplomaDto> getAll() {
        return diplomaRepository.findAll()
                .stream()
                .map(d -> new DiplomaDto(d.getType(), d.getPlace(), d.getPersonName(), d.getPersonSurname(), d.getCompetitionTitle(), d.getCompetitionDate()))
                .collect(Collectors.toList());
    }
}
