package com.promptous.json.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse implements PromptousJsonResponse {

    private String statusMessage;
}
