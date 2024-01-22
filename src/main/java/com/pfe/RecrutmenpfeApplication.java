package com.pfe;

		import com.pfe.file.StorageService;
		import com.pfe.model.Role;
		import com.pfe.service.AccountService;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.CommandLineRunner;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.annotation.Bean;
		import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

		import javax.annotation.Resource;

@SpringBootApplication
public class RecrutmenpfeApplication implements CommandLineRunner {
	@Resource
	private StorageService  storageService;

	public static void main(String[] args) {
		SpringApplication.run(RecrutmenpfeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		storageService.deleteAll();
//		storageService.init();
		//accountService.save(new Role("ADMIN"));
//		accountService.save(new Role("ResponsableSociete"));
//		accountService.save(new Role("ResponsableCentre"));
//
//		accountService.save(new Role("Candidat"));
	}
//	@Bean
//    CommandLineRunner start(AccountService accountService){
//        return args->{
//
//           accountService.save(new Role("ADMIN"));
//           accountService.save(new Role("ResponsableSociete"));
//           accountService.save(new Role("ResponsableCentre"));
//
//           accountService.save(new Role("Candidat"));
//            //Stream.of("user1").forEach(un->{
//                //accountService.saveUser(un,"1234","1234","","","","","",
//                        //"","","","","","","");
//            //});
//            //accountService.addRoleToUser("user1","ResponsableCentre");
//
//
//
//        };
//   }

	@Bean
	BCryptPasswordEncoder getBCPE (){

		return new BCryptPasswordEncoder();
	}
}
