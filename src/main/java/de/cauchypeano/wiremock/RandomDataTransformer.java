package de.cauchypeano.wiremock;

import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

public class RandomDataTransformer extends ResponseTransformer {

    public Response transform(Request request, Response response, FileSource files, Parameters parameters) {
        return null;
    }

    public String getName() {
        return "RandomDataTransformer";
    }
}
