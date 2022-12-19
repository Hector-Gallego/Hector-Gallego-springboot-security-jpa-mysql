package dev.hectorgallego.springbootsecurityjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbootSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityJpaApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner commandLineRunner(PostRepository post, UserRepository user, PasswordEncoder encoder, RoleRepository role){
		return args -> {
			post.save(new Post("spring security jpa","3453","contenido","juanito"));
			post.save(new Post("spring data jpa","556","contenido","juanito"));
			post.save(new Post("spring web jpa","4545","contenido","juanito"));

			role.save(new Role("ROLE_USER"));
			role.save(new Role("ROLE_ADMIN"));

			Role role1 = role.findById(1L).get();
			Role role2 = role.findById(2L).get();

			List<Role> roles1 = new ArrayList<>();
			roles1.add(role1);


			List<Role> roles2 = new ArrayList<>();
			roles2.add(role1);
			roles2.add(role2);
			
			User user1 = new User("user","user", roles1);
			User user2 = new User("admin","admin", roles2);

			user.save(user1);
			user.save(user2);

			
		};
	}

	*/
}


