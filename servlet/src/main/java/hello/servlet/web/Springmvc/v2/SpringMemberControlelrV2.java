package hello.servlet.web.Springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControlelrV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();


    @RequestMapping("/new-form")
    public ModelAndView newform(){
        return new ModelAndView("new-form");
    }

    @RequestMapping
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.getModel().put("members", members);

        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.getModel().put("member", member);
        mv.addObject("member", member);
        return mv;
    }
}
