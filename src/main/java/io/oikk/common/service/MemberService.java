package io.oikk.common.service;

import io.oikk.member.entity.Member;
import io.oikk.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository repository;

    public Member findByName (String name){
        return repository.findByName(name).orElseThrow(IllegalArgumentException::new);
    }

}
