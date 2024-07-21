package com.online.retailStore.Util;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.online.retailStore.UiResponse.DataException;
import lombok.extern.slf4j.Slf4j;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
@Slf4j
public class WSClientTemplate {

    public Object invokeRESTService(String url, Object data, MediaType mediaType, HttpMethod httpMethod) throws DataException, IOException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new WSClientErrorHandler());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(MediaType.parseMediaTypes("application/json"));
        headers.setContentType(mediaType);

        ResponseEntity<Object> out = null;
        HttpEntity<Object> entity = new HttpEntity<Object>(data, headers);


        out = restTemplate.exchange(url, httpMethod, entity, Object.class);


        //throwing error if the response is an error response
        if (!out.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            String responseJsonStr = objectMapper.writeValueAsString(out.getBody());

            JSONObject json = new JSONObject(responseJsonStr);
            log.info(responseJsonStr);
            throw new DataException(StringConstants.EXCEPTION, json.get("message").toString(), HttpStatus.resolve(Integer.parseInt(json.get("status").toString())));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJsonStr = objectMapper.writeValueAsString(out.getBody());
        JSONObject json = new JSONObject(responseJsonStr);

        return json.getJSONObject("entity");

    }


    public Object invokeUsbRESTService(String url, Object data, MediaType mediaType, HttpMethod httpMethod) throws IOException, DataException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new WSClientErrorHandler());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(MediaType.parseMediaTypes("application/json"));
        headers.setContentType(mediaType);

        ResponseEntity<Object> out = null;
        HttpEntity<Object> entity = new HttpEntity<Object>(data, headers);


        out = restTemplate.exchange(url, httpMethod, entity, Object.class);


        //throwing error if the response is an error response
        if (!out.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            String responseJsonStr = objectMapper.writeValueAsString(out.getBody());

            JSONObject json = new JSONObject(responseJsonStr);
            log.info(responseJsonStr);
            throw new DataException(StringConstants.EXCEPTION, json.get("message").toString(), HttpStatus.resolve(Integer.parseInt(json.get("status").toString())));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJsonStr = objectMapper.writeValueAsString(out.getBody());
        JSONObject json = new JSONObject(responseJsonStr);
        return json.getJSONObject("entity");
    }
    public Object invokeUsbRESTService(String url, MediaType mediaType, HttpMethod httpMethod) throws IOException, DataException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new WSClientErrorHandler());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(MediaType.parseMediaTypes("application/json"));
        headers.setContentType(mediaType);

        ResponseEntity<Object> out = null;
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);


        out = restTemplate.exchange(url, httpMethod, entity, Object.class);


        //throwing error if the response is an error response
        if (!out.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            String responseJsonStr = objectMapper.writeValueAsString(out.getBody());

            JSONObject json = new JSONObject(responseJsonStr);
            log.info(responseJsonStr);
            throw new DataException(StringConstants.EXCEPTION, json.get("message").toString(), HttpStatus.resolve(Integer.parseInt(json.get("status").toString())));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String responseJsonStr = objectMapper.writeValueAsString(out.getBody());
        JSONObject json = new JSONObject(responseJsonStr);
        return json.getJSONObject("entity");
    }


}
