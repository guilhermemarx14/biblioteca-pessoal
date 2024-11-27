package com.poxete.biblioteca_pessoal.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.poxete.biblioteca_pessoal.exception.SerializadorException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.poxete.biblioteca_pessoal.config.Constantes.MENSAGEM_EXCEPTION_SERIALIZACAO;

@Log4j2
@IgnorarNoCoverage
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Serializador {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setDateFormat(new StdDateFormat());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
    }

    public static ObjectMapper getSerializer() {
        return objectMapper;
    }

    public static <T> T deserialize(String jsonString, Class<?>... clazz) {
        try {
            return objectMapper.readValue(jsonString, generateType(clazz));
        } catch (JsonProcessingException exception) {
            throw new SerializadorException(exception.getMessage());
        }
    }

    @SneakyThrows
    public static String serialize(Object jsonObject) {
        return objectMapper.writeValueAsString(jsonObject);
    }

    public static InputStream converterObjetoParaInputStream(Object obj) throws JsonProcessingException {
        try {
            return new ByteArrayInputStream(objectMapper.writeValueAsBytes(obj));
        } catch (JsonProcessingException e) {
            log.error(e);
            throw e;
        }
    }

    private static JavaType generateType(Class<?>... clazz) {
        if (clazz.length == 0) {
            throw new IllegalArgumentException(MENSAGEM_EXCEPTION_SERIALIZACAO);
        }
        if (clazz.length == 1) {
            return objectMapper.getTypeFactory().constructType(clazz[0]);
        }
        return gerarTipoRecursivamente(Arrays.asList(clazz));
    }

    private static JavaType gerarTipoRecursivamente(List<Class<?>> classes) {
        if (classes.size() == 2) {
            var classePrincipal = classes.get(0);
            var classeAdicional = classes.get(1);
            return objectMapper.getTypeFactory().constructParametricType(classePrincipal, classeAdicional);
        }
        var classePrincipal = classes.get(0);
        var classesAdicionais = new ArrayList<>(classes);
        classesAdicionais.removeFirst();
        var adicional = gerarTipoRecursivamente(classesAdicionais);
        return objectMapper.getTypeFactory().constructParametricType(classePrincipal, adicional);
    }

    public static boolean checarJSONValido(String json) {
        try {
            objectMapper.readTree(json);
        } catch (JacksonException e) {
            return false;
        }
        return true;
    }
}
