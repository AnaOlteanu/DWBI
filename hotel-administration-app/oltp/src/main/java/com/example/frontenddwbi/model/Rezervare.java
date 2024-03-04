package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rezervare")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rezervare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rezervare")
    private Long idRezervare;

    @Column(name = "data_rezervare")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataRezervare;

    @Column(name = "data_checkin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataCheckin;

    @Column(name = "data_checkout")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataCheckout;

    @Column(name = "nr_nopti")
    private Integer nrNopti;

    @Column(name = "nr_camere")
    private Integer nrCamere;

    @Column(name = "pret_total")
    private Double pretTotal;

    private String status;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "camera_rezervare",
            joinColumns = @JoinColumn(name = "id_rezervare"),
            inverseJoinColumns = @JoinColumn(name = "id_camera"))
    @ToString.Exclude
    private Set<Camera> camereRezervare;

    @ManyToOne
    @JoinColumn(name = "id_discount", nullable = false)
    private Discount discount;

    @OneToMany(mappedBy = "rezervare")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Plata> plati = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    @ToString.Exclude
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_angajat", nullable = false)
    @ToString.Exclude
    private Angajat angajat;

    public String beautyDate(Date data) {
        SimpleDateFormat dayMonthYear = new SimpleDateFormat("dd-MM-yyyy");
        return dayMonthYear.format(data);
    }

}
