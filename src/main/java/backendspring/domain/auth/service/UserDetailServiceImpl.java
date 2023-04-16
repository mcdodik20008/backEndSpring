package backendspring.domain.auth.service;

//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//
//	@Autowired
//	private UserService userService;
//
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userService.findUserByUserName(username);
//		if(user == null) {
//			throw new UsernameNotFoundException(username);
//		}
//		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
//		return buildUserForAuthentication(user, authorities);
//	}
//
//	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
//		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
//		for (Role role : userRoles) {
//			roles.add(new SimpleGrantedAuthority(role.getRole()));
//		}
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
//		return grantedAuthorities;
//	}
//
//	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//				user.getActive(), true, true, true, authorities);
//	}
//}
