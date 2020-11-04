package com.thoughtworks.capability.gtb.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Date;

public class DateTimestamp {

    public static class Serializer extends StdSerializer<Date> {

        public Serializer() {
            this(null);
        }

        protected Serializer(Class<Date> c) {
            super(c);
        }

        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(value.getTime());
        }
    }

    public static class Deserializer extends StdDeserializer<Date> {

        protected Deserializer() {
            this(null);
        }

        public Deserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Date deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            return new Date(p.readValueAs(Long.class));
        }
    }
}
