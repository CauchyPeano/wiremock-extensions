package de.cauchypeano.wiremock;

import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlainTextRandomDataTransformer extends ResponseTransformer {

    private final Pattern randomPlaceholderPattern = Pattern.compile("\\$\\{.*?\\}");

    public Response transform(Request request, Response response, FileSource files, Parameters parameters) {

        String responseBody = response.getBodyAsString();

        String newResponseBody = replaceResponseWithRandomValues(responseBody);

        return Response.Builder.like(response)
                .but()
                .body(newResponseBody)
                .build();
    }

    private String replaceResponseWithRandomValues(String responseBody) {
        Matcher matcher = randomPlaceholderPattern.matcher(responseBody);
        String result = responseBody;

        while (matcher.find()) {
            String group = matcher.group();
            result = responseBody.replace(group, generateRandomValue(group));
        }

        return result;
    }

    private String generateRandomValue(String randomPattern) {
        return randomPattern + "!";
    }

    public String getName() {
        return "plain-text-random-data";
    }
}
