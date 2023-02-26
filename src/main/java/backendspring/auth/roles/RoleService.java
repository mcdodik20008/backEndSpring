package backendspring.auth.roles;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service("RoleService")
public class RoleService {

    private final UserRoleRepository userRoleRepository;

    public boolean hasAnyRole(Role... roles) {
        final Long userId = ((PlainAuthentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        final Set<UserRole> communityRoleTypes = userRoleRepository.findByUserId(userId);
        for (Role role : roles) {
            if (communityRoleTypes.stream().anyMatch(communityRoleType -> communityRoleType.getType().includes(role))) {
                return true;
            }
        }
        return false;
    }

}