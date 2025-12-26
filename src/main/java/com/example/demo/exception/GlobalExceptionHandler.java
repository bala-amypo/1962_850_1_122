// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import java.util.HashMap;
// import java.util.Map;

// @ControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
//         Map<String, Object> errorResponse = new HashMap<>();
//         errorResponse.put("success", false);
//         errorResponse.put("message", ex.getMessage());
//         errorResponse.put("status", HttpStatus.NOT_FOUND.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
//         Map<String, Object> errorResponse = new HashMap<>();
//         errorResponse.put("success", false);
//         errorResponse.put("message", ex.getMessage());
//         errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//     }

//     @ExceptionHandler(UsernameNotFoundException.class)
//     public ResponseEntity<Map<String, Object>> handleUsernameNotFoundException(UsernameNotFoundException ex) {
//         Map<String, Object> errorResponse = new HashMap<>();
//         errorResponse.put("success", false);
//         errorResponse.put("message", ex.getMessage());
//         errorResponse.put("status", HttpStatus.NOT_FOUND.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
//         Map<String, Object> errorResponse = new HashMap<>();
//         errorResponse.put("success", false);
//         errorResponse.put("message", "An internal error occurred");
//         errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//     }
// }


// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package org.springframework.http;

import java.net.URI;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.function.Consumer;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;

public class ResponseEntity<T> extends HttpEntity<T> {
   private final HttpStatusCode status;

   public ResponseEntity(HttpStatusCode status) {
      this((Object)null, (MultiValueMap)null, status);
   }

   public ResponseEntity(@Nullable T body, HttpStatusCode status) {
      this(body, (MultiValueMap)null, status);
   }

   public ResponseEntity(MultiValueMap<String, String> headers, HttpStatusCode status) {
      this((Object)null, headers, status);
   }

