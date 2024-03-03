import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scrapper")
@Validated
public class ScrapperApiController {

    @PostMapping("/updates")
    public ResponseEntity<Object> sendUpdate(@Valid @RequestBody LinkUpdateRequest linkUpdateRequest) {
        // Обработка запроса и отправка обновления
        return ResponseEntity.ok().build();
    }


}
