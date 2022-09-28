package io.oikk.member;


import static org.assertj.core.api.Assertions.assertThat;

import io.oikk.member.entity.Member;
import io.oikk.member.repository.MemberQueryRepository;
import io.oikk.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ActiveProfiles("test")
//@DataJpaTest
@ExtendWith(SpringExtension.class)
@Rollback(false)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private  MemberRepository repository;

    @Autowired
    MemberQueryRepository queryRepository;

    @DisplayName("JPA 맴버 등록 테스트")
    @Test
    void insertTest(){
        //given
        String name = "acj";

        Member member = Member.builder()
            .name(name)
            .age(10)
            .build();

        repository.save(member);

        //when
        Member savedMember = repository.findByName(name).orElseThrow(IllegalArgumentException::new);

        //then
        assertThat(savedMember.getName()).isEqualTo(name);
    }

    @DisplayName("QueryDSL 맴버 등록 테스트")
    @Test
    void insertQueryDSLTest(){
        //given
        String name = "acj2";

        Member member = Member.builder()
            .name(name)
            .age(10)
            .build();

        repository.save(member);

        //when
        Member savedMember = queryRepository.findByName(name);

        //then
        assertThat(savedMember.getName()).isEqualTo(name);
    }

}
