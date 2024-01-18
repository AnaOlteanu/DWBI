package com.example.frontenddwbi.service.impl;

import com.example.frontenddwbi.model.*;
import com.example.frontenddwbi.repository.*;
import com.example.frontenddwbi.service.RezervareService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service("rezervareService")
@AllArgsConstructor
@Slf4j
public class RezervareServiceImpl implements RezervareService {

    private final RezervareRepository rezervareRepository;
    private final AngajatRepository angajatRepository;
    private final DiscountRepository discountRepository;
    private final CameraRepository cameraRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<Rezervare> findAll() {
        List<Rezervare> rezervari = new LinkedList<>();
        rezervareRepository.findAll(Sort.by("idRezervare")).iterator().forEachRemaining(rezervari::add);
        return rezervari;
    }

    @Override
    public Page<Rezervare> findPaginated(Pageable pageable) {
        List<Rezervare> rezervari = findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Rezervare> list;
        if (rezervari.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, rezervari.size());
            list = rezervari.subList(startItem, toIndex);
        }
        Page<Rezervare> rezervarePage = new PageImpl<>(list, PageRequest.of(currentPage,
                pageSize), rezervari.size());
        return rezervarePage;
    }

    @Override
    public Rezervare save(Rezervare rezervare) {
        return rezervareRepository.save(rezervare);
    }

    @Override
    public List<Angajat> findAllAngajati() {
        return angajatRepository.findAll();
    }

    @Override
    public List<Discount> findAllDiscount() {
        return discountRepository.findAll();
    }

    @Override
    public List<Camera> findAllCamera() {
        return cameraRepository.findAll();
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void updateCameraRezervare(Long idRezervare) {
        cameraRepository.updateCameraRezervare(idRezervare);
    }


}
