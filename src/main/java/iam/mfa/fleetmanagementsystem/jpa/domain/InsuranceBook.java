package iam.mfa.fleetmanagementsystem.jpa.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:21
 */
@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "insurance_book")
public class InsuranceBook implements Serializable {
    @Id
    @Column(length = 128, name = "uuid")
    private String uuid;
    @ManyToOne
    @JoinColumn(name = "insurance_id", referencedColumnName = "uuid")
    private Insurance insurance;
    @Column(length = 128, name = "from_whom")
    private String fromWhom;
    @Column(length = 128, name = "with_whom")
    private String withWhom;
    @Column(name = "date_time")
    private LocalDateTime dateTime;

}
