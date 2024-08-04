package tech.buildrun.notifications.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "statusId")
@Builder
public class Status {

    @Id
    private Long statusId;
    private String description;

    public enum Values {
        PENDING(1L, "pending"),
        SENT(2L, "sent"),
        ERROR(3L, "error"),
        CANCELED(4L, "canceled");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Status toStatus() {
            return new Status(id, description);
        }
    }

}
