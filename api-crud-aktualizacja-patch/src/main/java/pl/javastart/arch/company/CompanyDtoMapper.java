package pl.javastart.arch.company;

import org.springframework.stereotype.Service;

@Service
class CompanyDtoMapper {
    CompanyDto map(Company company) {
        CompanyDto dto = new CompanyDto();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setDescription(company.getDescription());
        dto.setCity(company.getCity());
        dto.setEmployees(company.getEmployees());
        dto.setTelephone(company.getTelephone());
        dto.setEmail(company.getEmail());
        return dto;
    }

    Company map(CompanyDto dto) {
        Company company = new Company();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setDescription(dto.getDescription());
        company.setCity(dto.getCity());
        company.setEmployees(dto.getEmployees());
        company.setTelephone(dto.getTelephone());
        company.setEmail(dto.getEmail());
        return company;
    }
}
