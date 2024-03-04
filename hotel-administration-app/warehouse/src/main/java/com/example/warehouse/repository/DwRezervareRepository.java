package com.example.warehouse.repository;

import com.example.warehouse.model.DwRezervare;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DwRezervareRepository extends JpaRepository<DwRezervare, Long> {

    @Query(nativeQuery = true, value = "select * from dw_rezervare order by id_data_rezervare desc")
    List<DwRezervare> findAll();

    @Procedure
    void populate_adresa();

    @Procedure
    void populate_hotel();

    @Procedure
    void populate_camera();

    @Procedure
    void populate_client();

    @Procedure
    void populate_angajat();

    @Procedure
    void populate_discount();

    @Procedure
    void populate_timp(Date startTime, Date endTime);

    @Procedure
    void populate_rezervare(Date startTime, Date endTime);

    @Query(nativeQuery = true, value = "select *\n" +
            "from\n" +
            "    (select DENSE_RANK() \n" +
            "            OVER (ORDER BY COUNT(distinct r.id_rezervare) DESC) d_rank_desc, \n" +
            "           oras, COUNT(distinct r.id_rezervare) nr_rezervari\n" +
            "    from   dw_rezervare r, dw_adresa a, dw_timp t\n" +
            "    where  r.id_adresa = a.id_adresa\n" +
            "    and    r.id_data_rezervare = t.id_timp\n" +
            "    and    t.luna in ('2021-12', '2021-01') \n" +
            "    group by oras)\n" +
            "where d_rank_desc<=5")
    List<Object[]> firstQuery();

    @Query(nativeQuery = true, value = "SELECT id_timp, \n" +
            "       venit_zi,\n" +
            "       SUM(venit_zi) OVER  \n" +
            "          (ORDER BY id_timp \n" +
            "          ROWS UNBOUNDED PRECEDING) \n" +
            "          AS venit_pana_la_ziua_curenta,\n" +
            "       SUM(venit_zi) OVER \n" +
            "         (ORDER BY id_timp \n" +
            "          RANGE INTERVAL '7' DAY PRECEDING) \n" +
            "          AS venit_in_ultima_saptamana\n" +
            "FROM  (SELECT id_timp, \n" +
            "              SUM(r.pret_total*r.nr_nopti) venit_zi\n" +
            "       FROM   dw_rezervare r, dw_timp t\n" +
            "       WHERE  r.id_data_checkin = t.id_timp\n" +
            "       AND    t.luna in ('2021-06', '2021-07', '2021-08')\n" +
            "       GROUP BY id_timp)")
    List<Object[]> secondQuery();

    @Query(nativeQuery = true, value = "SELECT id_angajat ,id_data_rezervare, \n" +
            "       SUM(pret_total*nr_nopti) venit,\n" +
            "       ROUND(AVG(SUM(pret_total*nr_nopti))\n" +
            "           OVER (PARTITION BY id_angajat ORDER BY id_data_rezervare\n" +
            "           RANGE BETWEEN INTERVAL '15' DAY PRECEDING\n" +
            "                 AND INTERVAL '15' DAY FOLLOWING),2) \n" +
            "           AS MEDIE_CENTRATA_O_LUNA\n" +
            "FROM   dw_rezervare r, dw_timp t\n" +
            "WHERE  r.id_data_rezervare = t.id_timp\n" +
            "AND    id_angajat = 3\n" +
            "AND    an = 2021\n" +
            "GROUP BY id_angajat, id_data_rezervare")
    List<Object[]> thirdQuery();

    @Query(nativeQuery = true, value = "SELECT nume, data, valoare\n" +
            "FROM  (SELECT h.nume, id_timp as data, \n" +
            "              SUM(pret_total*nr_nopti) \n" +
            "                  AS valoare,\n" +
            "              MAX(SUM(pret_total*nr_nopti)) \n" +
            "                  OVER (PARTITION BY r.id_hotel) \n" +
            "                  AS vanz_max\n" +
            "       FROM   dw_rezervare r, dw_timp t, dw_hotel h\n" +
            "       WHERE  r.id_data_rezervare = t.id_timp\n" +
            "       AND    r.id_hotel = h.id_hotel\n" +
            "       AND    h.tip_hotel = 'R'\n" +
            "       AND    an = 2021\n" +
            "       GROUP BY h.nume,t.id_timp, r.id_hotel)\n" +
            "WHERE  valoare=vanz_max")
    List<Object[]> fourthQuery();

    @Query(nativeQuery = true, value = "SELECT tip_hotel,\n" +
            "      SUM(pret_total*nr_nopti)\n" +
            "          rezervari,\n" +
            "      SUM(SUM(pret_total*nr_nopti)) \n" +
            "          OVER () \n" +
            "          AS TOTAL_rezervari,\n" +
            "      round(RATIO_TO_REPORT(\n" +
            "          SUM(pret_total*nr_nopti)) \n" +
            "          OVER (), 6)\n" +
            "           AS RATIO_REP\n" +
            "FROM   dw_rezervare r, dw_hotel h\n" +
            "WHERE  r.id_hotel = h.id_hotel\n" +
            "GROUP BY tip_hotel")
    List<Object[]> fifthQuery();

}
