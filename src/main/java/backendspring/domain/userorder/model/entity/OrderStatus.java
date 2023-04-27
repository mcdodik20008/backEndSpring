package backendspring.domain.userorder.model.entity;

import lombok.Getter;

@Getter
public enum OrderStatus {
    DONE,
    CANCELLED,
    IN_PROGRESS,
    EXPIRED
}
