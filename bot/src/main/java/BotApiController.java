import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
@Validated
public class BotApiController {

    @PostMapping("/tg-chat/{id}")
    public ResponseEntity<Object> registerChat(@Valid @RequestBody ChatRegistrationRequest chatRegistrationRequest) {
        // Обработка запроса на регистрацию чата
        return ResponseEntity.ok().build();
    }


}
