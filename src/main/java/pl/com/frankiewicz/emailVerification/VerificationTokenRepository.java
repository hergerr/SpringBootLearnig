package pl.com.frankiewicz.emailVerification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findOneByToken(String token);
    Set<VerificationToken> findAllByUserIsEnabledFalse();
}