   public ResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, int rawStatus) {
      this(body, headers, HttpStatusCode.valueOf(rawStatus));
   }

   public ResponseEntity(@Nullable T body, @Nullable MultiValueMap<String, String> headers, HttpStatusCode statusCode) {
      super(body, headers);
      Assert.notNull(statusCode, "HttpStatusCode must not be null");
      this.status = statusCode;
   }

   public HttpStatusCode getStatusCode() {
      return this.status;
   }

   /** @deprecated */
   @Deprecated(
      since = "6.0"
   )
   public int getStatusCodeValue() {
      return this.getStatusCode().value();
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!super.equals(other)) {
         return false;
      } else {
         ResponseEntity<?> otherEntity = (ResponseEntity)other;
         return ObjectUtils.nullSafeEquals(this.status, otherEntity.status);
      }
   }

   public int hashCode() {
      return 29 * super.hashCode() + ObjectUtils.nullSafeHashCode(this.status);
   }

   public String toString() {
      StringBuilder builder = new StringBuilder("<");
      builder.append(this.status);
      HttpStatusCode var3 = this.status;
      if (var3 instanceof HttpStatus httpStatus) {
         builder.append(' ');
         builder.append(httpStatus.getReasonPhrase());
      }

      builder.append(',');
      T body = this.getBody();
      HttpHeaders headers = this.getHeaders();
      if (body != null) {
         builder.append(body);
         builder.append(',');
      }

      builder.append(headers);
      builder.append('>');
      return builder.toString();
   }

   public static BodyBuilder status(HttpStatusCode status) {
      Assert.notNull(status, "HttpStatusCode must not be null");
      return new DefaultBuilder(status);
   }

   public static BodyBuilder status(int status) {
      return new DefaultBuilder(status);
   }

   public static BodyBuilder ok() {
      return status(HttpStatus.OK);
   }

   public static <T> ResponseEntity<T> ok(@Nullable T body) {
      return ok().body(body);
   }

   public static <T> ResponseEntity<T> of(Optional<T> body) {
      Assert.notNull(body, "Body must not be null");
      return (ResponseEntity)body.map(ResponseEntity::ok).orElseGet(() -> {
         return notFound().build();
      });
   }

   public static HeadersBuilder<?> of(ProblemDetail body) {
      return new 1(body.getStatus(), body);
   }

   public static <T> ResponseEntity<T> ofNullable(@Nullable T body) {
      return body == null ? notFound().build() : ok(body);
   }

   public static BodyBuilder created(URI location) {
      return (BodyBuilder)status(HttpStatus.CREATED).location(location);
   }

   public static BodyBuilder accepted() {
      return status(HttpStatus.ACCEPTED);
   }

   public static HeadersBuilder<?> noContent() {
      return status(HttpStatus.NO_CONTENT);
   }

   public static BodyBuilder badRequest() {
      return status(HttpStatus.BAD_REQUEST);
   }

   public static HeadersBuilder<?> notFound() {
      return status(HttpStatus.NOT_FOUND);
   }

   public static BodyBuilder unprocessableEntity() {
      return status(HttpStatus.UNPROCESSABLE_ENTITY);
   }

   public static BodyBuilder internalServerError() {
      return status(HttpStatus.INTERNAL_SERVER_ERROR);
   }

   private static class DefaultBuilder implements BodyBuilder {
      private final HttpStatusCode statusCode;
      private final HttpHeaders headers;

      public DefaultBuilder(int statusCode) {
         this(HttpStatusCode.valueOf(statusCode));
      }

      public DefaultBuilder(HttpStatusCode statusCode) {
         this.headers = new HttpHeaders();
         this.statusCode = statusCode;
      }

      public BodyBuilder header(String headerName, String... headerValues) {
         String[] var3 = headerValues;
         int var4 = headerValues.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String headerValue = var3[var5];
            this.headers.add(headerName, headerValue);
         }

         return this;
      }

      public BodyBuilder headers(@Nullable HttpHeaders headers) {
         if (headers != null) {
            this.headers.putAll(headers);
         }

         return this;
      }

      public BodyBuilder headers(Consumer<HttpHeaders> headersConsumer) {
         headersConsumer.accept(this.headers);
         return this;
      }

      public BodyBuilder allow(HttpMethod... allowedMethods) {
         this.headers.setAllow(new LinkedHashSet(Arrays.asList(allowedMethods)));
         return this;
      }

      public BodyBuilder contentLength(long contentLength) {
         this.headers.setContentLength(contentLength);
         return this;
      }

      public BodyBuilder contentType(MediaType contentType) {
         this.headers.setContentType(contentType);
         return this;
      }

      public BodyBuilder eTag(@Nullable String etag) {
         if (etag != null) {
            if (!etag.startsWith("\"") && !etag.startsWith("W/\"")) {
               etag = "\"" + etag;
            }

            if (!etag.endsWith("\"")) {
               etag = etag + "\"";
            }
         }

         this.headers.setETag(etag);
         return this;
      }

      public BodyBuilder lastModified(ZonedDateTime date) {
         this.headers.setLastModified(date);
         return this;
      }

      public BodyBuilder lastModified(Instant date) {
         this.headers.setLastModified(date);
         return this;
      }

      public BodyBuilder lastModified(long date) {
         this.headers.setLastModified(date);
         return this;
      }

      public BodyBuilder location(URI location) {
         this.headers.setLocation(location);
         return this;
      }

      public BodyBuilder cacheControl(CacheControl cacheControl) {
         this.headers.setCacheControl(cacheControl);
         return this;
      }

      public BodyBuilder varyBy(String... requestHeaders) {
         this.headers.setVary(Arrays.asList(requestHeaders));
         return this;
      }

      public <T> ResponseEntity<T> build() {
         return this.body((Object)null);
      }

      public <T> ResponseEntity<T> body(@Nullable T body) {
         return new ResponseEntity(body, this.headers, this.statusCode);
      }
   }

   public interface BodyBuilder extends HeadersBuilder<BodyBuilder> {
      BodyBuilder contentLength(long contentLength);

      BodyBuilder contentType(MediaType contentType);

      <T> ResponseEntity<T> body(@Nullable T body);
   }

   public interface HeadersBuilder<B extends HeadersBuilder<B>> {
      B header(String headerName, String... headerValues);

      B headers(@Nullable HttpHeaders headers);

      B headers(Consumer<HttpHeaders> headersConsumer);

      B allow(HttpMethod... allowedMethods);

      B eTag(@Nullable String etag);

      B lastModified(ZonedDateTime lastModified);

      B lastModified(Instant lastModified);

      B lastModified(long lastModified);

      B location(URI location);

      B cacheControl(CacheControl cacheControl);

      B varyBy(String... requestHeaders);

      <T> ResponseEntity<T> build();
   }
}
