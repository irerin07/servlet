package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello" ,20);

        //when
        Member saved = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saved.getId());
        Assertions.assertThat(findMember).isEqualTo(saved);
    }

    @Test
    void findAll() {

        //given
        Member member = new Member("hello1" ,20);
        Member member1 = new Member("hello2" ,30);
        Member member2 = new Member("hello3" ,40);

        //when
        Member saved = memberRepository.save(member);
        Member saved1 = memberRepository.save(member1);
        Member saved2 = memberRepository.save(member2);

        //then
        List<Member> all = memberRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(3);
        Assertions.assertThat(all).contains(member, member1, member2);

    }
}
