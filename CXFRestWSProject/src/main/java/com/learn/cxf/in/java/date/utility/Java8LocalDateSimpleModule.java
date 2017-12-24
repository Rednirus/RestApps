package com.learn.cxf.in.java.date.utility;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.map.ser.ToStringSerializer;

public class Java8LocalDateSimpleModule  extends SimpleModule{

	public Java8LocalDateSimpleModule(String name, Version version) {
		super(name, version);
		addSerializer(LocalDate.class, new JsonSerializer<LocalDate>() {
            @Override
            public void serialize(LocalDate value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
                ToStringSerializer.instance.serialize(value, jgen, provider);
            }
        });
        addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
                ToStringSerializer.instance.serialize(value, jgen, provider);
            }
        });
        addDeserializer(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                return LocalDate.parse(jp.getText());
            }
        });
        addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                return LocalDateTime.parse(jp.getText());
            }
        });
	}
}
