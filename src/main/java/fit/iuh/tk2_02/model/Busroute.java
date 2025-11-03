package fit.iuh.tk2_02.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Busroute")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Busroute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "Start", nullable = false)
    private String startPoint;

    @Column(name = "End", nullable = false)
    private String endPoint;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private Integer priority;

    @Column(name = "StationNo")
    private Integer stationNo;
}

