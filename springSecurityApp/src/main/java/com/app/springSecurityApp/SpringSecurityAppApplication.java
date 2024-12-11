package com.app.springSecurityApp;

import com.app.springSecurityApp.persistence.entity.PermissionEntity;
import com.app.springSecurityApp.persistence.entity.RoleEnum;
import com.app.springSecurityApp.persistence.entity.RolesEntity;
import com.app.springSecurityApp.persistence.entity.UserEntity;
import com.app.springSecurityApp.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
			SpringApplication.run(SpringSecurityAppApplication.class, args);
		}

		@Bean
		CommandLineRunner init(UserRepository userRepository) {
			return args -> {

				PermissionEntity createPermission = PermissionEntity.builder()
						.name("CREATE")
						.build();

				PermissionEntity readPermission = PermissionEntity.builder()
						.name("READ")
						.build();

				PermissionEntity updatePermission = PermissionEntity.builder()
						.name("UPDATE")
						.build();

				PermissionEntity deletePermission = PermissionEntity.builder()
						.name("DELETE")
						.build();

				PermissionEntity refactorPermission = PermissionEntity.builder()
						.name("REFACTOR")
						.build();

				RolesEntity roleAdmin = RolesEntity.builder()
						.roleEnum(RoleEnum.ADMIN)
						.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
						.build();

				RolesEntity roleUser = RolesEntity.builder()
						.roleEnum(RoleEnum.USER)
						.permissionList(Set.of(createPermission, readPermission))
						.build();

				RolesEntity roleInvited = RolesEntity.builder()
						.roleEnum(RoleEnum.INVITER)
						.permissionList(Set.of(readPermission))
						.build();

				RolesEntity roleDeveloper = RolesEntity.builder()
						.roleEnum(RoleEnum.DEVELOPER)
						.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
						.build();


				UserEntity userSantiago = UserEntity.builder()
						.username("santiago")
						.password("$2a$10$K4FrvT13mGP.z0WwUAmanOH05/bgDmy9JLVaF9BWatYlNNsT8IpYC")
						.isEnable(true)
						.isAccountNoExpired(true)
						.isAccountNoLocked(true)
						.credentialsNoExpired(true)
						.roles(Set.of(roleAdmin))
						.build();
				UserEntity userDaniel = UserEntity.builder()
						.username("daniel")
						.password("$2a$10$K4FrvT13mGP.z0WwUAmanOH05/bgDmy9JLVaF9BWatYlNNsT8IpYC")
						.isEnable(true)
						.isAccountNoExpired(true)
						.isAccountNoLocked(true)
						.credentialsNoExpired(true)
						.roles(Set.of(roleUser))
						.build();
				UserEntity userAndrea = UserEntity.builder()
						.username("andrea")
						.password("$2a$10$K4FrvT13mGP.z0WwUAmanOH05/bgDmy9JLVaF9BWatYlNNsT8IpYC")
						.isEnable(true)
						.isAccountNoExpired(true)
						.isAccountNoLocked(true)
						.credentialsNoExpired(true)
						.roles(Set.of(roleInvited))
						.build();
				UserEntity userAnyi = UserEntity.builder()
						.username("anyi")
						.password("$2a$10$K4FrvT13mGP.z0WwUAmanOH05/bgDmy9JLVaF9BWatYlNNsT8IpYC")
						.isEnable(true)
						.isAccountNoExpired(true)
						.isAccountNoLocked(true)
						.credentialsNoExpired(true)
						.roles(Set.of(roleDeveloper))
						.build();

				userRepository.saveAll(List.of(userSantiago,userDaniel,userAndrea,userAnyi));


		};
	}

}
