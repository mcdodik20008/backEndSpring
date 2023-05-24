package backendspring.infrasructure.view;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class IdsConverter implements AttributeConverter<Set<Long>, String> {

    @Override
    public String convertToDatabaseColumn(Set<Long> longs) {
        if (longs == null || longs.size() == 0)
            return "";
        return longs.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @Override
    public Set<Long> convertToEntityAttribute(String s) {
        if (s == null || s.isBlank())
            return Set.of();
        return Arrays.stream(s.split(",")).map(Long::valueOf).collect(Collectors.toSet());
    }

}
