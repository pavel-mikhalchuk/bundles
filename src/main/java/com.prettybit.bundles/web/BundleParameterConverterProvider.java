package com.prettybit.bundles.web;

import com.prettybit.bundles.entity.Bundle;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleParameterConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
        return Bundle.class.isAssignableFrom(rawType) ? new ParamConverter<T>() {
            @Override
            public T fromString(String value) throws IllegalArgumentException {
                return rawType.cast(BundleParser.decodeAndParse(value));
            }

            @Override
            public String toString(T value) throws IllegalArgumentException {
                return value.toString();
            }
        } : null;
    }

}