package rocks.zipcode.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocks.zipcode.domain.Rack;
import rocks.zipcode.repository.RackRepository;
import rocks.zipcode.service.dto.RackDTO;
import rocks.zipcode.service.mapper.RackMapper;

/**
 * Service Implementation for managing {@link Rack}.
 */
@Service
@Transactional
public class RackService {

    private final Logger log = LoggerFactory.getLogger(RackService.class);

    private final RackRepository rackRepository;

    private final RackMapper rackMapper;

    public RackService(RackRepository rackRepository, RackMapper rackMapper) {
        this.rackRepository = rackRepository;
        this.rackMapper = rackMapper;
    }

    /**
     * Save a rack.
     *
     * @param rackDTO the entity to save.
     * @return the persisted entity.
     */
    public RackDTO save(RackDTO rackDTO) {
        log.debug("Request to save Rack : {}", rackDTO);
        Rack rack = rackMapper.toEntity(rackDTO);
        rack = rackRepository.save(rack);
        return rackMapper.toDto(rack);
    }

    /**
     * Update a rack.
     *
     * @param rackDTO the entity to save.
     * @return the persisted entity.
     */
    public RackDTO update(RackDTO rackDTO) {
        log.debug("Request to update Rack : {}", rackDTO);
        Rack rack = rackMapper.toEntity(rackDTO);
        rack = rackRepository.save(rack);
        return rackMapper.toDto(rack);
    }

    /**
     * Partially update a rack.
     *
     * @param rackDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<RackDTO> partialUpdate(RackDTO rackDTO) {
        log.debug("Request to partially update Rack : {}", rackDTO);

        return rackRepository
            .findById(rackDTO.getId())
            .map(existingRack -> {
                rackMapper.partialUpdate(existingRack, rackDTO);

                return existingRack;
            })
            .map(rackRepository::save)
            .map(rackMapper::toDto);
    }

    /**
     * Get all the racks.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<RackDTO> findAll() {
        log.debug("Request to get all Racks");
        return rackRepository.findAll().stream().map(rackMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one rack by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<RackDTO> findOne(Long id) {
        log.debug("Request to get Rack : {}", id);
        return rackRepository.findById(id).map(rackMapper::toDto);
    }

    /**
     * Delete the rack by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Rack : {}", id);
        rackRepository.deleteById(id);
    }
}
