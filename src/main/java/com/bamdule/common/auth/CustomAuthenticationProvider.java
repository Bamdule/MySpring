package com.bamdule.common.auth;

import com.bamdule.model.vo.MemberVO;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication auth) {
        String account = auth.getPrincipal().toString();
        String password = auth.getCredentials().toString();

        logger.info("Authenticate Try.. {} / {}", account, password);

        final Set<SimpleGrantedAuthority> roleNameSet = new HashSet<>();
        MemberVO memberVO = new MemberVO();

        roleNameSet.add(new SimpleGrantedAuthority("ADMIN"));
        memberVO.setAccount("Tester");
        memberVO.setRoles(roleNameSet);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(memberVO, "1234", memberVO.getAuthorities());
        logger.info("is authed? : {}", token.isAuthenticated());
        logger.info(token.toString());

        return token;
    }

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(UsernamePasswordAuthenticationToken.class);
    }

}
