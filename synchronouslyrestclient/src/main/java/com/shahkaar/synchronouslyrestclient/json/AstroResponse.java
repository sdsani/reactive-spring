package com.shahkaar.synchronouslyrestclient.json;

import java.util.List;

public record AstroResponse(String message, int number, List<Assignment> people) {
}
