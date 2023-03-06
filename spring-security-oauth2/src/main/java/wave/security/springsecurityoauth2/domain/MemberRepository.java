package wave.security.springsecurityoauth2.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import wave.security.springsecurityoauth2.domain.type.SocialType;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findBySocialTypeAndSocialId(SocialType socialType, String socialId);
}
