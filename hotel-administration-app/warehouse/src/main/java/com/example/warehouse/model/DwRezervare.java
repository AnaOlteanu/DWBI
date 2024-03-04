package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "dw_rezervare", uniqueConstraints = @UniqueConstraint(columnNames = {"id_camera", "id_hotel", "id_client", "id_data_rezervare"}))
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DwRezervare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_intrare")
    private Long idIntrare;

    @Column(name = "id_rezervare")
    private Long idRezervare;

    @Column(name = "nr_nopti")
    private Integer nrNopti;

    @Column(name = "nr_camere")
    private Integer nrCamere;

    @Column(name = "pret_total")
    private Double pretTotal;

    @ManyToOne
    @JoinColumn(name = "id_camera", nullable = false)
    private DwCamera camera;

    @ManyToOne
    @JoinColumn(name = "id_adresa", nullable = false)
    private DwAdresa adresa;

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private DwHotel hotel;

    @ManyToOne
    @JoinColumn(name = "id_discount", nullable = false)
    private DwDiscount discount;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private DwClient client;

    @ManyToOne
    @JoinColumn(name = "id_angajat", nullable = false)
    private DwAngajat angajat;

    @ManyToOne
    @JoinColumn(name = "id_data_rezervare", nullable = false, insertable = false, updatable = false, referencedColumnName = "id_timp")
    private DwTimp dataRezervare;

    @ManyToOne
    @JoinColumn(name = "id_data_checkin", nullable = false, insertable = false, updatable = false, referencedColumnName = "id_timp")
    private DwTimp dataCheckin;

    @ManyToOne
    @JoinColumn(name = "id_data_checkout", nullable = false, insertable = false, updatable = false, referencedColumnName = "id_timp")
    private DwTimp dataCheckout;

    public String beautyDate(Date data) {
        SimpleDateFormat dayMonthYear = new SimpleDateFormat("dd-MM-yyyy");
        return dayMonthYear.format(data);
    }
}
