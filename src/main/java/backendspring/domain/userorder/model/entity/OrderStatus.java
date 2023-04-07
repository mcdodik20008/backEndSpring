package backendspring.domain.userorder.model.entity;

import lombok.Getter;

@Getter
public enum OrderStatus {
    DONE,
    CANCELLED,
    PROGRESS,
    EXPIRED
}
