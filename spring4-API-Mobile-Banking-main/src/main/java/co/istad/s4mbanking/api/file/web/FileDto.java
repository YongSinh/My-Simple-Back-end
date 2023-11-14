package co.istad.s4mbanking.api.file.web;

import lombok.Builder;

@Builder
public record FileDto(String name,
                      String extension,
                      Long size,
                      String url,
                      String downloadUrl) {
}
