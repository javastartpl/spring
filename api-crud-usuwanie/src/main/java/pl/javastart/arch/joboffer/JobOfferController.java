package pl.javastart.arch.joboffer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/offers")
class JobOfferController {
    private final JobOfferService jobOfferService;
    private final ObjectMapper objectMapper;

    public JobOfferController(JobOfferService jobOfferService, ObjectMapper objectMapper) {
        this.jobOfferService = jobOfferService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{id}")
    ResponseEntity<JobOfferDto> getOfferById(@PathVariable Long id) {
        return jobOfferService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<JobOfferDto> saveOffer(@RequestBody JobOfferDto jobOfferDto) {
        JobOfferDto savedJobOffer = jobOfferService.saveOffer(jobOfferDto);
        URI savedJobOfferUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedJobOffer.getId())
                .toUri();
        return ResponseEntity.created(savedJobOfferUri).body(savedJobOffer);
    }

    @PatchMapping("/{id}")
    ResponseEntity<?> updateJobOffer(@PathVariable Long id, @RequestBody JsonMergePatch patch) {
        try {
            JobOfferDto jobOffer = jobOfferService.getOfferById(id).orElseThrow();
            JobOfferDto offerPatched = applyPatch(jobOffer, patch);
            jobOfferService.updateOffer(offerPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.internalServerError().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    private JobOfferDto applyPatch(JobOfferDto jobOffer, JsonMergePatch patch) throws JsonPatchException, JsonProcessingException {
        JsonNode jobOfferNode = objectMapper.valueToTree(jobOffer);
        JsonNode jobOfferPatchedNode = patch.apply(jobOfferNode);
        return objectMapper.treeToValue(jobOfferPatchedNode, JobOfferDto.class);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteJobOffer(@PathVariable Long id) {
        jobOfferService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }
}
