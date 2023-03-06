package wave.security.springsecurityoauth2.domain;

import lombok.*;
import wave.security.springsecurityoauth2.domain.type.Role;
import wave.security.springsecurityoauth2.domain.type.SocialType;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    private String username;

    private String password;

    private String name;

    private String socialId;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private Role role;
}
