package iam.mfa.fleetmanagementsystem.jpa.domain.keys;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

import lombok.*;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 20:06
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@MappedSuperclass
public class InsuranceDbKey implements Serializable {
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, nullable = false, length = 36)
    private UUID uuid;
    @Column(name = "date_time")
    private LocalDateTime dateTime;

}
