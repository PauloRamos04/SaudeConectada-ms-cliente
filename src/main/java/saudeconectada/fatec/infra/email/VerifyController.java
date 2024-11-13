package saudeconectada.fatec.infra.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import saudeconectada.fatec.domain.model.HealthProfessional;
import saudeconectada.fatec.domain.model.Patient;
import saudeconectada.fatec.domain.model.Verifiable;


import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RestController
@RequestMapping("auth")
public class VerifyController {

    @Autowired
    private VerifyService verifyService;

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam("token") String token, @RequestParam("userType") String userType) {
        try {
            UUID verificationToken = UUID.fromString(token);
            Class<? extends Verifiable> userClass;

            switch (userType.toLowerCase()) {
                case "patient":
                    userClass = Patient.class;
                    break;
                case "healthprofessional":
                    userClass = HealthProfessional.class;
                    break;
                default:
                    return createErrorRedirect("Tipo de usuário inválido.");
            }

            String message = verifyService.verifyUser(verificationToken, userClass);
            return createSuccessRedirect(message);

        } catch (IllegalArgumentException e) {
            return createErrorRedirect("Token inválido.");
        } catch (Exception e) {
            return createErrorRedirect("Erro ao autenticar usuário.");
        }
    }

    private ResponseEntity<String> createSuccessRedirect(String message) {
        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/verification-result.html?message=" + encodedMessage))
                .build();
    }

    private ResponseEntity<String> createErrorRedirect(String errorMessage) {
        String encodedMessage = URLEncoder.encode(errorMessage, StandardCharsets.UTF_8);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/verification-result.html?message=" + encodedMessage))
                .build();
    }
}
