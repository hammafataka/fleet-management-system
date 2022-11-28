package iam.mfa.fleetmanagementsystem.jpa.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import iam.mfa.fleetmanagementsystem.jpa.enums.VignetteType;

import lombok.*;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:26
 */
@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vignette")
public class Vignette implements Serializable {
    @Id
    @Column(length = 128, name = "uuid")
    private String uuid;
    @MapsId("uuid")
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "uuid")
    private Vehicle vehicle;
    @Column(length = 10, name = "vignette_amount")
    private Long vignetteAmount;
    @Column(length = 30, name = "vignette_type")
    private VignetteType vignetteType;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
