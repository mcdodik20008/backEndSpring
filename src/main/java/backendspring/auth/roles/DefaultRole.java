package backendspring.auth.roles;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public enum DefaultRole implements Role {
    ADMIN, EDITOR, VIEWER;

    private final Set<Role> children = new HashSet<>();

    static {
        ADMIN.children.add(VIEWER);
        EDITOR.children.add(VIEWER);
    }

    @Override
    public boolean includes(Role role) {
        return this.equals(role) || children.stream().anyMatch(r -> r.includes(role));
    }

    @Component("CommunityRole")
    @Getter
    static class SpringComponent {
        private final DefaultRole ADMIN = DefaultRole.ADMIN;
        private final DefaultRole EDITOR = DefaultRole.EDITOR;
        private final DefaultRole VIEWER = DefaultRole.VIEWER;
    }
}