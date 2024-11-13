package saudeconectada.fatec.domain.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginRequest {
    private String cpf;
    private String password;
}