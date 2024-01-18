package com.example.frontenddwbi.repository;

import com.example.frontenddwbi.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CameraRepository extends JpaRepository<Camera, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "update camera_rezervare_ro cr set cr.pret_per_noapte = (select c.pret " +
            "from camera c where c.id_camera = cr.id_camera) where cr.id_rezervare = :idRezervare")
    void updateCameraRezervare(@Param("idRezervare") Long idRezervare);
}
