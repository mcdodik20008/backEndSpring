package backendspring.domain.user.service;

import backendspring.domain.auth.model.Role;
import backendspring.domain.auth.repository.RoleRepository;
import backendspring.domain.user.model.entity.User;
import backendspring.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.HashSet;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	

	private final RoleRepository roleRepository;
	

	//private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public User findUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	public User findUserByUserName(String userName) {
		return repository.findByUserName(userName);
	}

	public Page<User> getPage(Pageable pageable) {
		return repository.findAll(pageable);//.map(mapper::toViewRead);
	}

	public User getOne(Long id) {
		return getObject(id);//mapper.toViewRead();
	}

	public Long create(User view) {
		//var entity = mapper.fromViewCreate(view);
		return repository.save(view).getId();
	}

	public void update(Long id, User view) {
		var entity = getObject(id);
		//mapper.fromViewCreate(entity, view);
		entity.setActive(view.getActive());
		entity.setName(view.getName());
		entity.setEmail(view.getEmail());
		repository.save(entity);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public User getObject(Long id) {
		return repository.findById(id)
						.orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
								"Не найден пользователь с идентификатором " + id));
	}

	public User saveUser(User user) {
		user.setPassword(user.getPassword()/*bCryptPasswordEncoder.encode()*/);
		user.setActive(true);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
		return repository.save(user);
	}

}