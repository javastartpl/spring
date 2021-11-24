package pl.javastart.arch.joboffer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
class JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final JobOfferDtoMapper jobOfferDtoMapper;

    public JobOfferService(JobOfferRepository jobOfferRepository, JobOfferDtoMapper jobOfferDtoMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferDtoMapper = jobOfferDtoMapper;
    }

    Optional<JobOfferDto> getOfferById(Long id) {
        return jobOfferRepository.findById(id)
                .map(jobOfferDtoMapper::map);
    }

    JobOfferDto saveOffer(JobOfferDto jobOfferDto) {
        JobOffer jobOfferToSave = jobOfferDtoMapper.map(jobOfferDto);
        jobOfferToSave.setDateAdded(LocalDateTime.now());
        JobOffer savedJobOffer = jobOfferRepository.save(jobOfferToSave);
        return jobOfferDtoMapper.map(savedJobOffer);
    }

    @Transactional
    public Optional<JobOfferDto> updateOffer(Long id, JobOfferDto jobOfferDto) {
        return jobOfferRepository.findById(id)
                .map(target -> setEntityFields(jobOfferDto, target))
                .map(jobOfferDtoMapper::map);
    }

    private JobOffer setEntityFields(JobOfferDto source, JobOffer target) {
        if (source.getTitle() != null) {
            target.setTitle(source.getTitle());
        }
        if (source.getDescription() != null) {
            target.setDescription(source.getDescription());
        }
        if (source.getRequirements() != null){
            target.setRequirements(source.getRequirements());
        }
        if (source.getDuties() != null) {
            target.setDuties(source.getDuties());
        }
        if (source.getLocation() != null){
            target.setLocation(source.getLocation());
        }
        if (source.getMinSalary() != 0) {
            target.setMinSalary(source.getMinSalary());
        }
        if (source.getMaxSalary() != 0){
            target.setMaxSalary(source.getMaxSalary());
        }
        return target;
    }
}
