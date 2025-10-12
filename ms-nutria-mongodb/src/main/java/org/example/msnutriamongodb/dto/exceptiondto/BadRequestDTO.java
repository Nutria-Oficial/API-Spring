package org.example.msnutriamongodb.dto.exceptiondto;

import java.util.Map;

public record BadRequestDTO(
    int status, String error, String messagem, Map<String, String> errors) {}
