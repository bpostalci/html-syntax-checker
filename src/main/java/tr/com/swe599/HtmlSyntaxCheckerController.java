package tr.com.swe599;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j(topic = "html-syntax-checker")
@RestController
public class HtmlSyntaxCheckerController {

    private final HtmlSyntaxCheckerService htmlSyntaxCheckerService;

    HtmlSyntaxCheckerController(HtmlSyntaxCheckerService htmlSyntaxCheckerService) {
        this.htmlSyntaxCheckerService = htmlSyntaxCheckerService;
    }

    @RequestMapping(value = "/check-syntax")
    public String checkSyntax(@RequestBody String htmlPayload) {

        log.info("/check-syntax received payload: " + htmlPayload);

        CheckSyntaxDto dto = htmlSyntaxCheckerService.checkSyntax(htmlPayload);
        String responseJson = JsonHelper.toJsonString(dto);

        log.info("/check-syntax response: " + responseJson);

        return JsonHelper.toJsonString(dto);
    }
}
