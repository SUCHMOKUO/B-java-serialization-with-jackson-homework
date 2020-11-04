package com.thoughtworks.capability.gtb.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Objects;

public class PersonAge {

    public static class Serializer extends StdSerializer<Integer> {

        public Serializer() {
            this(null);
        }

        public Serializer(Class<Integer> t) {
            super(t);
        }

        @Override
        public void serialize(Integer value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeNumber(Objects.isNull(value) ? 0 : value);
        }
    }
}
