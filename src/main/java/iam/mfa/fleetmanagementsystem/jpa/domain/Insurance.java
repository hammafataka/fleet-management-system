package iam.mfa.fleetmanagementsystem.jpa.domain;

import java.util.List;

import javax.persistence.*;

import lombok.*;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:19
 */
@Data
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "insurance")
public class Insurance {
    @Id
    @Column(length = 128, name = "uuid")
    private String uuid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", referencedColumnName = "uuid")
    @ToString.Exclude
    private Vehicle vehicle;

    @Column(length = 128, name = "insurance_type")
    private String insuranceType;
    @ToString.Exclude
    @OneToMany(mappedBy = "uuid", fetch = FetchType.EAGER)
    private List<InsuranceBook> insuranceBooks;

}
