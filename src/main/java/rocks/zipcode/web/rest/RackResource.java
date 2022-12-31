package rocks.zipcode.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rocks.zipcode.repository.RackRepository;
import rocks.zipcode.service.RackService;
import rocks.zipcode.service.dto.RackDTO;
import rocks.zipcode.web.rest.errors.BadRequestAlertException;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link rocks.zipcode.domain.Rack}.
 */
@RestController
@RequestMapping("/api")
public class RackResource {

    private final Logger log = LoggerFactory.getLogger(RackResource.class);

    private static final String ENTITY_NAME = "rack";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RackService rackService;

    private final RackRepository rackRepository;

    public RackResource(RackService rackService, RackRepository rackRepository) {
        this.rackService = rackService;
        this.rackRepository = rackRepository;
    }

    /**
     * {@code POST  /racks} : Create a new rack.
     *
     * @param rackDTO the rackDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new rackDTO, or with status {@code 400 (Bad Request)} if the rack has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/racks")
    public ResponseEntity<RackDTO> createRack(@RequestBody RackDTO rackDTO) throws URISyntaxException {
        log.debug("REST request to save Rack : {}", rackDTO);
        if (rackDTO.getId() != null) {
            throw new BadRequestAlertException("A new rack cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RackDTO result = rackService.save(rackDTO);
        return ResponseEntity
            .created(new URI("/api/racks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /racks/:id} : Updates an existing rack.
     *
     * @param id the id of the rackDTO to save.
     * @param rackDTO the rackDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated rackDTO,
     * or with status {@code 400 (Bad Request)} if the rackDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the rackDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/racks/{id}")
    public ResponseEntity<RackDTO> updateRack(@PathVariable(value = "id", required = false) final Long id, @RequestBody RackDTO rackDTO)
        throws URISyntaxException {
        log.debug("REST request to update Rack : {}, {}", id, rackDTO);
        if (rackDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, rackDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!rackRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        RackDTO result = rackService.update(rackDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, rackDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /racks/:id} : Partial updates given fields of an existing rack, field will ignore if it is null
     *
     * @param id the id of the rackDTO to save.
     * @param rackDTO the rackDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated rackDTO,
     * or with status {@code 400 (Bad Request)} if the rackDTO is not valid,
     * or with status {@code 404 (Not Found)} if the rackDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the rackDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/racks/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<RackDTO> partialUpdateRack(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody RackDTO rackDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Rack partially : {}, {}", id, rackDTO);
        if (rackDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, rackDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!rackRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<RackDTO> result = rackService.partialUpdate(rackDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, rackDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /racks} : get all the racks.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of racks in body.
     */
    @GetMapping("/racks")
    public List<RackDTO> getAllRacks() {
        log.debug("REST request to get all Racks");
        return rackService.findAll();
    }

    /**
     * {@code GET  /racks/:id} : get the "id" rack.
     *
     * @param id the id of the rackDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the rackDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/racks/{id}")
    public ResponseEntity<RackDTO> getRack(@PathVariable Long id) {
        log.debug("REST request to get Rack : {}", id);
        Optional<RackDTO> rackDTO = rackService.findOne(id);
        return ResponseUtil.wrapOrNotFound(rackDTO);
    }

    /**
     * {@code DELETE  /racks/:id} : delete the "id" rack.
     *
     * @param id the id of the rackDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/racks/{id}")
    public ResponseEntity<Void> deleteRack(@PathVariable Long id) {
        log.debug("REST request to delete Rack : {}", id);
        rackService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
