package repositories;

import entities.UserExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserExperienceRepository extends JpaRepository<UserExperience, Long> {
}
