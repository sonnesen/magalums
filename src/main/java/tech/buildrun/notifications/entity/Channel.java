package tech.buildrun.notifications.entity;

import java.util.Objects;

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
@Table(name = "tb_channels")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "channelId")
@Builder
public class Channel {

    @Id
    private Long channelId;
    private String description;

    public enum Values {
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        PUSH(3L, "push"),
        WHATSAPP(4L, "whatsapp");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel() {
            return new Channel(id, description);
        }

        public Channel toChannel(final String description) {
            doValidation(description);
            return new Channel(id, description.toUpperCase());
        }

        private void doValidation(final String description) {
            Objects.requireNonNull(description, "Description cannot be null");
            if (description.isBlank()) {
                throw new IllegalArgumentException("Description cannot be blank");
            }
        }
    }

}
