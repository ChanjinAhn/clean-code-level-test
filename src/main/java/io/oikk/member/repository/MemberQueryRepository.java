package io.oikk.member.repository;


import static io.oikk.member.entity.QMember.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.oikk.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Member findByName(String name){
        return queryFactory.selectFrom(member)
            .where(member.name.eq(name))
            .fetchOne();
    }
}
