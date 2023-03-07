# 스프링 시큐리티를 이용하여 소셜 로그인 하기

## 백엔드의 역할

- 프론트에서 소셜로그인 API를 이용하여 AccessToken을 얻어와 서버로 넘겨주어야 한다.
- AccessToken을 받은 서버는 토큰을 이용해 회원의 정보를 조회한다.

- AccessToken을 백에서 얻지 않는 이유는, CORS가 발생하기도 하고, 프론트와 백을 분리할 경우, 백에서는 AccessToken으로 정보를 얻어오는 역할만 한다.



## SecurityContextHolder로 부터 유저이름 빼오기

```
Optional.ofNullable(SecurityContextHolder.getContext())
        .map(SecurityContext::getAuthentication)
        .filter(Authentication::isAuthenticated) //인증 되었는지?
        .map(Authentication::getPrincipal)
        .map(BoardPrincipal.class::cast) //Principal의 구현체
        .map(BoardPrincipal::getUsername);

```
## UserDetailsService

```
@Bean
public UserDetailsService userDetailsService(String username) {
        return username -> userAccountRepository
                    .findById(username)
                    .map(UserAccountDto::from)
                    .map(BoardPrincipal::from)
                    .orElseThrow(() -> new UsernameNotFoundException); //인증 유저가 아닐때 터지는 예외
                    }
                    ```

